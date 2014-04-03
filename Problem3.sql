/*COMP 3005 Assignment4 - Mohamed Ahmed - 100828374*/

drop table if exists place;
drop table if exists is_place_of_service;
drop table if exists place_of_service;
drop table if exists services;
drop table if exists place_contains_place;
drop table if exists service;
drop table if exists contains_place;
drop table if is_contained_in;

create table places(
	place_id integer NOT NULL primary key,
	name varchar(30),
	type varchar(30),
	location varchar(30),
	address varchar(30),
	website varchar(30),
	opening_hours varchar(30),
	closing_hours varchar(30),
	ratings varchar(30)
);

create table service(
	service_id NOT NULL primary key,
	name varchar(30),
	type varchar(30),
	website varchar(30)
);

create table place_of_service(
	service_id integer not null,
	place_id integer not null,
	primary key( place_id, service_id),
	foreign key(place_id) references places(place_id) on delete cascade,
	foreign key(service_id) references service(service_id) on delete cascade
);

create table place_contains_place(
	place_id_outter NOT NULL ,
	place_id_inner NOT NULL ,
	primary key ( place_id_inner, place_id_outter),
	foreign key (place_id_inner) references places (place_id) on delete cascade,
	foreign key (place_id_outter) references places (place_id) on delete cascade
);

insert into places values(, , , , , , , , );