# SpringCloudPack 

Guide to begin with spring cloud stream,task and dataflow

#Includes :

 1. Spring Cloud Stream
   
     -> Source Stream
   
     -> Sink Stream
     
 2. Spring CLoud Task
 
 3. Spring Cloud Dataflow (SCDF)


# Spring Cloud Stream:

->  Create source , processors for transformation function and sink using spring boot application and run them.

 Source and sink uses kafka queue to produce and consume data , both of them should be launched(run) to run these applications .

Use mvn spring-boot:run or java -jar exec.jar to execute source and sink as different process

->  stream application can be register on SCDF as spring boot application using maven coordinates
  
  For above StreamSourceDemo(code), 
  
  -> this app can be registered using 
  
  dataflow:>app register --name mysource --type source --uri maven://com.streamdemo:Streamdemo:0.0.1-SNAPSHOT

  (Maven Coordinates should follow  maven://<groupId>:<artifactId>:<version>)

  Reference : http://docs.spring.io/spring-cloud-dataflow/docs/1.0.0.RELEASE/reference/htmlsingle/#spring-cloud-dataflow-register-apps

  # Spring cloud Task:

  Cloud task in above solution(code) , uses mysql as datasource. 
  
  All we need to do is , follow spring boot datasource conventions and create database named spring_cloud_task, spring cloud task will automatically find database and create tables, further it will log various things inside it. 
  If non of datasource is configured ,it will create normal java map,which could not be preserved after the process isntance is stopped.

  Reference : http://docs.spring.io/spring-cloud-task/1.0.0.M1/reference/htmlsingle/#getting-started

# Spring Cloud Dataflow (SCDF)

Requirements:

-> Zookeeper

-> Apache Kafka

-> Redis : Only for analytics like field-value-counters

 Download :Spring cloud dataflow  
 
 https://github.com/spring-cloud/spring-cloud-dataflow

maven buid 

Spring cloud dataflow server local :

java -jar target/spring-cloud-dataflow-server-local-1.0.1.BUILD-SNAPSHOT.jar

#Spring cloud dataflow shell :

java -jar target/spring-cloud-dataflow-shell-1.0.1.BUILD-SNAPSHOT.jar

  -> DEMO SOURCE REGISTRATION(Http source)

dataflow:>app register --name httpinput --type source --uri maven://org.springframework.cloud.stream.app:http-source-kafka:1.0.0.BUILD-SNAPSHOT

  -> DEMO SINK RESGISTRATION(file Sink)

dataflow:>app register --name file --type sink --uri maven://org.springframework.cloud.stream.app:file-sink-kafka:1.0.0.BUILD-SNAPSHOT

  -> Create Stream

dataflow:>stream create httpstream --definition "httpinput --server.port=8085 | file --directory=/opt/final"

  -> Deploye stream

dataflow:>stream deploy httpstream

(all this can be done using SCDF UI http://ip:9393/dashboard/index.html#/apps/apps) 

both UI ans Shell approach can be done only when SCDF local server , zookeeper server, kafka server are running 

 Reference : http://docs.spring.io/spring-cloud-dataflow/docs/1.0.1.BUILD-SNAPSHOT/reference/html/getting-started.html


  To visualize things, i suggest : https://vimeo.com/172808512



