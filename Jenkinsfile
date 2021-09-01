node('master') {
    stage('Preparation') {
        git 'git@github.com:pbs94/hello-world-greeting.git'
    }
    stage('Build') {
        withMaven(maven: 'M3') {
            sh 'mvn -Dmaven.test.failure.ignore clean package'
        }
    }
}