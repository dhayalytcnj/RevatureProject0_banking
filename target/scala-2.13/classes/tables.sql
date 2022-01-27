
CREATE TABLE if not exists Accounts (
	acctID int AUTO_INCREMENT,
	username varchar(20) UNIQUE NOT NULL,
	password varchar(20) NOT NULL,
	PRIMARY KEY (acctID)
) ;

CREATE TABLE if not exists Customers (
	acctID int UNIQUE NOT NULL,
	fname varchar(20) NOT NULL,
	lname varchar(20) NOT NULL,
	checking decimal(15,2) NOT NULL DEFAULT 0.00,
	savings decimal(15,2) NOT NULL DEFAULT 0.00,
	PRIMARY KEY (acctID),
	FOREIGN KEY (acctID) REFERENCES Accounts(acctID),
	CHECK (checking >= 0.00),
	CHECK (savings >= 0.00)
) ;

/*
insert into Accounts (username, password)
values
	("temp1", "pass1"),
    ("temp2", "pass2"),
    ("temp3", "pass3"),
    ("temp4", "pass4"),
    ("temp5", "pass5");

insert into Customers (acctID, fname, lname)
values
	(1, "Yash", "Dhayal"),
    (2, "Albert", "Wesker"),
    (3, "Master", "Chief"),
    (4, "Betty", "White"),
    (5, "Jackie", "Chan");
*/
/*
select count(*)
from accounts
where username = 'temp1' and password = 'pass1';
*/
    