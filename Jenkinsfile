pipeline {
    agent any

    tools {
        maven 'M398' // Ensure this Maven installation is configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Deepika5reddy/Java-RestAssured.git', branch: 'main'
            }
        }

        stage('Run API Tests') {
            steps {
                bat 'mvn clean test -Dmaven.test.failure.ignore=true'
            }
        }

        stage('List Report Files') {
            steps {
                bat 'dir target\\surefire-reports || echo Report folder missing'
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml',
                  allowEmptyResults: true,
                  skipPublishingChecks: true,
                  skipMarkingBuildUnstable: true
        }
    }
}
