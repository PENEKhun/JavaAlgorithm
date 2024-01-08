-- 재구매가 일어난 상품과 회원 리스트 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131536

SELECT
    s.USER_ID, s.PRODUCT_ID
FROM 
    ONLINE_SALE s
GROUP 
    BY s.USER_ID, s.PRODUCT_ID
HAVING 
    count(*) > 1
ORDER BY
    s.USER_ID asc,
    s.PRODUCT_ID desc
