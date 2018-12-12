# Spring Cloud Example

## Running
Running order is significant

- run service registry project (eureka-server)
- run zipkin by `java -jar zipkin-server-2.11.9-exec.jar`
- run serviceA, serviceB, serviceC projects
- run additional service copies (local balancing test) with
  - `java -jar -Dserver.port=11001 serviceA.jar` (you can run from sources by `mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dserver.port=11001"`)
  - `java -jar -Dserver.port=12001 serviceB.jar` (you can run from sources by `mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dserver.port=12001"`)
  - `java -jar -Dserver.port=12002 serviceB.jar` (you can run from sources by `mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dserver.port=12002"`)
  - `java -jar -Dserver.port=13001 serviceC.jar` (you can run from sources by `mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dserver.port=13001"`)
  

## Demo & test

- endpoints available by gateway
  - http://localhost:8080/getA, http://localhost:8080/getAB, 
  http://localhost:8080/getAC, http://localhost:8080/getABC, http://localhost:8080/getACB
  - http://localhost:8080/getB, http://localhost:8080/getBA, 
  http://localhost:8080/getBC, http://localhost:8080/getBAC, http://localhost:8080/getBCA
  - http://localhost:8080/getC, http://localhost:8080/getCA, 
  http://localhost:8080/getCB, http://localhost:8080/getCAB, http://localhost:8080/getCBA
- service registry http://localhost:8761/
- zipkin http://localhost:9411/
- actuator health check http://localhost:8080/actuator, http://localhost:9091/actuator, 
http://localhost:9092/actuator, http://localhost:9093/actuator, 
http://localhost:8761/actuator, http://localhost:9411/actuator, 

## Setup

If you want to recreate at your own

### Services

For ServiceA, ServiceB and ServiceC
- [https://start.spring.io](https://start.spring.io) - select dependencies Web, Eureka Discovery, Ribbon, Sleuth, 
Zipkin Client, Actuator, DevTools
- update `application.properties` or `application.yaml`
- code and annotations like in example

### Service registry (Eureka server)
For Eureka Server
- [https://start.spring.io](https://start.spring.io) - select dependencies Eureka Server, Actuator
- update `application.properties` or `application.yaml`
- only one annotation needed `@EnableEurekaServer`

### API Gateway
- [https://start.spring.io](https://start.spring.io) - select dependencies Gateway, Eureka Discovery, Ribbon, Sleuth, 
Zipkin Client, Actuator, DevTools
- update `application.properties` or `application.yaml`
- no code update needed

## More info

- API Gateway configuration possibilities: https://cloud.spring.io/spring-cloud-gateway/single/spring-cloud-gateway.html
- Service registry client configuration https://cloud.spring.io/spring-cloud-netflix/multi/multi__service_discovery_eureka_clients.html
- Service registry server configuration https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html
- Short cheat sheet: https://marekszczepansky.github.io/Spring-5/2018/07/29/microservices.html
