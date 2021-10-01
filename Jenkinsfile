pipeline {

environment { 
       registry = "https://docker.io/snehaj12/helloworld" 
       registryCredential = 'snehaj12' 
       dockerImage = '' 
    }
    agent any
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
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
				 script { 
                  dockerImage = docker.build registry + ":$BUILD_NUMBER" 
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
