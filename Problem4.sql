select * from 

(select place_id, location, address, opening_hours, closing_hours, rating from place) natural join

(select * from service natural join place_of_service)

;