-- Gerado por Oracle SQL Developer Data Modeler 21.4.1.349.1605
--   em:        2023-11-18 15:32:39 BRT
--   site:      Oracle Database 21c
--   tipo:      Oracle Database 21c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE categoria (
    num_categoria NUMBER(7) NOT NULL,
    nm_categoria  VARCHAR2(80),
    nivel         VARCHAR2(2)
);

ALTER TABLE categoria
    ADD CONSTRAINT categoria_nivel_ck CHECK ( nivel IN ( 'PA', 'GR', 'UF', 'RE' ) );

ALTER TABLE categoria ADD CONSTRAINT categoria_pk PRIMARY KEY ( num_categoria );

CREATE TABLE dado_indicador (
    cod_meta      VARCHAR2(10) NOT NULL,
    cod_indicador VARCHAR2(10) NOT NULL,
    num_categoria NUMBER(7) NOT NULL,
    num_dado      NUMBER(12) NOT NULL,
    vl_x          VARCHAR2(30),
    vl_y          NUMBER(12, 2)
);

ALTER TABLE dado_indicador
    ADD CONSTRAINT dado_indicador_pk PRIMARY KEY ( num_dado,
                                                   cod_meta,
                                                   cod_indicador,
                                                   num_categoria );

CREATE TABLE grupo_objetivo (
    cod_meta VARCHAR2(10) NOT NULL
);

ALTER TABLE grupo_objetivo ADD CONSTRAINT grupo_objetivo_pk PRIMARY KEY ( cod_meta );

CREATE TABLE indicador (
    cod_meta      VARCHAR2(10) NOT NULL,
    cod_indicador VARCHAR2(10) NOT NULL,
    descricao     VARCHAR2(2000),
    nm_coluna_x   VARCHAR2(50),
    nm_coluna_y   VARCHAR2(50)
);

ALTER TABLE indicador ADD CONSTRAINT indicador_pk PRIMARY KEY ( cod_indicador,
                                                                cod_meta );

ALTER TABLE indicador ADD CONSTRAINT indicador_cod_indicador_un UNIQUE ( cod_indicador );

CREATE TABLE objetivo (
    cod_meta VARCHAR2(10) NOT NULL,
    origem   VARCHAR2(50) NOT NULL,
    objetivo VARCHAR2(2000)
);

ALTER TABLE objetivo ADD CONSTRAINT objetivo_pk PRIMARY KEY ( origem,
                                                              cod_meta );

ALTER TABLE dado_indicador
    ADD CONSTRAINT dado_indicador_categoria_fk FOREIGN KEY ( num_categoria )
        REFERENCES categoria ( num_categoria );

ALTER TABLE dado_indicador
    ADD CONSTRAINT dado_indicador_indicador_fk FOREIGN KEY ( cod_indicador,
                                                             cod_meta )
        REFERENCES indicador ( cod_indicador,
                               cod_meta );

ALTER TABLE indicador
    ADD CONSTRAINT indicador_grupo_objetivo_fk FOREIGN KEY ( cod_meta )
        REFERENCES grupo_objetivo ( cod_meta );

ALTER TABLE objetivo
    ADD CONSTRAINT objetivo_grupo_objetivo_fk FOREIGN KEY ( cod_meta )
        REFERENCES grupo_objetivo ( cod_meta );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                             11
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
