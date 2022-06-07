# microservicesProject

+ Java 17
+ Java records - immutable data class, private final fields, with getters.
+ Java Lombok - @Anotations for less boilerplate object code (constructors, getters, setters ...)
+ Maven multimodule - parent and inheriting child Poms (submodules can choose which dependiencs to import or force dependencies to all submodules)
+ Eureka (clients/Server) service discovery, manages microservice's ip:port addresses.
+ Load Banacers - (external) coordinate connections to instances of a server, (internal) messages between instances of services. typically managed by cloud service provider.

------------------------------------------------------------

microservices for business logic
easier deployment, easier team decoupling, breakdown, divide conqure, components
microservices are the new normal, small self contained ready to run applicaitons.   
see : https://spring.io/microservices for more details.
microservices can make requests to eachother

public network (client requests) --> load balancer (main entry point), routes requests to to microservice.
(spring has its own load balancer) 'usually you would not setup your own load balancer' to focus on own business logic.
same with 'databases' usually never host a database, use a database service. 

microservices have 'internal communictaions'

Kubernetes 'all the way' for taking an application to production, instead of : 
Eureka Server( manages ports), Config Server(development, testing envioment), 

Distruting tracing (tracks a requests journey), can be used to identify botlenecks.

typically 1 database per microservice

+ service discovery: Auto detection of devices and services on a network.
+ Eureka Server: has Eureka clients that {register, lookup, connect}, the server knows all the client's ip:port info.
the server is a bottleneck and a single point of failure.
ip:port info shouldn't be manged within the application, instead use 'service discovery'.
if a microservice gets too busy a second instance can be launched.

+ Load Balancers: (external from the private network) the main entry point, single point of failure, for production typically managed by a cloud service provider. (Aws, elastic, google cloud).
load balances for each set of instances of a microservice within the private network. 
external load balancers hava a selctable algorithm for which instance to send trafic to, (eg. round robin (1,2,1,2)).
health checkes - services return (status-code: 200) to the loadbalancer if OK.


------------------------------------------------------------




in the directory with the docker-compose.yml file:
$ docker-compose up -d        //detach, to start the docker compose container network

localhost:5050                <--- connect to pgAdmin through the terminal

httpie POST json customerRegistrationRequest:
 $ echo '{ "firstName": "Mark", "lastName": "Start", "email": "mark@email.com" }' | http POST localhost:8080/api/v1/customers

interactive shell login docker container:
 $ sudo docker exec –it [dockerContainerId] /bin/bash


-----------------------------------------------------------
change url in pom 
