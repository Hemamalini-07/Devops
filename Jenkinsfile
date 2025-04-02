pipeline{
    agent any
        tools{
            jdk 'jdk17'
            maven 'maven'
        }
        stages{
            stage('Build Maven'){
                steps{
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Hemamalini-07/Devops']])
                    bat 'mvn clean install'
                }
            }
           
        }
}