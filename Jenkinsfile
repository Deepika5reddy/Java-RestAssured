pipeline {
    agent any

    tools {
        maven 'M398'
    }

    stages {
        stage('Checkout') {
            steps {
               git url: 'https://github.com/Deepika5reddy/Java-RestAssured.git', branch: 'main'
            }
        }

        stage('Run API ests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('List Report Files') {
            steps {
                sh 'ls -la target/surefire-reports || echo "Report folder missing"'
            }
        }

        stage('Archive Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}
