def call(String project, String owner, String tag, String creds) {
    sh "docker image build -t ${owner}/${project} ."
    sh "docker image build -t ${owner}/${project}-test -f Dockerfile.test ."
    sh "docker image build -t ${owner}/${project}-docs -f Dockerfile.docs ."
    sh "docker tag ${owner}/${project} ${owner}/${project}:${currentBuild.displayName}"
    sh "docker tag ${owner}/${project}-docs ${owner}/${project}-docs:${currentBuild.displayName}"
    sh "docker tag ${owner}/${project} ${owner}/${project}:beta"
    dockerLogin()
    sh "docker image push ${owner}/${project}:beta"
    sh "docker image push ${owner}/${project}-test"
    dockerLogout()
}