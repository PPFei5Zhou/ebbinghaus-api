# Ebbinghaus api

## Setting git hook
```shell
git config core.hooksPath githooks
```


## Build and run
### Build spring boot
```shell
./gradlew clean build
```
### Unzip the project jar package
```shell
cd build/libs
jar -xf api.jar
cd ../..
```
### Build a Docker image
```shell
docker build -t ebbinghaus-api-docker .
```
### Run docker in local
```shell
docker run -d -p 8080:8080 -e "spring.profiles.active=dev" ebbinghaus-api-docker
```
stop docker container
```shell
docker container stop ebbinghaus-api-docker
```
### Push to personal docker hub
#### Tag the image name
```shell
docker tag ebbinghaus-api-docker 192.168.0.106:5000/ebbinghaus-api-docker
```
#### Push the image to docker hub
```shell
docker push 192.168.0.106:5000/ebbinghaus-api-docker
```
#### Pull the image to server
this command run in server
```shell
docker pull 192.168.0.106:5000/ebbinghaus-api-docker
```
#### Run docker in server
```shell
docker run -d -p 8080:8080 -e "spring.profiles.active=dev" --restart=always 192.168.0.106:5000/ebbinghaus-api-docker
```
### Show spring boot log in docker
```shell
docker logs -f 192.168.0.106:5000/ebbinghaus-api-docker
```