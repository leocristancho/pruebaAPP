#!/usr/bin/env groovy
node() {
      try {
        stage('Descargar codigo') {
		    git url: 'https://github.com/leocristancho/pruebaAPP.git', branch: 'master'
        }
        
        stage('Prueba AppGate'){
        	withMaven(maven: 'maven3.8.4') {
                  bat "mvn clean verify"
                }  
        }

        currentBuild.result = "SUCCESS"
    } catch (e) {
      // If there was an exception thrown, the build failed
        currentBuild.result = "FAILED"
        throw e
    
    } finally {

    publishReport();
    sendSlackNotification(currentBuild.result);
    
    }
  
}

def publishReport(){
       publishHTML(target: [
        reportName : 'Serenity',
        reportDir:   'target/site/serenity',
        reportFiles: 'index.html',
        keepAll:     true,
        alwaysLinkToLastBuild: true,
        allowMissing: false
    ])
}

def sendSlackNotification(String buildStatus){
    
    def color = (buildStatus == 'FAILURE') ? '#BDFFC3' : '#FF0000'
    def msg =  "*API test results ${buildStatus}* - <${env.BUILD_URL}Serenity/|Report here!>"
    
    
    
    
    def cha = '#prueba-de-ingreso'
    
    slackSend(channel: cha, color: color, message: msg, teamDomain: 'proyectosleonardo.slack.com')
}