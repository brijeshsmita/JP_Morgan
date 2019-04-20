/*If table exists then comment the ddl configuration 
 * in application.properties file
 * if does not exists then comment the drop table statement
 * 
 */DROP TABLE user_ng_rest;

CREATE Table user_ng_rest(
user_id numeric(6) primary key,	
first_name varchar(30),
last_name varchar(30),
email varchar(50));