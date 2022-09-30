//Declarative pipeline
pipeline {
    agent any
    stages {
        stage("Checkout"){
            steps {
                echo "Clone the the source code"
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/KuruvaSomaSekhar/Sep22-code.git']]])
                sh "ls -la"
            }
        }
        stage("Build"){
            steps{
                echo "Here we build source code"
                sh '''mvn clean package
                ls -la target/
                    '''
            }
        }
        stage("Upload artifacts"){
            steps{
                echo "Upload artifacts to s3"
            }
        }
        stage("Check artifact"){
            steps{
                echo "Check artifacts"
            }
        }
    }
}