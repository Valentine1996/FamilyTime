/* Database scheme */

/**
 * @copyright (c) 2014, by Valentine
 *
 * @author Valentyn Namisnyk <valentunnamisnuk@gmail.com>
*/

/**
 * Create database
 */

CREATE DATABASE family_time
  DEFAULT
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

/**
* Create a user
*/

CREATE USER valentine@localhost IDENTIFIED BY 'valentine';


/**
* Grant privileges
*/
GRANT ALL ON family_time.* TO valentine@localhost;

USE family_time;

/* //- SECTION :: TABLES -// */

/** *** *** *** *** *** *** *** *** *** *
 * Family
 *  --- --- --- --- --- --- --- --- --- *
 * Data about families
*/
CREATE TABLE family(
  id          BIGINT( 20 ) NOT NULL AUTO_INCREMENT,

  name        VARCHAR( 32 ) NOT NULL UNIQUE,

  PRIMARY KEY( id )
)
  ENGINE = InnoDB CHARACTER SET = utf8;

/** *** *** *** *** *** *** *** *** *** *
 * User
 *  --- --- --- --- --- --- --- --- --- *
 * Data about users
*/

CREATE TABLE user(
  id          BIGINT(20) NOT NULL AUTO_INCREMENT,
  family_id   BIGINT(20) NOT NULL,

  first_name	VARCHAR(32) NOT NULL,
  last_name 	VARCHAR(32) NOT NULL,

  username 		VARCHAR(32) NOT NULL,
  email 			VARCHAR(32) NOT NULL,
  password 		VARCHAR(32) NOT NULL,

  enabled BOOLEAN NOT NULL,

  PRIMARY KEY( id ),

  FOREIGN KEY( family_id ) REFERENCES family( id )
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8;

/** *** *** *** *** *** *** *** *** *** *
 * Role
 *  --- --- --- --- --- --- --- --- --- *
 * Content data about roles.
 * Ex.: ADMIN, ACCOUNTANT, USER
* *** *** *** *** *** *** *** *** *** *** /
*/
CREATE TABLE role(
  id            BIGINT( 20 ) NOT NULL AUTO_INCREMENT,

  authority     VARCHAR(45) NOT NULL,

  PRIMARY KEY( id )

) ENGINE = InnoDB CHARACTER SET = utf8;

CREATE TABLE user_role(

  user_id       BIGINT( 20 ) NOT NULL,

  role_id       BIGINT( 20 ) NOT NULL,

  FOREIGN KEY( user_id ) REFERENCES user( id )
    ON UPDATE CASCADE
    ON DELETE CASCADE,

  FOREIGN KEY( role_id ) REFERENCES role( id )
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8;

/** *** *** *** *** *** *** *** *** *** *
 *  task type
 *  --- --- --- --- --- --- --- --- --- *
 * List of task types of some family
*/
CREATE TABLE task_type(
  id              BIGINT( 20 ) NOT NULL AUTO_INCREMENT,

  family_id       BIGINT( 20 ) NOT NULL,

  short_name      VARCHAR( 16 ) NOT NULL,

  description     TEXT,

  PRIMARY KEY( id ),

  FOREIGN KEY( family_id ) REFERENCES family( id )
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB CHARACTER SET = utf8;

/** *** *** *** *** *** *** *** *** *** *
 * bonus_type
 *  --- --- --- --- --- --- --- --- --- *
 * List of bonus types of some family
*/
CREATE TABLE bonus_type(
  id              BIGINT( 20 ) NOT NULL AUTO_INCREMENT,

  family_id       BIGINT( 20 ) NOT NULL,

  short_name      VARCHAR( 16 ) NOT NULL,

  description     TEXT,

  icon_name 			VARCHAR(16) NOT NULL,

  PRIMARY KEY( id ),

  FOREIGN KEY( family_id ) REFERENCES family( id )
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB CHARACTER SET = utf8;

/** *** *** *** *** *** *** *** *** *** *
 * complexity
 *  --- --- --- --- --- --- --- --- --- *
 * List of types of complexity
*/
CREATE TABLE complexity(
  id              BIGINT( 20 ) NOT NULL AUTO_INCREMENT,

  family_id       BIGINT( 20 ) NOT NULL,

  type      			VARCHAR( 16 ) NOT NULL,

  description     TEXT,

  PRIMARY KEY( id ),

  FOREIGN KEY( family_id ) REFERENCES family( id )
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB CHARACTER SET = utf8;

/** *** *** *** *** *** *** *** *** *** *
 * task
 *  --- --- --- --- --- --- --- --- --- *
 * List of tasks
*/

-- TODO: change if this is done in JPA(in case conflict with JPA)
CREATE TABLE task(
  id          		BIGINT( 20 ) NOT NULL AUTO_INCREMENT,

  task_type_id		BIGINT( 20 ) NOT NULL,

  complexity_id   BIGINT( 20 ) NOT NULL,

  creator_id 			BIGINT( 20 ) NOT NULL,

  performer_id		BIGINT( 20 ) NOT NULL,

  has_subtasks	  BOOLEAN NOT NULL DEFAULT false,

  parent_id				BIGINT( 20 ),

  step						INTEGER(2),

  description			TEXT,

  prize						INTEGER(3) NOT NULL,

  close_to 				TIMESTAMP NOT NULL,

  created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY( id ),

  FOREIGN KEY( task_type_id ) REFERENCES task_type( id )
    ON UPDATE CASCADE
    ON DELETE RESTRICT,

  FOREIGN KEY( complexity_id ) REFERENCES complexity( id )
    ON UPDATE CASCADE
    ON DELETE RESTRICT,

  FOREIGN KEY( creator_id ) REFERENCES user( id )
    ON UPDATE CASCADE
    ON DELETE RESTRICT,

  FOREIGN KEY( performer_id ) REFERENCES user( id )
    ON UPDATE CASCADE
    ON DELETE RESTRICT,

  FOREIGN KEY( parent_id ) REFERENCES task( id )
    ON UPDATE CASCADE
    ON DELETE RESTRICT
)
  ENGINE = InnoDB CHARACTER SET = utf8;

/** *** *** *** *** *** *** *** *** *** *
 * bonus
 *  --- --- --- --- --- --- --- --- --- *
 * List of bonuses
*/
CREATE TABLE bonus(
  id              BIGINT( 20 ) NOT NULL AUTO_INCREMENT,

  bonus_type_id		BIGINT( 20 ) NOT NULL,

  title      			VARCHAR( 64 ) NOT NULL,

  description     TEXT,

  price						INTEGER(6) NOT NULL,

  PRIMARY KEY( id ),

  FOREIGN KEY( bonus_type_id ) REFERENCES bonus_type( id )
    ON UPDATE CASCADE
    ON DELETE RESTRICT
)
  ENGINE = InnoDB CHARACTER SET = utf8;