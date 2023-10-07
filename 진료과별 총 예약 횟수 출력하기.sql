SELECT MCDP_CD as '진료과코드', COUNT(*) as '5월예약건수'
from APPOINTMENT 
where DATE_FORMAT(APNT_YMD, '%Y-%m') = '2022-05'
GROUP BY MCDP_CD
ORDER BY 5월예약건수 ASC, 진료과코드 ASC;