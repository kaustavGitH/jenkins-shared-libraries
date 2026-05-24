def call(Map config = [:]) {
    def imageName = config.imageName ?: error("Image name is required")
    def imageTag = config.imageTag ?: 'latest'
    def dockerfile = config.dockerfile ?: 'Dockerfile'
    def context = config.context ?: '.'
    def dockerHubUser = config.dockerHubUser ?: error("Docker username is required")
    
    echo "Building Docker image: ${imageName}:${imageTag} using ${dockerfile}"
    
    sh """
        docker build -t ${dockerHubUser}/${imageName}:${imageTag} -f ${dockerfile} ${context} --no-cache
    """
}
