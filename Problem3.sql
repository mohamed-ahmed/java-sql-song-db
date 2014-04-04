/*COMP 3005 Assignment4 - Mohamed Ahmed - 100828374*/

drop table if exists place;
drop table if exists is_place_of_service;
drop table if exists place_of_service;
drop table if exists services;
drop table if exists place_contains_place;
drop table if exists service;
drop table if exists contains_place;
drop table if exists is_contained_in;

create table place(
	place_id integer NOT NULL primary key,
	name varchar(30),
	type varchar(30),
	location varchar(30),
	address varchar(30),
	website varchar(30),
	opening_hours integer(30),
	closing_hours integer(30),
	rating integer(30)
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

BEGIN TRANSACTION;

--insert into places values()


--Places
insert into place values(1, "tims","cafe" ,"45.1,-75.2" ,"1720 innes road" ,"www.tims.com" ,800, 2200 ,4 );
insert into place values(2, "tims", "cafe", "45.2-74.3", "123 Blair Road", "www.tims.com", 900, 2300, 3);
insert into place values(3, "Orleans Mall", "mall", "45.4,-74.5", "100 Orleans Blvd", "www.OrleansMall.com", 900, 2100, 2 );
insert into place values(4, "East Ottawa Police Station", "police", "45,5,-75.6", "5 Main Street", "www.OttawaPolice.com" , 900, 2100, 2 );



--Services
insert into service values(101, "tims", "cafe", "www.tims.com");
insert into service values(102, "Ottawa Police", "police", "www.OttawaPolice.com");

--What place is of what service
insert into place_of_service values (101,1);
insert into place_of_service values (101,2);
insert into place_of_service values (102,4);

--what place is contained in what other place
insert into place_contains_place values(3, 1);

COMMIT TRANSACTION;
