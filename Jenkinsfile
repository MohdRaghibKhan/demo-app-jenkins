pipeline {
    agent any

    environment {
        TOMCAT_HOME = "/opt/tomcat"  // external Tomcat directory
        WAR_NAME = "webapp-jenkins.war"
    }

    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Stop Tomcat
                    sh "sudo ${TOMCAT_HOME}/bin/shutdown.sh || true"

                    // Remove old WAR and unpacked folder
                    sh "sudo rm -rf ${TOMCAT_HOME}/webapps/${WAR_NAME} ${TOMCAT_HOME}/webapps/webapp-jenkins/"

                    // Copy new WAR
                    sh "sudo cp target/${WAR_NAME} ${TOMCAT_HOME}/webapps/"

                    // Set proper permissions
                    sh "sudo chown -R tomcat:tomcat ${TOMCAT_HOME}/webapps/${WAR_NAME}"

                    // Start Tomcat
                    sh "sudo ${TOMCAT_HOME}/bin/startup.sh"
                }
            }
        }
    }

    post {
        failure {
            echo 'Build or deployment failed.'
        }
        success {
            echo 'Build and deployment completed successfully.'
        }
    }
}
