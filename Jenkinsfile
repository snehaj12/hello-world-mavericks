pipeline {

environment { 
       registry = "https://hub.docker.com/" 
       registryCredential = '75b25a17-f2cd-4bf4-92c5-acf82a040672' 
       dockerImage = 'helloworld' 
    }
    agent any
    tools {
        maven 'maven'
        
    }
	
    stages {
        stage ('Initialize') {
            steps {
               
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                
            }
        }

	stage('Cloning our Git') { 
          steps { 
              git 'https://github.com/snehaj12/hello-world-mavericks.git' 
          }

        }
        stage ('Build') {
            steps {
                sh 'mvn clean install -DskipTests=true -Dspring-boot.build-image.imageName=snehaj12/helloworld' 
				 script { 
                  dockerImage = docker.build registry
                }
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
		
		stage('Deploy our image') { 
          steps { 
              script { 
                  docker.withRegistry( '', registryCredential ) { 
                      dockerImage.push() 
                  }
              } 
          }
      } 

      stage('Cleaning up') { 
          steps { 
              sh "docker rmi $registry:$BUILD_NUMBER" 
          }

        } 
    }
}