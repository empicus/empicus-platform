CREATE USER 'empicusDB'@'%' IDENTIFIED BY 'kwesta89634893wale3467893@f567hj';
CREATE USER 'empicusDB'@'localhost' IDENTIFIED BY 'kwesta89634893wale3467893@f567hj';

CREATE DATABASE empicusDB;

GRANT ALL PRIVILEGES ON empicusDB.* TO 'empicusDB'@'%';
GRANT ALL PRIVILEGES ON empicusDB.* TO 'empicusDB'@'localhost';
