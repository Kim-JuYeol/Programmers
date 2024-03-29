SELECT b.INGREDIENT_TYPE, sum(a.TOTAL_ORDER) as TOTAL_ORDER
FROM FIRST_HALF a
LEFT JOIN(SELECT * FROM ICECREAM_INFO) b on b.FLAVOR = a.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDER ASC;