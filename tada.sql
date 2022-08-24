-- Active: 1660497314780@@127.0.0.1@3306@tada

drop TABLE friendship;

drop TABLE commentaire;

drop TABLE `user`;

CREATE TABLE IF NOT EXISTS user(
    id INT AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(100),
    lastName VARCHAR(100),
    email VARCHAR(50) UNIQUE,
    password VARCHAR(255),
    pseudo VARCHAR(50) UNIQUE,
    created_at DATE,
    PRIMARY KEY(id)
);

 
CREATE TABLE IF NOT EXISTS commentaire(
id INT AUTO_INCREMENT NOT NULL, 
texte VARCHAR(255),
user_id INT NOT NULL,
FOREIGN KEY(user_id) REFERENCES user(id) ON UPDATE CASCADE ON DELETE CASCADE,
PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS friendship(
    user_id INT NOT NULL,
    friend_id INT NOT NULL,
    type CHAR(1),
    created_at DATE,
    FOREIGN KEY(user_id) REFERENCES user(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(friend_id) REFERENCES user(id) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY(user_id,friend_id)

);

 

SELECT id,`firstName`,`lastName`,email,password,pseudo,created_at FROM `user`;

SELECT id,`firstName`,`lastName`,email,password,pseudo,created_at FROM `user`;

SELECT id,`firstName`,`lastName`,email,password,pseudo,created_at FROM `user`;

RENAME TABLE friend TO friendship;

SELECT id,`firstName`,`lastName`,email,password,pseudo,created_at FROM `user`;

describe TABLE user;