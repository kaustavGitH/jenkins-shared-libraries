def call(String projectName, String tagname, String dockerHubUser){
  echo "This is building the code"
  sh "docker build -t ${dockerHubUser}/${projectName}:${tagname} ."
}
