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
insert into place values(5, "West Ottawa Police Station", "police", "45.2,-75.8", "853 Phillips Street", "www.OttawaPolice.com", 900, 2000,3);
insert into place values(6, "Midway Family Fun Park", "smusement_center", "45.1, -74.2", "2477 Kaladar Ave", "www.MidwayFamily.ca", 830, 1900, 5);
insert into place values(7, "Tubes Et Jujubes", "amusement_center", "45.9, -75.7", "170 Rue Deveault", "www.Tubesetjujubes", 1000,2200,3);
insert into place values(8, "Cosmic Adventures Inc", "recreation_center", "45.6, -74.7", "1373 Ogilvie Rd", "www.cosmicadventures", 900, 2000, 2);
insert into place values(9, "Cartier Place Suit Hotel", "hotel", "45.5, -75.7", "180 Cooper St", "www.CarterHotel.ca", 700, 2300, 5);
insert into place values(10, "AMF College Lanes", "bowling_alley", "44.2, -74.6", "131 Maloney Street", "www.CollegeLanes", 900,2100, 3);
insert into place values(11, "Valleyview Little Animal Farm", "amusement_center","44.9, -75.9", "4750 Fallowfield Rd", "www.Animalfarmottawa.ca", 930, 2000, 5); 
insert into place values(12, "Tag Zone", "Paintball Center", "paintball_center", "45.1, -74.5", "89 Montreal Rd", "www.Tagzone.com", 800, 2200, 4);
insert into place values(13, "Country Place Chinese Restaurant", "restaurant", "44.5, -75.2", "174 Boulevard Greber", "www.Countryplaceresturant", 900, 2300, 5);
insert into place values(14, "The SHore Club", "restaurant", "45.2, -74.6", "11 Colonel By Dr", "www.ShoreClub.ca", 1000, 2300, 5);
insert into place values(15, "Gatineau Park","national_park","44.3,-75.1","33 Scott Road","www.GatineauPark.ca",700,2000,5);
insert into place values(16, "Courtyard by Marriot Ottawa","hotel","45.1,-74.6","350 Dalhousie St","www.MarriotOttawa.ca",800,2300,3);
insert into place values(17, "ByWard Market","market","44.8, -74.2","55 Byward Market Square","www.OttawaByWardMarket.ca",900,2300,5);
insert into place values(18, "168 Sushi Buffet","restaurant","45.3, -74.9","1651 Merivale Rd","www.168SushiBuffet.ca",800,2000,4);
insert into place values(19, "The Cake Shop","bakery","44.9, -75.1","1200 Wellington St","www.OttawaCakeShop.com",900,1900,5);
insert into place values(20, "Parliament Hill","historical_place","45.9, -74.6","Wellington St","www.Parliamenthill.ca",800,1700,5);
insert into place values(21, "Steve Police Station", "police", "45.1, -75.9", "754 AltaVista", "www.Stevespolice.com", 800,2200,2);




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
