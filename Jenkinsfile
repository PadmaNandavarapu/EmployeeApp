pipeline {
    agent any

    tools {
        maven 'Maven3'   // matches the name in Jenkins Global Tool Config
        jdk 'Java17'     // matches the JDK name in Jenkins Global Tool Config
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
                bat "mvn package -DskipTests"
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                echo "Starting Spring Boot App..."
                bat "java -jar target/EmployeeApp.jar"
            }
        }
    }
}
