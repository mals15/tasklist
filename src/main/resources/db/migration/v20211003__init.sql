create table tasklist.person
(
	id serial primary key,
	person_name varchar not null,
	number_telephone varchar not null,
	email varchar not null,
	created_at timestamptz not null default now()
);

create table tasklist.task
(
	id serial primary key,
	task_name varchar not null,
	sfera varchar not null,
	number_telephone varchar not null,
	description varchar not null,
	adress varchar not null,
	conv_time varchar not null,
	conv_date varchar not null,
	person_name varchar not null,
	price int not null,
	created_at timestamptz not null default now(),
	person_id int         not null
    	references tasklist.person (id)
)