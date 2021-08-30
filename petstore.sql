DROP SCHEMA petstore;
CREATE SCHEMA petstore;
CREATE TABLE petstore.users(
id INT PRIMARY KEY,
 username VARCHAR NOT NULL,
 first_name VARCHAR,
 last_name VARCHAR,
 email VARCHAR,
 password VARCHAR NOT NULL,
 phone VARCHAR,
 user_status INT,
 created_at TIMESTAMP,
 updated_at TIMESTAMP);
 
 CREATE TABLE petstore.types(
 id INT PRIMARY KEY,
 name VARCHAR);
 
 CREATE TABLE petstore.pet(
  id INT PRIMARY KEY,
  name VARCHAR,
  type_id INT CONSTRAINT type_id_fk REFERENCES petstore.types(id),
  birth_date TIMESTAMP,
  created_at TIMESTAMP,
  status INT,
  user_id INT CONSTRAINT user_id_fk REFERENCES petstore.users(id));
  
  CREATE TABLE petstore.visits(
 id INT PRIMARY KEY,
 pet_id INT CONSTRAINT pet_id_fk REFERENCES petstore.pet(id),
 description VARCHAR,
 visit_date TIMESTAMP);
 