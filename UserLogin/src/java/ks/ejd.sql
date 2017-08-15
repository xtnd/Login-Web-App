/*
Kody Scharf
July 30, 2017
*/

USE ejd;

DROP TABLE IF EXISTS ejdUser;

CREATE TABLE ejdUser
(
    id  VARCHAR(25) NOT NULL PRIMARY KEY,
    password VARCHAR(128) NOT NULL,
    email VARCHAR(50) NOT NULL
);



    
