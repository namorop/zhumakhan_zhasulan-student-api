pipeline {
    agent any
    environment {
        STUDENT = 'Zhumakhan Zhasulan'
        IMAGE = 'zhumakhan-zhasulan-student-api:v1.0-zhumakhan-zhasulan'
    }
    triggers {
        pollSCM('H/2 * * * *')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "Student: ${STUDENT}"
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test --no-daemon'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test --no-daemon'
            }
        }
        stage('Docker Build') {
            steps {
                sh "docker build -t ${IMAGE} ."
            }
        }
        stage('Verify') {
            steps {
                sh "docker image inspect ${IMAGE} > /dev/null"
                echo "Image ${IMAGE} built for ${STUDENT}"
            }
        }
    }
}
