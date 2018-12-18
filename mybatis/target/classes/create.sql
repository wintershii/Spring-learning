CREATE TABLE t_person (
  id int NOT NULL AUTO_INCREMENT ,
  name varchar(20) NULL ,
  age int NOT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE t_kids (
  id int NOT NULL AUTO_INCREMENT ,
  name varchar(20) NULL ,
  num varchar(8) NOT NULL ,
  birthDate date NULL ,
  PRIMARY KEY (id)
);

INSERT t_kids VALUES (1,"xiaoming","0001", "2018-01-01");
INSERT t_kids VALUES (DEFAULT, "xiaohong","0002", "2017-01-03");
INSERT t_kids VALUES (DEFAULT, "panghhu","0003", "2016-05-01");