-- Select

/*
desc PF0645.diabetes;
select * from PF0645.diabetes;
select COUNT(*) from PF0645.diabetes;
select * from PF0645.discharge_disposition;
select * from PF0645.admission_type;
select * from PF0645.admission_source;
*/

-- Drop

DROP TABLE diabetes;
DROP TABLE discharge_disposition;
DROP TABLE admission_type;
DROP TABLE admission_source;

-- DDL

CREATE TABLE diabetes
    AS
        SELECT
            *
        FROM
            pf0645.diabetes;

CREATE TABLE discharge_disposition
    AS
        SELECT
            *
        FROM
            pf0645.discharge_disposition;

CREATE TABLE admission_type
    AS
        SELECT
            *
        FROM
            pf0645.admission_type;

CREATE TABLE admission_source
    AS
        SELECT
            *
        FROM
            pf0645.admission_source;

ALTER TABLE diabetes ADD CONSTRAINT diabetes_pk PRIMARY KEY ( encounter_id );

ALTER TABLE discharge_disposition ADD CONSTRAINT DISCHARGE_DISPOSITION_PK PRIMARY KEY ( discharge_disposition_id );

ALTER TABLE admission_type ADD CONSTRAINT ADMISSION_TYPE_PK PRIMARY KEY ( admission_type_id );

ALTER TABLE admission_source ADD CONSTRAINT ADMISSION_SOURCE_PK PRIMARY KEY ( admission_source_id );

ALTER TABLE diabetes
    ADD CONSTRAINT diabetes_admission_source_fk FOREIGN KEY ( admission_source_id )
        REFERENCES admission_source ( admission_source_id )
    ADD CONSTRAINT diabetes_admission_type_fk FOREIGN KEY ( admission_type_id )
        REFERENCES admission_type ( admission_type_id )
    ADD CONSTRAINT diabetes_discharge_disposition_fk FOREIGN KEY ( discharge_disposition_id )
        REFERENCES discharge_disposition ( discharge_disposition_id );

-- Exercício

-- Procedures sem otimização
CREATE OR REPLACE PROCEDURE update_time_in_hospital(p_last_change_date IN DATE,
                                                    p_time_in_hospital IN NUMBER) IS
    l_eligible  BOOLEAN;
    l_sql_count INTEGER := 0;
BEGIN
    FOR patients_rec IN (SELECT encounter_id
                         FROM   diabetes
                         WHERE  trunc(last_change_date) = p_last_change_date) LOOP
        dbms_output.put_line('PACIENTE: ' || patients_rec.encounter_id);
        check_eligibility(patients_rec.encounter_id, p_time_in_hospital, l_eligible);
        IF l_eligible THEN
            UPDATE diabetes
            SET    time_in_hospital = time_in_hospital + p_time_in_hospital
            WHERE  encounter_id = patients_rec.encounter_id;

            l_sql_count := l_sql_count + 1;
        END IF;
    END LOOP;

    dbms_output.put_line(l_sql_count || ' rows updated');
    COMMIT;
END update_time_in_hospital;
/

CREATE OR REPLACE PROCEDURE check_eligibility(p_encounter_id     IN NUMBER,
                                              p_time_in_hospital IN NUMBER,
                                              p_is_eligible      OUT BOOLEAN) IS
    l_encounter_id NUMBER;
BEGIN
    SELECT encounter_id
    INTO   l_encounter_id
    FROM   diabetes
    WHERE  encounter_id = p_encounter_id
    AND    time_in_hospital + p_time_in_hospital < 14;

    p_is_eligible := true;
EXCEPTION
    WHEN no_data_found THEN
        p_is_eligible := false;
END;
/

-- Procedures otimizadas
CREATE INDEX idx_dia_trc_las_cha_date
ON diabetes(TRUNC(last_change_date));
-- DROP INDEX idx_dia_trc_las_cha_date;

CREATE OR REPLACE PROCEDURE update_time_in_hospital(p_last_change_date IN DATE,
                                                    p_time_in_hospital IN NUMBER) IS
    TYPE patients_table IS TABLE OF diabetes.encounter_id%TYPE INDEX BY PLS_INTEGER;
    patients patients_table;
BEGIN
    SELECT encounter_id
    BULK   COLLECT INTO patients
    FROM   diabetes
    WHERE  TRUNC(last_change_date) = p_last_change_date -- Selected date
    AND    time_in_hospital + p_time_in_hospital < 14; -- Eligible patient
    
    FORALL i IN patients.FIRST..patients.LAST
      UPDATE diabetes
      SET    time_in_hospital = time_in_hospital + p_time_in_hospital
      WHERE  encounter_id = patients(i);

    dbms_output.put_line(patients.COUNT || ' rows updated');
    COMMIT;
END update_time_in_hospital;
/

-- Teste de tempo
SET SERVEROUT ON
DECLARE
    t0    NUMBER := dbms_utility.get_time;
    v_idx NUMBER := 1;
BEGIN
    UPDATE_TIME_IN_HOSPITAL(P_LAST_CHANGE_DATE => '14-NOV-2023',
                            P_TIME_IN_HOSPITAL => 1);
    DBMS_OUTPUT.PUT_LINE('Tempo: ' || ((DBMS_UTILITY.GET_TIME - T0) / 100) || ' segundos'); 
END;
/