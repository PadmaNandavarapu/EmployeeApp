pipeline {
    agent any

    tools {
        maven 'Maven3'    // Name must match Jenkins Global Tool Config
        jdk 'Java17'      // Name must match Jenkins Global Tool Config
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PadmaNandavarapu/EmployeeApp.git'
            }
        }

        stage('Build') {
            steps {
                bat "mvn clean install -DskipTests"
            }
        }

        stage('Test') {
            steps {
                bat "mvn test"
            }
        }

        stage('Publish TestNG Reports') {
            steps {
                publishTestNGResults testResultsPattern: '**/target/surefire-reports/testng-results.xml'
            }
        }

        stage('Package') {
            steps {
                bat "mvn package"
            }
        }

        stage('Archive Jar') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy step goes here (Docker, Tomcat, or Kubernetes)"
            }
        }
    }
}
