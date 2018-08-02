CREATE TABLE Article (
  id BIGINT PRIMARY KEY,
  brand VARCHAR (100) NOT NULL,
  model VARCHAR (100),
  description VARCHAR (500),
  price numeric(5,2) NOT NULL
);

INSERT INTO Article (id, brand, model, description, price) VALUES (1, 'Xiaomi', 'Mi A1', 'Smartphone 4G, 4GB, 64GB, 2xSim, Google Play', 189.99);
INSERT INTO Article (id, brand, model, description, price) VALUES (2, 'Huawei', 'P20 Lite', 'Smartphone 4GB RAM, 64GB, 5.8"', 289.00);
INSERT INTO Article (id, brand, model, description, price) VALUES (3, 'Samsung', 'Galaxy J5', 'Smartphone 5.2", 2xSIM, 4G, 16GB, 1280 x 720 Px, SAMOLED, 16 Million Colours, 16:9', 153.90);
INSERT INTO Article (id, brand, model, description, price) VALUES (4, 'Motorola', 'Moto G6', 'Smartphone Android 5.7", 4G, 12MP camera, 4GB RAM, 64GB, Dual Sim', 269.00);