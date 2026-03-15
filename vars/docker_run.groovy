def call(Map config = [:]){
  def imageName = config.imageName ?: error ("Image name is required")
  def hostPort = config.hostPort ?: error ("Host port is required")
  def containerPort = config.containerPort ?: error ("Container port is required")

  echo "Running docker image: ${imageName}

  sh """
      docker run -d -p ${hostPort}:${containerPort} ${imageName}
  """
}
