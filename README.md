# Store-Management-REST
The Store Management web application be modified into RESTful Web Service

Summary
-------
The primary goal of this project is to make a fully functioned RESTful web service with client and server side along with Spring Boot.
The initial application was my previous project: [Store-Management](https://github.com/wkrix/Store-Management). 


Installation
------------

To install the archetype in your local repository execute following commands:

```bash
    git clone https://github.com/wkrix/Store-Management-REST.git
    cd Store-Management-REST
    mvn clean install
```

Run the project
----------------

```bash
	java -jar Service/target/store-management-rest-service.war
	
	java -jar Client/target/store-management-rest-client.war --server.port=8081
```
*They will run on the embedded tomcat, but you could easily deploy them on your favorite web container too.The server side will use an embedded hsql database but you could easily change it in application.properties into your own postgresql datebase.

Test on the browser
-------------------

    Client:
	http://localhost:8081/
	
	Server:
	http://localhost:8080/products  (for example)
