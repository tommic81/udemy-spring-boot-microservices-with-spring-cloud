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
