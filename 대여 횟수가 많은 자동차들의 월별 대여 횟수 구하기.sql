SELECT MONTH(start_date) as MONTH, a.car_id, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY a 

LEFT JOIN(SELECT car_id, count(*)as cnt
          from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
          WHERE MONTH(start_date) between '8' and '10'
          group by car_id
          having cnt >= 5) b on b.car_id = a.car_id
          
WHERE MONTH(start_date) between '8' and '10'
and b. cnt >= 5
group by car_id, MONTH(start_date)
ORDER BY MONTH asc, car_id desc;