pipeline {

environment { 
       registry = "https://docker.io/v1/" 
       registryCredential = 'snehaj12' 
       dockerImage = '' 
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