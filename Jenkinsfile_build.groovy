//declarative pipeline
pipeline {
    agent any
    stages {
        stage("clone code"){
            steps {
                echo "Here we clone code"
            }
        }
        stage("Build") {
            steps {
                echo "Here we build code"
           }
        }
        stage("Upload artifacts") {
            steps {
                echo "Upload artifacts to S3"
                }
            }
        stage("download artifacts") {
            steps {
                echo "Download artifacts"
            } 
        }
        stage("Deploy artifacts") {
            steps{
                echo "Here we deploy artifacts"
            }
        }
    }
}