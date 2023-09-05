SELECT a.PRODUCT_ID,PRODUCT_NAME ,SUM(AMOUNT) * a.PRICE as TOTAL_SALES
FROM FOOD_PRODUCT a
LEFT JOIN(SELECT * FROM FOOD_ORDER) b on b.PRODUCT_ID = a.PRODUCT_ID
WHERE PRODUCE_DATE BETWEEN "2022-05-01" and "2022-05-31"
GROUP BY a.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC;