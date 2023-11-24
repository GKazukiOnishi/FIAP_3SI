/*
87182 - Gabriel Kazuki Onishi
88332 - Breno de Souza Silva
*/

-- Índices

CREATE INDEX idx_dia_trc_las_cha_date
ON diabetes(TRUNC(last_change_date));

-- Procedures

CREATE OR REPLACE PROCEDURE update_time_in_hospital(p_last_change_date IN DATE,
                                                    p_time_in_hospital IN NUMBER) IS
BEGIN
    UPDATE diabetes
    SET    time_in_hospital = time_in_hospital + p_time_in_hospital
    WHERE  TRUNC(last_change_date) = p_last_change_date -- Selected date
    AND    time_in_hospital + p_time_in_hospital < 14; -- check eligibility

    dbms_output.put_line(sql%rowcount || ' rows updated');
    COMMIT;
END update_time_in_hospital;
/

-- Teste de tempo
/*
SET SERVEROUT ON
DECLARE
    t0    NUMBER := dbms_utility.get_time;
    v_idx NUMBER := 1;
BEGIN
    UPDATE_TIME_IN_HOSPITAL(P_LAST_CHANGE_DATE => '05-NOV-2023',
                            P_TIME_IN_HOSPITAL => 0);
    UPDATE_TIME_IN_HOSPITAL(P_LAST_CHANGE_DATE => '06-NOV-2023',
                            P_TIME_IN_HOSPITAL => 0);
    UPDATE_TIME_IN_HOSPITAL(P_LAST_CHANGE_DATE => '07-NOV-2023',
                            P_TIME_IN_HOSPITAL => 0);
    UPDATE_TIME_IN_HOSPITAL(P_LAST_CHANGE_DATE => '08-NOV-2023',
                            P_TIME_IN_HOSPITAL => 0);
    UPDATE_TIME_IN_HOSPITAL(P_LAST_CHANGE_DATE => '09-NOV-2023',
                            P_TIME_IN_HOSPITAL => 0);
    UPDATE_TIME_IN_HOSPITAL(P_LAST_CHANGE_DATE => '10-NOV-2023',
                            P_TIME_IN_HOSPITAL => 0);
    UPDATE_TIME_IN_HOSPITAL(P_LAST_CHANGE_DATE => '11-NOV-2023',
                            P_TIME_IN_HOSPITAL => 0);
    UPDATE_TIME_IN_HOSPITAL(P_LAST_CHANGE_DATE => '12-NOV-2023',
                            P_TIME_IN_HOSPITAL => 0);
    DBMS_OUTPUT.PUT_LINE('Tempo: ' || TO_CHAR((DBMS_UTILITY.GET_TIME - T0) / 100, 'FM00.00') || ' segundos'); 
END;
/
SET SERVEROUT OFF
*/