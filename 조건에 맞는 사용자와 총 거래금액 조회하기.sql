SELECT a.USER_ID, a.NICKNAME, b.TOTAL_SALES
from USED_GOODS_USER a
LEFT JOIN(SELECT *, SUM(PRICE) as TOTAL_SALES from USED_GOODS_BOARD WHERE STATUS = 'DONE' GROUP BY WRITER_ID ) b on b.WRITER_ID = a.USER_ID
WHERE b.TOTAL_SALES >= 700000
ORDER BY b.TOTAL_SALES ASC;