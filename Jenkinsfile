pipeline {
    agent any

    tools {
        maven 'M3'    // make sure Maven is installed in Jenkins (Manage Jenkins → Global Tool Configuration)
        jdk 'JDK11'   // adjust to your installed JDK (e.g., JDK17, JDK8)
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PadmaNandavarapu/EmployeeApp.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                bat "mvn clean compile"
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat "mvn test"
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application...'
                bat "mvn package -DskipTests"
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Add your deploy script/command here
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished (success/failure).'
        }
        success {
            echo 'Build succeeded ✅'
        }
        failure {
            echo 'Build failed ❌'
        }
    }
}
