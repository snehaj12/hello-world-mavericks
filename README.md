# hello-world-mavericks
It is a sample spring-boot application to demonstrate docker concepts.
Output: On running endpoint /home : "Hello World, from Team Mavericks" will be displayed

1. login to : https://labs.play-with-docker.com/ (for team members who are not able to install docker in local)
2. Start Docker session -> add new Instance
3. docker pull image-name:version  ==> to pull the image from docker hub
   eg: docker pull snehaj12/helloworld:0.0.1
4. docker images  ==> to display number of images pulled 
5. docker run -d --name image-name-alias you want -p port-to-bind:application-port image-name:image-version ==> to run the images pulled]
      e.g: docker run -d --name helloworldsj1 -p8081:8080 snehaj12/helloworld:0.0.1
6. docker ps  ==> to display containers running
7. Go To browser and run by clicking on port or by copying the IP from ssh cmd and adding port given in -p cmd.
   Append "/home" endpoint.
   eg: http://ip172-18-0-54-c4iuuhvnjsv000bnm9og-8081.direct.labs.play-with-docker.com/home
