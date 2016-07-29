# SpringCloudPack

#Includes :

 Spring Cloud Stream
   
     -> Source Stream
   
     -> Sink Stream
     
 Spring CLoud Task



Requirements:

Zookeeper
Apache Kafka
Redis : Only for analytics like field-value-counters

Spring cloud dataflow Download 
https://github.com/spring-cloud/spring-cloud-dataflow

maven buid 
Spring cloud dataflow server local :

java -jar target/spring-cloud-dataflow-server-local-1.0.1.BUILD-SNAPSHOT.jar

Spring cloud dataflow shell :
java -jar target/spring-cloud-dataflow-shell-1.0.1.BUILD-SNAPSHOT.jar

DEMO SOURCE REGISTRATION(Http source)

dataflow:>app register --name httpinput --type source --uri maven://org.springframework.cloud.stream.app:http-source-kafka:1.0.0.BUILD-SNAPSHOT

DEMO SINK RESGISTRATION(file Sink)

dataflow:>app register --name file --type sink --uri maven://org.springframework.cloud.stream.app:file-sink-kafka:1.0.0.BUILD-SNAPSHOT

Create Stream
dataflow:>stream create httpstream --definition "httpinput --server.port=8085 | file --directory=/opt/final"

Deploye stream
dataflow:>stream deploy httpstream

(all this can be done by SCDF UI http://ip:9393/dashboard/index.html#/apps/apps) 

both UI ans Shell approach can be done only when SCDF local server , zookweeper server, kafka server are running 


Spring Cloud Stream:
 Create source , processors for transformation function and sink using spring boot application and run them.

 Source and sink uses kafka queue to produce and consume data , both of them should be launched(run) to run these applications .


 We can register stream application on SCDF as spring boot application using maven coordinates
  
  For above StreamSourceDemo, 
  we can register this app using 
  dataflow:>app register --name mysource --type source --uri maven://com.streamdemo:Streamdemo:0.0.1-SNAPSHOT

  Maven Coordinates should follow  maven://<groupId>:<artifactId>:<version>

  see: http://docs.spring.io/spring-cloud-dataflow/docs/1.0.0.RELEASE/reference/htmlsingle/#spring-cloud-dataflow-register-apps

  Spring cloud Task:

  Cloud task here in above solution , uses mysql as datasource. 
  All we need to do is , follow spring boot datasource conventions and create database named spring_cloud_task, spring cloud task will automatically find database and create tables, further it will log various things inside it. 
  No database source ,it will create normal java map,which could not be preserved after the process isntance is stopped.

  see : http://docs.spring.io/spring-cloud-task/1.0.0.M1/reference/htmlsingle/#getting-started

  To visualize things, i suggest : https://vimeo.com/172808512




