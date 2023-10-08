SELECT CAR_TYPE, COUNT(*) as CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE 
options LIKE CONCAT("%", "가죽시트" ,"%")
OR options LIKE CONCAT("%", "열선시트" ,"%")
OR options LIKE CONCAT("%", "통풍시트" ,"%")
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE