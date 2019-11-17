# README

This README would normally document whatever steps are necessary to get your application up and running.

### How do I get set up in a develop environment?

* Run `mvn clean install` 
* Start applicatio using the script `demo.sh {start|stop|restart|status}`
* The application is running in http://localhost:8080
* Rest documentation is running in http://localhost:8080/swagger-ui.html
* H2 console is running in http://localhost:8080/h2_console


### Considerations
* In this test application is provided with only a few tests (unit test and integration test). In a real application, there would be more tests.
* Security: depending on the requirements, the security could be implemented using spring security with the users in a database or if there are more applications, a single sign-on like OpenAM.
* Redundant: It could be implemented in many ways, again depending on the requirements: 
    * Basic: many instances running in different servers/instances and a proxy dispatching the requests (apache or F5).
    * A cluster using WebSphere or another application system.
    * Redundant database: using the cluster of MySQL or Oracle.
    * If the system has millions of users, it could be implemented with microservices.
    
To implement this system, be careful with the application logic and business implementation. Because the data could be split by customers, users or tenant into different databases/servers to avoid conflicts and improve the performance.
