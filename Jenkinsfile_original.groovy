//Declarative pipeline
pipeline {
    agent any
    stages {
        stage("Checkout"){
            steps {
                echo "Clone the the source code"
            }
        }
        stage("Build"){
            steps{
                echo "Here we build source code"
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