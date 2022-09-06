pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '60259b37-7710-4d31-b925-b83c0136bf28', url: 'https://github.com/xue1587607907/springboot-ssm.git']]])
                echo 'Hello World'
            }
        }
        
        stage('build code') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
                echo 'Hello World'
            }
        }
    }
}
