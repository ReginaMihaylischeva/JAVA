 DROP DATABASE IF EXISTS ttschool;
 CREATE DATABASE ttschool;
 USE  ttschool;

 CREATE TABLE trainee (
id INT(10) NOT NULL AUTO_INCREMENT,
firstname VARCHAR(50) NOT NULL,
lastname VARCHAR(50) NOT NULL,
rating int (1),
PRIMARY KEY (id)
)
 ENGINE=INNODB DEFAULT CHARSET=utf8;

 CREATE TABLE subject (
id INT(10) NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

 CREATE TABLE groupe(
id INT(10) NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
room int(1)  NOT NULL,
schoolid INT(10) NOT NULL,
#FOREIGN KEY (schoolid) REFERENCES school.id on delete cascade,
  PRIMARY KEY (id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;


 CREATE TABLE school(
id INT(10) NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
year int(1)  NOT NULL,
PRIMARY KEY (id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE school_subject(
PRIMARY KEY (school_id,subject_id),
school_id INT(10) NOT NULL,
subject_id INT(10) NOT NULL

)
ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE groupe_trainee(
PRIMARY KEY (trainee_id,groupe_id),
trainee_id INT(10) NOT NULL,
groupe_id INT(10) NOT NULL

)
ENGINE=INNODB DEFAULT CHARSET=utf8;

ALTER TABLE school_subject
ADD CONSTRAINT school_id
FOREIGN KEY (school_id) REFERENCES school(id) on delete cascade on update cascade ;
ALTER TABLE school_subject
ADD CONSTRAINT subject_id
FOREIGN KEY (subject_id) REFERENCES subject(id) on delete cascade on update cascade;


ALTER TABLE ttschool.groupe
ADD CONSTRAINT groupee
FOREIGN KEY (schoolid) REFERENCES school(id) on delete cascade on update cascade;


ALTER TABLE groupe_trainee
ADD CONSTRAINT trainee_id
FOREIGN KEY (trainee_id) REFERENCES trainee(id) on delete cascade on update cascade ;
ALTER TABLE groupe_trainee
ADD CONSTRAINT groupe_id
FOREIGN KEY (groupe_id) REFERENCES groupe(id) on delete cascade on update cascade;
