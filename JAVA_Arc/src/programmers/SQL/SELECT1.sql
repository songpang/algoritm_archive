-- 정렬하려 출력하기.
SELECT * FROM ANIMAL_INS ORDER BY ANIMAL_ID

-- 역순 정렬하기
SELECT NAME, DATETIME FROM ANIMAL_INS ORDER BY ANIMAL_ID DESC

-- 아픈 동물 찾기 (WHERE)
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION = 'Sick' ORDER BY ANIMAL_ID ASC

-- 어린 동물 찾기
select animal_id, name from animal_ins where intake_condition != 'aged'

-- 단순 select (동물의 아이디와 이름)
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS ORDER BY ANIMAL_ID

-- 여러 기준 정렬 (이름이 같을 경우 시간 늦은 순으로 정렬)
SELECT ANIMAL_ID, NAME, DATETIME FROM ANIMAL_INS ORDER BY NAME, DATETIME DESC

-- 상위 n개 레코드
SELECT NAME FROM ANIMAL_INS ORDER by DATETIME limit 1
SELECT NAME FROM ANIMAL_INS WHERE DATETIME = (SELECT MIN(DATETIME) FROM ANIMAL_INS)

-- 최댓값 구하기
SELECT DATETIME FROM ANIMAL_INS WHERE DATETIME = (SELECT MAX(DATETIME) FROM ANIMAL_INS);
SELECT DATETIME FROM ANIMAL_INS ORDER BY DATETIME DESC LIMIT 1

-- 동물 수 구하기 ( count )
SELECT COUNT(ANIMAL_ID) FROM ANIMAL_INS;

-- 중복 제거하기 (distinct 는 null값을 무시하지 않음, count가 null 값을 빼고 세는 것임)
SELECT COUNT(DISTINCT(NAME)) FROM ANIMAL_INS

-- 고양이와 개 몇마리 있을까 (GROUP BY 기본)
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) as count FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE ASC

-- 동명 동물 수 찾기 (GROUP BY + HAVING)
SELECT NAME, COUNT(NAME) as COUNT FROM ANIMAL_INS
WHERE NAME != '' GROUP BY NAME HAVING COUNT(NAME) > 1 ORDER BY NAME;

-- 입양 시각 구하기 (DATETIME 에서 HOUR 추출하기)
SELECT HOUR(DATETIME) AS HOUR, COUNT(DATETIME) AS COUNT FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) >= 9 && HOUR(DATETIME) < 20
GROUP BY HOUR(DATETIME) ORDER BY HOUR(DATETIME);

-- 이름이 없는 동물의 아이디 (NULL)
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NULL;

-- NULL 처리하기(IFNULL)
SELECT ANIMAL_TYPE, IFNULL(NAME, "No name") AS NAME, SEX_UPON_INTAKE FROM ANIMAL_INS
ORDER BY ANIMAL_ID

-- 없어진 기록 찾기
SELECT OUTS.ANIMAL_ID, OUTS.NAME
FROM ANIMAL_OUTS OUTS
LEFT OUTER JOIN ANIMAL_INS INS ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.ANIMAL_ID IS NULL ORDER BY OUTS.ANIMAL_ID;

-- 있었는데요 없었습니다 (LEFT OUTER JOIN)
SELECT OUTS.ANIMAL_ID, OUTS.NAME FROM ANIMAL_OUTS OUTS
LEFT OUTER JOIN ANIMAL_INS INS ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.DATETIME > OUTS.DATETIME ORDER BY INS.DATETIME

-- 오랜기간 보호한 동물
SELECT INS.NAME, INS.DATETIME FROM ANIMAL_INS INS
LEFT OUTER JOIN ANIMAL_OUTS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE OUTS.DATETIME IS NULL
ORDER BY INS.DATETIME LIMIT 3

-- 중성화한 동물 ( LIKE 와 % 사용법 )
SELECT OUTS.ANIMAL_ID, OUTS.ANIMAL_TYPE, OUTS.NAME FROM ANIMAL_OUTS OUTS
LEFT OUTER JOIN ANIMAL_INS INS ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.SEX_UPON_INTAKE LIKE "Intact%" AND OUTS.SEX_UPON_OUTCOME NOT LIKE "Intact%"
ORDER BY ANIMAL_ID

-- 루시와 엘라 찾기 ( STRING )
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')

-- 이름이 EL이 들어가는 동물 ( LIKE % )
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog' AND  NAME LIKE '%EL%'
ORDER BY NAME;

-- 중성화 여부 파악하기 ( 새로운 칼럼 만들기 )
SELECT ANIMAL_ID, NAME,
CASE WHEN SEX_UPON_INTAKE LIKE "%Neutered%" OR SEX_UPON_INTAKE LIKE "%Spayed%"
THEN 'O' ELSE 'X' END AS "중성화"
FROM ANIMAL_INS

-- 오랜기간 보호한 동물 ( DATETIME끼리 빼서 정렬)
SELECT OUTS.ANIMAL_ID, OUTS.NAME
FROM ANIMAL_OUTS OUTS
LEFT OUTER JOIN ANIMAL_INS INS ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
ORDER BY OUTS.DATETIME - INS.DATETIME DESC LIMIT 2

-- DATETIME 에서 DATE로 형 변환
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d')
FROM ANIMAL_INS ORDER BY ANIMAL_ID


















