USE adlister_db;
DROP TABLE IF EXISTS users;
CREATE TABLE users(
   id INT UNSIGNED NOT NULL AUTO_INCREMENT,
   username VARCHAR(150)NOT NULL,
   password VARCHAR(150) NOT NULL,
   email VARCHAR(150) NOT NULL,
   PRIMARY KEY (id)
);
INSERT INTO users(username, password, email)
Values ('Jade','jade1234','jade@adlist.com'),
       ('Twilight','twi1234','twilight@adlist.com');