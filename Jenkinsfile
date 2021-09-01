node('master') {
   stage('Preparation') {
      git 'git@github.com:pbs94/hello-world-greeting.git'
   }
   stage('Build & Unit test'){
      withMaven(maven: 'M3') {
         sh 'mvn clean verify -DskipITs=true'
      }
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
   stage('Static Code Analysis'){
      withMaven(maven: 'M3') {
         sh 'mvn clean verify sonar:sonar - Dsonar.projectName=example-project -Dsonar.projectKey=example-project -Dsonar.projectVersion=$BUILD_NUMBER';
      }
   }
   stage('Integration Test'){
      withMaven(maven: 'M3') {
         sh 'mvn clean verify -Dsurefire.skip=true'
      }
      junit '**/target/failsafe-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}