pipeline {
    agent any
    environment {
        CATALINA_HOME = '/opt/tomcat'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building the Maven project...'
                sh 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Stopping Tomcat...'
                sh 'sudo ${CATALINA_HOME}/bin/shutdown.sh || true'

                echo 'Cleaning old deployments...'
                sh 'sudo rm -rf ${CATALINA_HOME}/webapps/webapp-jenkins*'

                echo 'Deploying new WAR...'
                sh 'sudo cp target/webapp-jenkins.war ${CATALINA_HOME}/webapps/'

                echo 'Starting Tomcat...'
                sh 'sudo ${CATALINA_HOME}/bin/startup.sh'
            }
        }
    }
    post {
        success {
            echo 'Deployment successful! App should be running on http://localhost:8081/webapp-jenkins/api/hello'
        }
        failure {
            echo 'Build or deployment failed. Check the logs.'
        }
    }
}
