# from-monolith-to-services
Proof of concept to show how to convert a monolith into independent services without using a microservices infrastructure.

# DBs with docker

## Ecommerce db (PostgreSQL)

### Creation of the db container with Docker (first time)
C:\...\_db\docker-postgreSQL-ecommerce> docker build -t ecommerce_db_img:0.0.1 .

C:\...> docker run -d --name ecommerce_db -p 5432:5432 ecommerce_db_img:0.0.1

### Start the db container (rest of the times)

C:\...> docker start ecommerce_db

## Catalog db (PostgreSQL)

### Creation of the db container with Docker (first time)
C:\...\_db\docker-postgreSQL-catalog> docker build -t catalog_db_img:0.0.1 .

C:\...> docker run -d --name catalog_db -p 5433:5432 catalog_db_img:0.0.1

### Start the db container (rest of the times)

C:\...> docker start catalog_db

## Cart db (PostgreSQL)

### Creation of the db container with Docker (first time)
C:\...\_db\docker-postgreSQL-cart> docker build -t cart_db_img:0.0.1 .

C:\...> docker run -d --name cart_db -p 5434:5432 cart_db_img:0.0.1

### Start the db container (rest of the times)

C:\...> docker start cart_db
