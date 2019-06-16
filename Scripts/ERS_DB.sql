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
user_id int PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
email VARCHAR(40) NOT NULL UNIQUE,
password VARCHAR(20) NOT NULL,
user_type_id NUMBER DEFAULT 1
);

alter table users
add constraint FK_user_type
FOREIGN KEY
(user_type_id)
REFERENCES 
user_type (user_type_id);


--Reimbursement
create table reimbursement (
r_id INT PRIMARY KEY,
amount NUMBER,
time_submitted DATE,
r_status_id NUMBER DEFAULT 1,
r_type_id NUMBER NOT NULL,
user_id INT NOT NULL,
name VARCHAR(30) NOT NULL,
);

alter table reimbursement 
add constraint FK_r_staus_id
FOREIGN KEY (r_status_id)
REFERENCES reimbursement_status (r_status_id);

alter table reimbursement 
add constraint FK_r_type_id
FOREIGN KEY (r_type_id)
REFERENCES reimbursement_type (r_type_id);

alter table reimbursement 
add constraint FK_user_id
FOREIGN KEY (user_id)
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
FOR EACH ROW
BEGIN
if :new.user_id IS NULL
THEN
SELECT user_id_seq.nextval INTO :new.user_Id FROM DUAL;
END IF;
END;


create or replace trigger reimbursement_id_trigger
BEFORE INSERT on reimbursement
FOR EACH ROW
BEGIN
if :new.r_id IS NULL
THEN
SELECT reimbursement_id_seq.nextval INTO :new.r_id FROM DUAL;
END IF;
END;




--DML Add data

insert into user_type
values 
(1, 'Employee');
insert into user_type
values
(2, 'Manager');


insert into reimbursement_type
values
(1, 'Food');
insert into reimbursement_type
values
(2, 'Transportation');
insert into reimbursement_type
values
(3, 'Lodging');
insert into reimbursement_type
values
(4, 'Equipment');

insert into reimbursement_status
values
(1, 'Approved');
insert into reimbursement_status
values
(2, 'Denited');
insert into reimbursement_status
values
(3, 'Pending');

insert into users
(first_name, last_name, email, password, user_type_id)
values
('M', ' ', 'm@m6.com', 'm1234', 2);
insert into users
(first_name, last_name, email, password)
values
('Daniel', 'Craig', 'dcraig@m6.com', 'dc123');

insert into users
(first_name, last_name, email, password)
values
('Sean' , 'Connery', 'sconnery@m6c.om', 'sc123');

insert into users
(first_name, last_name, email, password)
values
('Pierce', 'Bruncson', 'pbrunson@m6.com', 'pb123');

insert into reimbursement
(amount, time_submitted, r_status_id, r_type_id, user_id, name)
values
(2000.60, '01-APR-67', 1, 4, 3, 'Weapons');
insert into reimbursement
(amount, time_submitted, r_status_id, r_type_id, user_id, name)
values
(500, '20-MAY-95', 1,1, 4, 'Orderred Room Service');

insert into reimbursement
(amount, time_submitted, r_status_id, r_type_id, user_id, name)
values
(342.60, '15-JUL-08', 1, 2, 2, 'Grand Hotel');


delete from reimbursement
where r_id = 2;


select * from reimbursement;
