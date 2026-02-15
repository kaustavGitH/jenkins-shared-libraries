def call(String imageName, String tagname, String dockerHubUser){
  echo "This is pushing the image to docker hub"
   withCredentials([usernamePassword('credentialsId':"dockerHubCred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")]){
   sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
   sh "docker push ${dockerHubUser}/${imageName}:${tagname}"
   sh "docker push ${dockerHubUser}/${imageName}:latest"
}
}
