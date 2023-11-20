import React, { useEffect, useState } from "react";
import { MyLayout } from "../../components/layout/MyLayout";
import { useLocation } from "react-router-dom";
import { MenuItem, Select, Stack, Typography } from "@mui/material";
import { getIndicadores, getIndicador } from "../../services/indicador";

export const Indicadores = (props) => {
  const { state } = useLocation();

  const [codIndicador, setCodIndicador] = useState(state?.codIndicador);
  const [indicadores, setIndicadores] = useState([]);

  useEffect(() => {
    getIndicadores().then((indicadores) => {
      setIndicadores(indicadores);
    });
  }, []);

  return (
    <MyLayout>
      <Stack spacing={2}>
        <Typography variant="h4">Indicadores da ODS3</Typography>
        <Select defaultValue="" value={codIndicador} label="Indicador">
          {indicadores.map((indicador) => (
            <MenuItem>{`${indicador.codIndicador} - ${indicador.descricao}`}</MenuItem>
          ))}
        </Select>
      </Stack>
    </MyLayout>
  );
};
