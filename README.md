# Spring Boot Microservices with Spring Cloud

#### Intro to Microservices

- [12factor.net](https://12factor.net/)
- What are microservices:
  - Microservices small targeted services 
  - Each service has its own repository 
  - Isolated from other services 
  - Should not be bundled with other services when deployed 
  - Loosely coupled 
  - When interacting with other services, should be done in a technology agnostic manner ie  Restful web services - HTTP / JSON
- With a Microservice Architecture:
  - Applications are composed using individual microservices 
  - Each service will typically have its own database 
  - Each microservice is independently deployable
  - Scaling of individual services is now possible 
  - CI/CD becomes easier since services are smaller and less complex to deploy
- Pros:
  - Easy to understand & develop - Services are smaller and more targeted 
  - Software Quality - Since services are more targeted and have a limited scope 
  - Scalability - Independent services can be scaled up and down to the application’s demands. 
  - Reliability - Software bugs are isolated 
  - Technology flexibility - Services can be developed using any language or technology stack. 
- Cons:
  - Integration testing can be difficult
  - Deployments are more complex. Rather than one application to deploy, you now have many. 
  - Operational cost with each service - Each service is a small application 
  - Needs own repo, own deployment process, own database, etc 
  - Additional hardware resources - Additional services need additional hardware to run on

- How big should a microservice be?
  - A microservice can be as small as a single API endpoint ie - ‘Get Orders’
  - A microservice can be several or even dozens of API endpoints
  - Answer is a topic of much debate
  - Guideline - Amazon’s Two Pizza Team - A microservice should be able to be supported be a team you can fed with two pizzas. (~12 people)
  - Scalability - This can also be a consideration in the size of a microservice
  - The higher the scalability, the more specialized the service should be

- Deployment tools
  - This is very large and diverse area!
  - AWS Beanstalk
  - AWS ECS / EKS
  - Kubernetes
  - Docker Swarm
  -  Red Hat OpenShift
  - Cloud Foundry

- Decomposing a monolith
- Strategies you can use:
  - By Business Capability - ie Order Service
  - By Domain Objects - ie Product Service (services over domain object ‘Product’)
  - By action verbs - Payment Service
  - By Nouns - Customer Service

- Single Responsibility Principle (SRP) is a term coined by Uncle Bob Martin about object oriented
  programming.
  - SRP says a class should have just one reason to change.
  - Meaning your classes should be very specific in what they do
  - Do one thing, and do it very well
- SRP can also be applied to microservices
  - Do one thing, and do it very well



##### Architecture and design

- Gateway
  - Endpoint that is exposed to other services
    - Can be internet for public APIs
    - More likely to be internal
  - Client calls URL, is unaware of routing taking place to running instance
  - Acts as roughly a proxy for network traffic
  - Can also act as a load balancer
- Service Instances
  - Expect to be running N number of services
  - Exact number depends on reliability and load requirements
  - Some tools allow you to dynamically scale based on load or anticipated load
- Database Tier
  - Typically one database per microservice
  - Highly scalable services will often have one transactional database
    - And one or more read database (replicas)
  - Organizations will often have more than one database technology
  - Not uncommon to see mix of SQL and NoSQL database technologies

- Messaging
  - A common pattern is to expose an API endpoint via a RESTFul API
  - Dependent microservices are often message based
  - Messages follow an event or command pattern
  - Messaging can be used to define a work flow
    - New Order, Validate Order, Charge Credit Card, Allocate Inventory, Ship Order

- Downstream Services
  - Often an action on a microservice will invoke actions on multiple down stream services results - search, sponsors, your history, logging your search, etc
  - Placing a new order might invoke the following:
    - Validate Order
    - Pay Credit Card
    - Allocate Inventory
    - Ship Order

##### 12 factor applications

- [12 factor applications](https://12factor.net/)



- I. Codebase
  - One codebase tracked in revision control, many deploys

- II. Dependencies
  - Explicitly declare and isolate dependencies

- III. Config
  - Store config in the environment

- IV. Backing services
  - Treat backing services as attached resources

- V. Build, release, run
  - Strictly separate build and run stages

- VI. Processes
  - Execute the app as one or more stateless processes

- VII. Port binding
  - Export services via port binding

- VIII. Concurrency
  - Scale out via the process model

- IX. Disposability
  - Maximize robustness with fast startup and graceful shutdown

- X. Dev/prod parity
  - Keep development, staging, and production as similar as possible

- XI. Logs
  - Treat logs as event streams

- XII. Admin processes
  - Run admin/management tasks as one-off processes

#### Spring MVC Restful Web Services