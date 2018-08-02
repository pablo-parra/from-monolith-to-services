# from-monolith-to-services
Proof of concept to show how to convert a monolith into independent services without using a microservices infrastructure.

## Structure
The repository contains three projects:

### Monolith project
The *ecommerce* project acts as the _monolith_ application for the example.

### catalog service project
The *catalog* project acts as a dedicated service that covers the catalog functionalities.

### cart service project
The *cart* project acts as a dedicated service that covers the cart functionalities.

## Running the example
In order to run the separated services I have used XAMPP distribution to use the Apache server included.
A portable version of XAMPP can be downloaded from [here](https://portableapps.com/apps/development/xampp)

### Running the Monolith
We can run the monolith using Eclipse / IntelliJ.

### Running the catalog service
We can run the catalog service using Eclipse / IntelliJ.

### Running the cart service
The cart service is prepared with the Spring Boot bootified plugin so we can run several instances of the service using the following commands

#### Running several instances
First we need to package the app

`from-monolith-to-services\cart> mvn package`

Then we can run it providing a server port.

First instance:
`from-monolith-to-services\cart\target>java -jar -Dserver.port=9004 cart-bootified.jar`

Second instance:
`from-monolith-to-services\cart\target>java -jar -Dserver.port=9005 cart-bootified.jar`

#### Apache server Load Balancer config
For the example I have setted two instances of the cart service, that are configured in the Apache server as follows

```xml
<Proxy "balancer://cart_cluster">
	BalancerMember "http://localhost:9004/cart/api/v1"
	BalancerMember "http://localhost:9005/cart/api/v1"
</Proxy>

ProxyPass "/ecommerce/cart" "balancer://cart_cluster"
ProxyPassReverse "/ecommerce/cart" "balancer://cart_cluster"

ProxyPass /ecommerce/catalog http://localhost:9003/catalog/api/v1/
ProxyPassReverse /ecommerce/catalog http://localhost:9003/catalog/api/v1/
```

### Apache available services
Assuming that our Apache instance runs in the port 8888 the following services would be available through the Load Balancer / Reverse Proxy:

* get catalog: http://localhost:8888/ecommerce/catalog/get
* buy (persist a purchase): http://localhost:8888/ecommerce/cart/buy
* get purchases: http://localhost:8888/ecommerce/cart/getPurchases

The operations related to the cart service will be balanced by Apache between the 9004 and 9005 instances.

## DBs with docker

### Ecommerce db (PostgreSQL)

#### Creation of the db container with Docker (first time)
`C:\...\_db\docker-postgreSQL-ecommerce> docker build -t ecommerce_db_img:0.0.1 .`

`C:\...> docker run -d --name ecommerce_db -p 5432:5432 ecommerce_db_img:0.0.1`

#### Start the db container (rest of the times)

`C:\...> docker start ecommerce_db`

### Catalog db (PostgreSQL)

#### Creation of the db container with Docker (first time)
`C:\...\_db\docker-postgreSQL-catalog> docker build -t catalog_db_img:0.0.1 .`

`C:\...> docker run -d --name catalog_db -p 5433:5432 catalog_db_img:0.0.1`

#### Start the db container (rest of the times)

`C:\...> docker start catalog_db`

### Cart db (PostgreSQL)

#### Creation of the db container with Docker (first time)
`C:\...\_db\docker-postgreSQL-cart> docker build -t cart_db_img:0.0.1 .`

`C:\...> docker run -d --name cart_db -p 5434:5432 cart_db_img:0.0.1`

#### Start the db container (rest of the times)

`C:\...> docker start cart_db`
