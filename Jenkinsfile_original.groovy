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
                sh '''
                   aws s3 cp target/hello-*.war s3://sep2222/$JOB_NAME/master/$BUILD_NUMBER/
                   '''
            }
        }
        stage("Check artifact"){
            steps{
                echo "Check artifacts"
                sh "aws s3 ls s3://sep2222/$JOB_NAME/master/$BUILD_NUMBER/ "
            }
        }
    }
}