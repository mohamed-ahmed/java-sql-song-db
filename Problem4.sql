/*1. List places which are malls or amusement parks */

select * from place where type = "mall" or type = "amusement_center";

/*
Results:

place_id    name          type        location    address           website              opening_hours  closing_hours  rating
----------  ------------  ----------  ----------  ----------------  -------------------  -------------  -------------  ----------
3           Orleans Mall  mall        45.4,-74.5  100 Orleans Blvd  www.OrleansMall.com  900            2100           2
7           Tubes Et Juj  amusement_  45.9, -75.  170 Rue Deveault  www.Tubesetjujubes   1000           2200           3
11          Valleyview L  amusement_  44.9, -75.  4750 Fallowfield  www.Animalfarmottaw  930            2000           5

*/

/*2. List places that have a rating that is equal to and greater than 2 */

select * from place where rating >= "2";

/* 
Results:
place_id    name        type        location    address          website       opening_hours  closing_hours  rating
----------  ----------  ----------  ----------  ---------------  ------------  -------------  -------------  ---
1           tims        cafe        45.1,-75.2  1720 innes road  www.tims.com  800            2200           4
2           tims        cafe        45.2-74.3   123 Blair Road   www.tims.com  900            2300           3
3           Orleans Ma  mall        45.4,-74.5  100 Orleans Blv  www.OrleansM  900            2100           2
4           East Ottaw  police      45,5,-75.6  5 Main Street    www.OttawaPo  900            2100           2
5           West Ottaw  police      45.2,-75.8  853 Phillips St  www.OttawaPo  900            2000           3
6           Midway Fam  smusement_  45.1, -74.  2477 Kaladar Av  www.MidwayFa  830            1900           5
7           Tubes Et J  amusement_  45.9, -75.  170 Rue Deveaul  www.Tubesetj  1000           2200           3
8           Cosmic Adv  recreation  45.6, -74.  1373 Ogilvie Rd  www.cosmicad  900            2000           2
9           Cartier Pl  hotel       45.5, -75.  180 Cooper St    www.CarterHo  700            2300           5
10          AMF Colleg  bowling_al  44.2, -74.  131 Maloney Str  www.CollegeL  900            2100           3
11          Valleyview  amusement_  44.9, -75.  4750 Fallowfiel  www.Animalfa  930            2000           5
13          Country Pl  restaurant  44.5, -75.  174 Boulevard G  www.Countryp  900            2300           5
14          The SHore   restaurant  45.2, -74.  11 Colonel By D  www.ShoreClu  1000           2300           5
15          Gatineau P  national_p  44.3,-75.1  33 Scott Road    www.Gatineau  700            2000           5
16          Courtyard   hotel       45.1,-74.6  350 Dalhousie S  www.MarriotO  800            2300           3
17          ByWard Mar  market      44.8, -74.  55 Byward Marke  www.OttawaBy  900            2300           5
18          168 Sushi   restaurant  45.3, -74.  1651 Merivale R  www.168Sushi  800            2000           4
19          The Cake S  bakery      44.9, -75.  1200 Wellington  www.OttawaCa  900            1900           5
20          Parliament  historical  45.9, -74.  Wellington St    www.Parliame  800            1700           5
21          Steve Poli  police      45.1, -75.  754 AltaVista    www.Stevespo  800            2200           2
*/

/*3.List of places that are resturants and have a rating of 5*/


Select * from place where type = "restaurant" AND rating = "5";

/* 
Results:
place_id    name                              type        location     address               website                    opening_hours  closing_hours  rating
----------  --------------------------------  ----------  -----------  --------------------  -------------------------  -------------  -------------  ----------
13          Country Place Chinese Restaurant  restaurant  44.5, -75.2  174 Boulevard Greber  www.Countryplaceresturant  900            2300           5
14          The SHore Club                    restaurant  45.2, -74.6  11 Colonel By Dr      www.ShoreClub.ca           1000           2300           5
*/

/*4 List places that are hotels and are open before 10 am and close after 10pm */

select * from place where type = "hotel" AND opening_hours <= 1000 AND closing_hours >= 2200;

/*
Results:
place_id    name                      type        location     address        website             opening_hours  closing_hours  rating
----------  ------------------------  ----------  -----------  -------------  ------------------  -------------  -------------  ----------
9           Cartier Place Suit Hotel  hotel       45.5, -75.7  180 Cooper St  www.CarterHotel.ca  700            2300           5
16          Courtyard by Marriot Ott  hotel       45.1,-74.6   350 Dalhousie  www.MarriotOttawa.  800            2300           3

*/

/*5 List places close to latitude 45*/

select * from place where location LIKE "45%" order by rating desc;

/*
Results:
place_id    name                    type              location     address           website              opening_hours  closing_hours  rating
----------  ----------------------  ----------------  -----------  ----------------  -------------------  -------------  -------------  ----------
6           Midway Family Fun Park  smusement_center  45.1, -74.2  2477 Kaladar Ave  www.MidwayFamily.ca  830            1900           5
9           Cartier Place Suit Hot  hotel             45.5, -75.7  180 Cooper St     www.CarterHotel.ca   700            2300           5
14          The SHore Club          restaurant        45.2, -74.6  11 Colonel By Dr  www.ShoreClub.ca     1000           2300           5
20          Parliament Hill         historical_place  45.9, -74.6  Wellington St     www.Parliamenthill.  800            1700           5
1           tims                    cafe              45.1,-75.2   1720 innes road   www.tims.com         800            2200           4
18          168 Sushi Buffet        restaurant        45.3, -74.9  1651 Merivale Rd  www.168SushiBuffet.  800            2000           4
2           tims                    cafe              45.2-74.3    123 Blair Road    www.tims.com         900            2300           3
5           West Ottawa Police Sta  police            45.2,-75.8   853 Phillips Str  www.OttawaPolice.co  900            2000           3
7           Tubes Et Jujubes        amusement_center  45.9, -75.7  170 Rue Deveault  www.Tubesetjujubes   1000           2200           3
16          Courtyard by Marriot O  hotel             45.1,-74.6   350 Dalhousie St  www.MarriotOttawa.c  800            2300           3
3           Orleans Mall            mall              45.4,-74.5   100 Orleans Blvd  www.OrleansMall.com  900            2100           2
4           East Ottawa Police Sta  police            45,5,-75.6   5 Main Street     www.OttawaPolice.co  900            2100           2
8           Cosmic Adventures Inc   recreation_cente  45.6, -74.7  1373 Ogilvie Rd   www.cosmicadventure  900            2000           2
21          Steve Police Station    police            45.1, -75.9  754 AltaVista     www.Stevespolice.co  800            2200           2

*/

/* 6 List all places which are a service*/

select * from ( (select * from service) natural join (select * from place_of_service) );

/*
Results: 
service_id  name        type        website       place_id
----------  ----------  ----------  ------------  ----------
101         tims        cafe        www.tims.com  1
101         tims        cafe        www.tims.com  2
102         Ottawa Pol  police      www.OttawaPo  4
102         Ottawa Pol  police      www.OttawaPo  5

*/

/* 7 List places between latitude 44 and 45.6*/

select * from place where location BETWEEN '44%' AND '45.6%';

/* 
Result:
place_id    name        type        location    address          website       opening_hours  closing_hours  rating
----------  ----------  ----------  ----------  ---------------  ------------  -------------  -------------  ----------
1           tims        cafe        45.1,-75.2  1720 innes road  www.tims.com  800            2200           4
2           tims        cafe        45.2-74.3   123 Blair Road   www.tims.com  900            2300           3
3           Orleans Ma  mall        45.4,-74.5  100 Orleans Blv  www.OrleansM  900            2100           2
4           East Ottaw  police      45,5,-75.6  5 Main Street    www.OttawaPo  900            2100           2
5           West Ottaw  police      45.2,-75.8  853 Phillips St  www.OttawaPo  900            2000           3
6           Midway Fam  smusement_  45.1, -74.  2477 Kaladar Av  www.MidwayFa  830            1900           5
9           Cartier Pl  hotel       45.5, -75.  180 Cooper St    www.CarterHo  700            2300           5
10          AMF Colleg  bowling_al  44.2, -74.  131 Maloney Str  www.CollegeL  900            2100           3
11          Valleyview  amusement_  44.9, -75.  4750 Fallowfiel  www.Animalfa  930            2000           5
13          Country Pl  restaurant  44.5, -75.  174 Boulevard G  www.Countryp  900            2300           5
14          The SHore   restaurant  45.2, -74.  11 Colonel By D  www.ShoreClu  1000           2300           5
15          Gatineau P  national_p  44.3,-75.1  33 Scott Road    www.Gatineau  700            2000           5
16          Courtyard   hotel       45.1,-74.6  350 Dalhousie S  www.MarriotO  800            2300           3
17          ByWard Mar  market      44.8, -74.  55 Byward Marke  www.OttawaBy  900            2300           5
18          168 Sushi   restaurant  45.3, -74.  1651 Merivale R  www.168Sushi  800            2000           4
19          The Cake S  bakery      44.9, -75.  1200 Wellington  www.OttawaCa  900            1900           5
21          Steve Poli  police      45.1, -75.  754 AltaVista    www.Stevespo  800            2200           2
*/

/* 8 List all the places close to the address Merivale*/

select * from places where address LIKE "%Merivale%";

/*
Result:
place_id    name              type        location     address           website                opening_hours  closing_hours  rating
----------  ----------------  ----------  -----------  ----------------  ---------------------  -------------  -------------  ----------
18          168 Sushi Buffet  restaurant  45.3, -74.9  1651 Merivale Rd  www.168SushiBuffet.ca  800            2000           4
*/

/* 9 List all the places that are amusement centers and are open before 12 pm and close after 7pm*/

select * from place where type = "amusement_center" AND opening_hours <= 1200 AND closing_hours >= 1900  order by rating desc;
/*
Result:
place_id    name                           type              location     address              website                  opening_hours  closing_hours  rating
----------  -----------------------------  ----------------  -----------  -------------------  -----------------------  -------------  -------------  ----------
11          Valleyview Little Animal Farm  amusement_center  44.9, -75.9  4750 Fallowfield Rd  www.Animalfarmottawa.ca  930            2000           5
7           Tubes Et Jujubes               amusement_center  45.9, -75.7  170 Rue Deveault     www.Tubesetjujubes       1000           2200           3
*/

/* 10 List places that use the website www.tims.com*/

select * from place where website = "www.tims.com";
/* 
Result:
place_id    name        type        location    address          website       opening_hours  closing_hours  rating
----------  ----------  ----------  ----------  ---------------  ------------  -------------  -------------  ----------
1           tims        cafe        45.1,-75.2  1720 innes road  www.tims.com  800            2200           4
2           tims        cafe        45.2-74.3   123 Blair Road   www.tims.com  900            2300           3
*/
