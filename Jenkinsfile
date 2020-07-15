pipeline {
  triggers {
    	cron('0 */6 * * *')
	}
  agent any
  stages {
    stage('Run Automation') {
      parallel {
        stage('Chrome 83') {
          steps {
            sh 'mvn clean verify -Dbrowser=chrome -Dversion=83.0'
            sh 'echo whoami'
          }
          post {
            always {
              publishHTML(target: [
                  allowMissing         : false,
                  alwaysLinkToLastBuild: false,
                  keepAll              : true,
                  reportDir            : 'target/site/serenity/',
                  reportFiles          : 'index.html',
                  reportName           : "Chrome 83 Report"
                  ])
                 }
              }
        }

        stage('Firefox 76') {
          steps {
            sh 'mvn clean verify -Dbrowser=firefox -Dversion=76.0'
          }
          post {
            always {
              publishHTML(target: [
                  allowMissing         : false,
                  alwaysLinkToLastBuild: false,
                  keepAll              : true,
                  reportDir            : 'target/site/serenity/',
                  reportFiles          : 'index.html',
                  reportName           : "Firefox 76 Report"
             ])
            }
          }
        }

      }
    }

  }
}
