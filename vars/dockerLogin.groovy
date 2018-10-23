/**
 *
 * Simple login script for Docker
 * @param credid
 * @return
 */
def call(String credid) {
    if (credid == null) {
        credid = 'docker_creds'
    }

    echo "logging in using ${credid}"

    log.info("logging in using ${credid}")

    withCredentials([usernamePassword(credentialsId: credid, passwordVariable: 'dpassword', usernameVariable: 'duser')]) {
        sh "docker login -p ${dpassword} -u ${duser}"

    }
}