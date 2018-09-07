def call(String buildStatus = 'STARTED') {

  // build status of null means successful
  buildStatus = buildStatus ?: 'SUCCESSFUL'

  // Default values
  def summary = "${env.JOB_NAME}\n${env.BUILD_URL}"

  // Override default values based on build status
  if (buildStatus == 'SUCCESSFUL') {
    //color = 'GREEN'
    colorCode = '#0B6623'
  } else if (buildStatus == 'STARTED') {
    //color = 'BLUE'
    colorCode = '#0F52BA'
    summary = "${buildstatus}: ${env.JOB_NAME}"
  } else {
    //color = 'RED'
    colorCode = '#9E1A1A'
  }

  // Send notifications
  slackSend (color: colorCode, message: summary)

}
