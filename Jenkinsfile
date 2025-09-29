pipeline {
    agent any
    environment {
        CATALINA_HOME = '/opt/tomcat'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }  
        }
        stage('Deploy') {
            steps {
                echo 'Stopping Tomcat (ignore if not running)...'
                sh 'sudo ${CATALINA_HOME}/bin/shutdown.sh || true'

                echo 'Cleaning old deployment...'
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
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed. Check logs.'
        }
    }
}
