pipeline {
    agent any

    tools {
        jdk 'Java17'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PadmaNandavarapu/EmployeeApp.git'
            }
        }

        stage('Build') {
            steps {
                bat "mvn clean compile"
            }
        }

        stage('Test') {
            steps {
                bat "mvn test"
            }
        }

        stage('Package') {
            steps {
                bat "mvn package"
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}
