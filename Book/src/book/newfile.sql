
/* Drop Tables */

DROP TABLE Loan CASCADE CONSTRAINTS;
DROP TABLE LMember CASCADE CONSTRAINTS;
DROP TABLE Book CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE Book
(
	book_id number NOT NULL,
	title varchar2(50) NOT NULL,
	count number,
	PRIMARY KEY (book_id)
);


CREATE TABLE LMember
(
	member_no number NOT NULL,
	member_id number NOT NULL,
	name varchar2(50) NOT NULL,
	PRIMARY KEY (member_no)
);


CREATE TABLE Loan
(
	loan_id number NOT NULL,
	book_id number NOT NULL,
	member_no number NOT NULL,
	loan_date varchar2(30),
	due_date varchar2(30),
	member_id varchar2(50) NOT NULL,
	PRIMARY KEY (loan_id)
);



/* Create Foreign Keys */

ALTER TABLE LMember
	ADD FOREIGN KEY (member_id)
	REFERENCES Book (book_id)
;


ALTER TABLE Loan
	ADD FOREIGN KEY (book_id)
	REFERENCES Book (book_id)
;


ALTER TABLE Loan
	ADD FOREIGN KEY (member_no)
	REFERENCES LMember (member_no)
;



