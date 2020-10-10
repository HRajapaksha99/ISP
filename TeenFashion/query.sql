CREATE TABLE user (
	uId varchar(50) not null,
	u_type varchar(100)
    uName  varchar(100),
    uMail  varchar(100),
    uPass  varchar(100),
    uR_Pass varchar(100),
    
    CONSTRAINT user_pk PRIMARY KEY(uId)
);

INSERT INTO user (uId, uName, uMail, uPass, uR_Pass) VALUES ("E3001", "admin", "admin@gmail.com", "admin", "admin");

 CREATE TABLE item(
            
				itemNo varchar(10) not null ,
				Name varchar(50),
				category varchar(50),
				sizevarchar(50),
				Prize varchar(50),
				desc_ varchar(50),
				photo longblob NOT NULL,
				
				primary key(itemNo)
			)   
			
CREATE TABLE category(
           
	catNo varchar(50) not null,
	catName varchar(100),
	subName varchar(100),
			    
	primary key(catNo)
);


 
   
   
CREATE TABLE images (
   
   username varchar(100) NOT NULL,
   photo longblob NOT NULL,
  
   PRIMARY KEY (username)
   );


	CREATE TABLE payment (
				id varchar(50) not null,
			    cardNo varchar(20),
			    cusName varchar(40),
			    expiryDate varchar(20),
			    cvv varchar(4),
			    email varchar(100),
			    amount varchar(1000),
			    phone varchar(20),
			    user varchar(100),
			    item varchar(100),
			    
			    PRIMARY KEY(id)
);






      
select * from category;
select * from item;
select * from user;
select * from payment;

delete from user;
delete from item;

drop table item;
drop table category;
drop table user;
drop table payment;