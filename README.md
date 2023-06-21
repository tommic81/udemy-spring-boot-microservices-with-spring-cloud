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

#### Restful Web Services

##### Request Methods

- GET - is a request for a resource (html file, javascript file, image, etc) 
- GET - is used when you visit a website. 
- HEAD - is like GET, but only asks for meta information without the body. 
- POST - is used to post data to the server. 
- PUT - is a request for the enclosed entity be stored at the supplied URI. If the entity exists, it is expected to be updated. 
- POST is a create request 
- PUT is a create OR update request

- DELETE - Is a request to delete the specified resource
- TRACE - Will echo the received request. Can be used to see if request was altered by intermediate servers
- OPTIONS - Returns the HTTP methods supported by the server for the specified URL
- CONNECT - Converts the request to a transparent TCP/IP tunnel, typically for HTTPS through an unencrypted HTTP proxy 
- PATCH - Applies partial modifications to the specified resource

##### Safe Methods

- Safe Methods are considered safe to use because they only fetch information and do not cause changes on the server 
- The Safe Methods are: GET, HEAD, OPTIONS, and TRACE

##### Idempotent Methods

- Idempotence - A quality of an action such that repetitions of the action have no further effect on the outcome 
- PUT and DELETE are Idempotent Methods 
- Safe Methods (GET, HEAD, TRACE, OPTIONS) are also Idempotent 
- Being truly Idempotent is not enforced by the protocol

##### Non-Idempotent Methods

- POST is NOT Idempotent  
- Multiple Posts are likely to create multiple resources

#### HTTP Status Codes

- 100 series are informational in nature
- 200 series indicate successful request 
- 300 series are redirections 
- 400 series are client errors 
- 500 series are server side errors

#### Richardson Maturity Model

- Established by Leonard Richardson in a 2008 Q-Con Presentation 
- A model used to describe the maturity of RESTful services
- Unlike SOAP, there is no formal specification for REST 
- RMM is used to describe the quality of the RESTful service

##### Level 0: Swamp of POX

- POX - Plain Old XML 
- Uses implementing protocol as a transport protocol 
- Typically uses one URI and one kind of method 
- Examples - RPC, SOAP, XML-RPC

##### Level 1: Resources

- Uses Multiple URIs to identify specific resources 

- Examples: 
  - http://www.example.com/product/1234 
  - http://www.example.com/product/5687 

- Still uses a single method (ie GET)

##### Level 2: HTTP Verbs

- HTTP Verbs are used with URIs for desired actions 
- Examples: 
  - GET /products/1234 - to return data for product 1234 
  - PUT /products/1234 (with XML body) to update data for product 1234 
  - DELETE /products/1234 to delete product 1234 

- Most common in practical use

##### Level 3: Hypermedia

- Representation now contains URIs which may be useful to consumers 
- Helps client developers explore the resource 
- No clear standard at this time 
- Spring provides an implementation of HATEOS

#### Spring MVC Rest Services

##### Spring Boot Development Tools

- Added to Project via artifact ‘spring-boot-devtools’

- Developer Tools are automatically disabled when running a packaged application (ie java -jar)

- By default, not included in repackaged archives

- Automatic Restart

  - Triggers a restart of the Spring Context when classes change

  - Uses two classloaders. One for your application, one for project jar dependencies

  - Restarts are very fast, since only your project classes are bring loaded

- Eclipse:

  - Restart is triggered with save (which by default will compile the class, which triggers the restart)

- IntelliJ:

  - By default you need to select ‘Build / Make Project’

  - There is an advanced setting you can change to make this more seamless

- Template Caching
  - By default templates are cached for performance
  - But Caching will require a container restart to refresh the cache
  - Developer Tools will disable template caching so the restart is not required to see changes

- LiveReload
  - LiveReload is a technology to automatically trigger a browser refresh when resources are changed
  - Spring Boot Developer Tools includes a LiveReload server
  - Browser plugins are available for a free download at livereload.com

##### API Versioning

- [Blog post](https://github.com/lyndseypadget/semflow)

- Versioning your APIs is considered a best practice

- Example “/api/v1/beer” - “v1” is the API version

- API Versioning allows you to evolve the API without breaking existing API consumers

- Typical lifespan:

  - v1 - first release

  - v2 - second release, notify consumers v1 version is deprecated

  - v3 - remove v1 (optional), notify consumers v2 is deprecated

###### Semantic Versioning 2.0.0

- See website - https://semver.org

- Version - MAJOR.MINOR.PATCH

  - MAJOR - version for major incompatible API changes - aka breaking changes

  - MINOR - new functionality - backwards compatible changes

  - PATCH - backwards compatible bug fixes

- API URLs typically only use MAJOR versions

  - Can optionally use MINOR and PATCH

  - /v1 or /v1.1

###### Non-Breaking Changes

- Non-Breaking changes may be performed under MINOR or PATCH versions
- Examples:
  - New optional parameter
  - New response fields
  - New service (endpoint)
  - Bug fixes - behavior change, NOT change to API itself

###### Breaking Changes

- Breaking Changes should be done under a MAJOR version
- Examples:
  - New required parameter
  - Removal of existing parameter
  - Removal of response value
  - Parameter name change or type
  - Deprecation of a service
