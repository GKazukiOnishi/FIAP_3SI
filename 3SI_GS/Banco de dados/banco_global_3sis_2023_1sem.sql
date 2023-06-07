-- 87182 - Gabriel Kazuki Onishi
-- 88332 - Breno de Souza Silva

/*
SELECT * FROM PF0645.CONSUMO;
SELECT * FROM PF0645.DESPERDICIO;
SELECT * FROM PF0645.PRODUCAO;
SELECT * FROM PF0645.CULTURAS;
SELECT * FROM PF0645.PAISES;
*/

-- Resposta 1
SELECT pa.nome pais,
       cu.nome cultura,
       SUM(pr.quantidade) producaototal,
       SUM(co.quantidade) consumototal,
       SUM(de.quantidade) desperdiciototal
FROM   PF0645.PAISES pa
JOIN   PF0645.PRODUCAO pr
ON     pa.id_pais = pr.id_pais
JOIN   PF0645.CULTURAS cu
ON     pr.id_cultura = cu.id_cultura
JOIN   PF0645.CONSUMO co
ON     pa.id_pais = co.id_pais
AND    co.id_cultura = cu.id_cultura
JOIN   PF0645.DESPERDICIO de
ON     pa.id_pais = de.id_pais
AND    de.id_cultura = cu.id_cultura
GROUP  BY ROLLUP(pa.nome, cu.nome)
ORDER  BY pa.nome, cu.nome;

-- Resposta 2
CREATE OR REPLACE VIEW CONSUMO_BRASIL
AS SELECT cu.nome cultura,
          SUM(co.quantidade) consumototal
   FROM   PF0645.CONSUMO co
   JOIN   PF0645.CULTURAS cu
   ON     co.id_cultura = cu.id_cultura
   JOIN   PF0645.PAISES pa
   ON     pa.id_pais = co.id_pais
   WHERE  pa.nome = 'Brasil'
   GROUP  BY cu.nome
   WITH READ ONLY CONSTRAINT CONBRV0_RO;

--SELECT * FROM CONSUMO_BRASIL;

-- Resposta 3
DROP TABLE PRODUCAO_0_7500;
DROP TABLE PRODUCAO_7501_10000;
DROP TABLE PRODUCAO_10001_20000;
CREATE TABLE PRODUCAO_0_7500
AS SELECT * FROM PF0645.PRODUCAO
WHERE 1=2;
CREATE TABLE PRODUCAO_7501_10000
AS SELECT * FROM PF0645.PRODUCAO
WHERE 1=2;
CREATE TABLE PRODUCAO_10001_20000
AS SELECT * FROM PF0645.PRODUCAO
WHERE 1=2;

INSERT FIRST
  WHEN quantidade <= 7500 THEN
    INTO PRODUCAO_0_7500 VALUES (id_producao, id_pais, id_cultura, ano, quantidade)
  WHEN quantidade <= 10000 THEN
    INTO PRODUCAO_7501_10000 VALUES (id_producao, id_pais, id_cultura, ano, quantidade)
  WHEN quantidade <= 20000 THEN
    INTO PRODUCAO_10001_20000 VALUES (id_producao, id_pais, id_cultura, ano, quantidade)
  SELECT *
  FROM   PF0645.PRODUCAO;

SELECT * FROM PRODUCAO_0_7500;
SELECT * FROM PRODUCAO_7501_10000;
SELECT * FROM PRODUCAO_10001_20000;

-- Resposta 4
WITH
  media_pais AS (
    SELECT AVG(SUM(co.quantidade)) media_consumo_total
    FROM   PF0645.CONSUMO co
    GROUP  BY co.id_pais
  )
SELECT pa.nome pais,
       SUM(co.quantidade) consumototal
FROM   PF0645.PAISES pa
JOIN   PF0645.CONSUMO co
ON     pa.id_pais = co.id_pais
GROUP  BY pa.nome
HAVING SUM(co.quantidade) > (SELECT media_consumo_total FROM media_pais);
