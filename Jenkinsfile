pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        gradle "gradle"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/edwincneira/test-pipeline-habi'

                // Run gradle on a Unix agent.
                sh "gradle clean test"

            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/serenity', reportFiles: 'index.html', reportName: 'Report Test', reportTitles: ''])
                }
            }
        }
    }
}
