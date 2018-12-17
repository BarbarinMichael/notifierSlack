def call(String buildStatus = 'STARTED') {

    // Default values
    def summary = "${buildStatus}: ${env.JOB_NAME}"

    // Override default values based on build status
    if (buildStatus == 'SUCCESSFUL') {
        //color = 'GREEN'
        colorCode = '#0B6623'
        summary += "\n${env.BUILD_URL}"
    } else if (buildStatus == 'STARTED') {
        //color = 'BLUE'
        colorCode = '#0F52BA'
    } else {
        //color = 'RED'
        colorCode = '#9E1A1A'
        summary += "\n${env.BUILD_URL}"
    }

    // Send notifications
    slackSend(color: colorCode, message: summary)

}
