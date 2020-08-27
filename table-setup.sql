drop table if exists ers_user_roles;
drop table if exists ers_reimbursement_status;
drop table if exists ers_reimbursement_type;
drop table if exists ers_users cascade;
drop table if exists ers_reimbursement cascade;


create table ers_user_roles (
	ers_user_role_id serial primary key,
	user_role varchar(10)
);

create table ers_users (
	ers_users_id serial primary key,
	ers_username varchar(50) unique, 
	ers_password varchar(50),
	user_first_name varchar(100),
	user_last_name varchar(100),
	user_email varchar(150) unique,
	user_role_id integer references ers_user_roles(ers_user_role_id)
);

create table ers_reimbursement_status (
	reimb_status_id serial primary key,
	reimb_status varchar(10)
);

create table ers_reimbursement_type (
	reimb_type_id serial primary key,
	reimb_type varchar(10)
);

create table ers_reimbursement (
	reimb_id serial primary key,
	reimb_amount integer,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description varchar(250),
	reimb_receipt bytea,
	reimb_author integer references ers_users(ers_users_id),
	reimb_resolver integer references ers_users(ers_users_id),
	reimb_status_id integer references ers_reimbursement_status(reimb_status_id),
	reimb_type_id integer references ers_reimbursement_type(reimb_type_id)
);