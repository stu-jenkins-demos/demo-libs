def call(String project, String owner, String tag, String creds) {
    sh "echo ${owner}/${project}"
    sh "echo ${tag}"
    sh "echo ${creds}"

}