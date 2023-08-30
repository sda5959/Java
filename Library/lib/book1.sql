
/* Drop Tables */

DROP TABLE LENT CASCADE CONSTRAINTS;
DROP TABLE Book CASCADE CONSTRAINTS;
DROP TABLE MEMBER1 CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE Book
(
	BOOK_ID varchar2(50) NOT NULL,
	TITLE varchar2(50),
	QUANT number,
	PRIMARY KEY (BOOK_ID)
);


CREATE TABLE LENT
(
	LENT_id number NOT NULL,
	BOOK_ID varchar2(50) NOT NULL,
	member_id varchar2(50) NOT NULL,
	loan_date varchar2(40) NOT NULL,
	return_date varchar2(30) NOT NULL,
	PRIMARY KEY (LENT_id)
);


CREATE TABLE MEMBER1
(
	member_id varchar2(50) NOT NULL,
	member_pw varchar2(50) NOT NULL,
	name varchar2(50) NOT NULL,
	MEMBER_PN varchar2(30),
	PRIMARY KEY (member_id)
);



/* Create Foreign Keys */

ALTER TABLE LENT
	ADD FOREIGN KEY (BOOK_ID)
	REFERENCES Book (BOOK_ID)
;


ALTER TABLE LENT
	ADD FOREIGN KEY (member_id)
	REFERENCES MEMBER1 (member_id)
;



