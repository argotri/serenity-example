pipeline {
  agent any
  stages {
    stage('Run Automation') {
      parallel {
        stage('Chrome 83') {
          steps {
            sh 'mvn clean verify -Dbrowser=chrome -Dversion=83.0'
          }
        }

        stage('Firefox 76') {
          steps {
            sh 'mvn clean verify -Dbrowser=firefox -Dversion=76.0'
          }
        }

      }
    }

  }
}