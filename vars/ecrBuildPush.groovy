def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()


    def awsCreds = getValueOrDefault("${config.awsCreds}","ecr_push_pull")
    echo awsCreds
    def awsRegion = getValueOrDefault("${config.awsRegion}","eu-west-1")
    def ecrRepo =  getValueOrDefault("${config.ecrRepo}","024942195839.dkr.ecr.eu-west-1.amazonaws.com/stubrownuk123")
    def ecrTag = getValueOrDefault("${config.ecrTag}","latest")
    def awscliContainer = getValueOrDefault("${config.awscliContainer}","mesosphere/aws-cli:1.14.5")
    def dockerContainer = getValueOrDefault("${config.dockerContainer}","docker:18.06")
    
    


    pipeline {
      agent {
        kubernetes {
          label 'dec_docker_build_and_publish'
          defaultContainer 'jnlp'
          yaml """
    apiVersion: v1
    kind: Pod
    metadata:
      labels:
        some-label: some-label-value
    spec:
      containers:
      - name: awscli
        image: ${awscliContainer}
        command:
        - cat
        tty: true
      - name: docker
        image: ${dockerContainer}
        command: ["cat"]
        tty: true
        volumeMounts:
        - mountPath: /var/run/docker.sock
          name: docker-socket
      volumes:
      - name: docker-socket
        hostPath:
          path: /var/run/docker.sock
          type: Socket
    """
        }
      }
      stages {
          stage('Build and push Image') {
              steps {
                  container('awscli'){
                      withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: ${awsCreds), secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                          script{
                              sh "aws ecr get-login --region ${awsRegion} --no-include-email > lgn"
                              env.dockerLogin = readFile 'lgn'
                          }
                      }
                  }
                  container('docker'){
                      sh "${env.dockerLogin}"
                      sh "docker build . -t ${ecrRepo}:${ecrTag}"
                      sh "docker push ${ecrRepo}:${ecrTag}"
                  }
              }
          }
      }
    }
}




