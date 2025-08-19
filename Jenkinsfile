pipeline {
    agent any

    tools {
        maven 'maven-3.9'   // Must match Maven name in Jenkins Global Tool Config
        jdk 'jdk-17'        // Must match JDK name in Jenkins Global Tool Config
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

        stage('Deploy') {
            steps {
                echo "Deploy step goes here (Docker, Tomcat, or Kubernetes)"
            }
        }
    }
}
