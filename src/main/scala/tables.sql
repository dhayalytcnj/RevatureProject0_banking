
CREATE TABLE if not exists Accounts (
	acctID int NOT NULL AUTO_INCREMENT,
	username varchar(20) NOT NULL,
	password varchar(20) NOT NULL,
	PRIMARY KEY (acctID)
) ;

CREATE TABLE if not exists Customers (
	acctID int NOT NULL,
	fname varchar(20) NOT NULL,
	lname varchar(20) NOT NULL,
	checking decimal(15,2) DEFAULT NULL,
	savings decimal(15,2) DEFAULT NULL,
	PRIMARY KEY (acctID),
	FOREIGN KEY (acctID) REFERENCES Accounts(acctID),
	CHECK (checking > 0),
	CHECK (savings > 0)
) ;

