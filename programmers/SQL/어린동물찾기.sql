-- 어린 동물 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59037
SELECT 
    a.ANIMAL_ID, a.NAME
FROM
    ANIMAL_INS a
WHERE
    a.INTAKE_CONDITION != 'Aged'
ORDER BY a.ANIMAL_ID asc
