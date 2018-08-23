
node("docker-slave") {
    
	// Define the docker container variables to stop them at the end of the pipeline
    def sel_hub
    def sel_chrome
    def sel_firefox

	// In the preparation phase the three containers are run to parallelize the execution of chrome and firefox testing
    stage('Preparation') {
        sel_hub = docker.image('selenium/hub:3.4.0').run('-p 4444:4444 --name selenium-hub')
        sel_chrome = docker.image('selenium/node-chrome-debug:3.4.0').run('-p 5901:5900 --link selenium-hub:hub')
        sel_firefox = docker.image('selenium/node-firefox-debug:3.4.0').run('-p 5902:5900 --link selenium-hub:hub')
    }
    
	// Selenium test also run into containers. With inside the containers are automatically stop after execution
    stage('Checkout') {
      git 'https://github.com/nbhimnath/cucumberselenium.git'
      parallel (
        firefox: {
          docker.image('maven:3.3.9-jdk-8-alpine').inside { 
            stage('Test firefox') {
              sh 'mvn -B clean test -Dselenium.browser=firefox -Dsurefire.rerunFailingTestsCount=5 -Dsleep=0'
            }
          }
        },
        chrome: {
          docker.image('maven:3.3.9-jdk-8-alpine').inside { 
            stage('Test chrome') {
              sh 'mvn -B clean test -Dselenium.browser=chrome -Dsurefire.rerunFailingTestsCount=5 -Dsleep=0'
            }
          }
        }
      )
    }
    
	// Stop and remove the containers
    stage('Clean up') {
        sel_hub.stop()
        sel_firefox.stop()
        sel_chrome.stop()
    }
}
