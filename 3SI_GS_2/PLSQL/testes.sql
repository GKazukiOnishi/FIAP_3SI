/*
DROP INDEX idx_dia_trc_las_cha_date;

CREATE INDEX idx_dia_trc_las_cha_date
ON diabetes(TRUNC(last_change_date));*/

SELECT COUNT(*)
FROM   diabetes
WHERE  TRUNC(last_change_date) = TO_DATE('05/11/2023','DD/MM/YYYY')
AND    time_in_hospital + 1 < 14;
SELECT COUNT(*)
FROM   diabetes
WHERE  TRUNC(last_change_date) = TO_DATE('06/11/2023','DD/MM/YYYY')
AND    time_in_hospital + 1 < 14;
SELECT COUNT(*)
FROM   diabetes
WHERE  TRUNC(last_change_date) = TO_DATE('07/11/2023','DD/MM/YYYY')
AND    time_in_hospital + 1 < 14;
SELECT COUNT(*)
FROM   diabetes
WHERE  TRUNC(last_change_date) = TO_DATE('08/11/2023','DD/MM/YYYY')
AND    time_in_hospital + 1 < 14;
SELECT COUNT(*)
FROM   diabetes
WHERE  TRUNC(last_change_date) = TO_DATE('09/11/2023','DD/MM/YYYY')
AND    time_in_hospital + 1 < 14;
SELECT COUNT(*)
FROM   diabetes
WHERE  TRUNC(last_change_date) = TO_DATE('10/11/2023','DD/MM/YYYY')
AND    time_in_hospital + 1 < 14;
SELECT COUNT(*)
FROM   diabetes
WHERE  TRUNC(last_change_date) = TO_DATE('11/11/2023','DD/MM/YYYY')
AND    time_in_hospital + 1 < 14;
SELECT COUNT(*)
FROM   diabetes
WHERE  TRUNC(last_change_date) = TO_DATE('12/11/2023','DD/MM/YYYY')
AND    time_in_hospital + 1 < 14;

/*
SELECT MIN(last_change_date)
FROM   diabetes
WHERE  TRUNC(last_change_date) = TO_DATE('10/11/2023','DD/MM/YYYY');*/