pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                sh 'cp target/webapp-jenkins.war /opt/tomcat10/webapp-jenkins/'
            }
        }
    }
}
