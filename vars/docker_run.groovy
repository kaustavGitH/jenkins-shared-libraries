def call(Map config = [:]){
  def imageName = config.imageName ?: error ("Image name is required")
  def hostPort = config.hostPort ?: error ("Host port is required")
  def containerPort = config.containerPort ?: error ("Container port is required")
  def imageTag = config.imageTag ?: 'latest'
  def dockerHubUser = config.dockerHubUser ?: error ("Dockerhub user is required")

  echo "Running docker image: ${dockerHubUser}/${imageName}:${imageTag}"

  sh """
      docker run -d -p ${hostPort}:${containerPort} ${dockerHubUser}/${imageName}:${imageTag}
  """
}
