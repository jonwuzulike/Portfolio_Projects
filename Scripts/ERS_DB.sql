--DCL Create user for ers_db
create user ers_db  IDENTIFIED by p4ssw0rd;
grant connect, resource to ers_db;

--DDL for ERS

--User type: Employee or Manager
create table user_type (
user_type_id NUMBER PRIMARY KEY,
user_type VARCHAR(20)
);

--Reimbursement type: Food, Lodging, Gas, Weapons
create table reimbursement_type (
r_type_id NUMBER PRIMARY KEY,
r_type VARCHAR(20)
);

--Reimbursement status: Pending, Approved, Denited
create table reimbursement_status (
r_status_id NUMBER PRIMARY KEY,
r_status VARCHAR(20)
);

---User
 create table users (
user_id NUMBER PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
email VARCHAR(40) NOT NULL, UNIQUE,
password VARCHAR(20) NOT NULL,
user_type_id NUMBER DEFAULT 1 
);

alter table users
add constraint FK_user_type
REFERENCES user_type (user_type_id);


--Reimbursement
create table reimbursement (
r_id NUMBER PRIMARY KEY,
amount NUMBER,
time_submitted DATE,
r_status_id NUMBER DEFAULT 1,
r_type_id NUMBER NOT NULL,
user_id NUMBER
);

alter table reimbursement 
add constraint FK_r_staus_id
REFERENCES reimbursement_status (r_status_id);

alter table reimbursement 
add constraint FK_r_type_id
REFERENCES reimbursement_type (r_type_id);

alter table reimbursement 
add constraint FK_user_id
REFERENCES users (user_id);


create sequence user_id_seq
start with 1
increment by 1;

create sequence reimbursement_id_seq
start with 1
increment by 1;


create or replace trigger user_id_trigger
BEFORE INSERT OR DELETE 
ON users
BEGIN
if :new.user_id IS NULL
THEN
SELECT user_id_seq.nextval INTO :new.user_Id FROM DUAL;
END IF;
END
;


create or replace trigger reimbursement_id_trigger
BEFORE INSERT on reimbursement
BEGIN
if :new.r_id IS NULL
THEN
SELECT reimbursement_id_seq.nextval INTO :new.r_id FROM DUAL;
END IF;
END;




--



