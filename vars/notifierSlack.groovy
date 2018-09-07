def call(String buildStatus = 'SUCCESSFUL') {

  // build status of null means successful
  buildStatus = buildStatus ?: 'SUCCESSFUL'

  // Default values
  def summary = "${buildStatus}: Job '${env.JOB_NAME} ${env.BUILD_URL}"

  // Override default values based on build status
  if (buildStatus == 'SUCCESSFUL') {
    color = 'GREEN'
    colorCode = '#0B6623'
  } else {
    color = 'RED'
    colorCode = '#9E1A1A'
  }

  // Send notifications
  slackSend (color: colorCode, message: summary)

}
