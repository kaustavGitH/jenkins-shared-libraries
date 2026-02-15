def call(String imageName, String tagName, String dockerHubUser){
  echo "Pushing image ${imageName}:${tagName} to docker hub"
   withCredentials([usernamePassword('credentialsId':"dockerHubCred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")]){
   sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
   sh "docker push ${dockerHubUser}/${imageName}:${tagName}"
   sh "docker push ${dockerHubUser}/${imageName}:latest"
}
}
