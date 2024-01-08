-- 온오프라인 판매 데이터 통합하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131537

(SELECT
    DATE_FORMAT(onlines.SALES_DATE, "20%y-%m-%d") as SALES_DATE, 
    onlines.PRODUCT_ID as PRODUCT_ID,
    onlines.USER_ID as USER_ID,
    onlines.SALES_AMOUNT as SALES_AMOUNT
FROM
    ONLINE_SALE onlines
WHERE year(SALES_DATE) = 2022 AND month(SALES_DATE) = 3
    
UNION 

SELECT
    DATE_FORMAT(offs.SALES_DATE, "20%y-%m-%d"),
    offs.PRODUCT_ID,
    NULL,
    offs.SALES_AMOUNT
FROM
    OFFLINE_SALE offs
WHERE year(SALES_DATE) = 2022 AND month(SALES_DATE) = 3)

    
ORDER BY
    SALES_DATE ASC,
    PRODUCT_ID ASC,
    USER_ID ASC
