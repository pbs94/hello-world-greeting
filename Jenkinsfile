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
         sh 'mvn sonar:sonar -Dsonar.projectKey=example-project -Dsonar.host.url=http://localhost:9000 -Dsonar.login=925bae38153c0da939fc55d21ea686159bcbcb2d -Dsonar.java.binaries=target/classes';
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