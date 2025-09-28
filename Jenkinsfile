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
                // Stop Tomcat
                sh 'sudo /opt/tomcat/bin/shutdown.sh || true'

                // Remove old WAR and exploded directory
                sh 'sudo rm -rf /opt/tomcat/webapps/webapp-jenkins*'

                // Deploy new WAR
                sh 'sudo cp target/webapp-jenkins.war /opt/tomcat/webapps/'

                // Start Tomcat
                sh 'sudo /opt/tomcat/bin/startup.sh'
            }
        }
    }
}
