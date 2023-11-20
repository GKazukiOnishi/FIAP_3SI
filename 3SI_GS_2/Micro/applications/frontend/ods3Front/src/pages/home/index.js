import styled from "@emotion/styled";
import { Box, Grid, Stack, Typography } from "@mui/material";
import React from "react";
import { MyLayout } from "../../components/layout/MyLayout";
import homeImg from "../../static/images/undraw_medicine_b-1-ol.svg";
import { SpaceAppBarDiv } from "../../components/MyAppBar";

const ImagemEstilizada = styled.div`
  background-image: url(${homeImg});
  height: 100vh;
  background-repeat: no-repeat;
  background-position: 50%;
  resize: vertical;
`;

export const Home = () => {
  return (
    <MyLayout ignoreBarSpace={false} applyPadding={false}>
      <Grid container spacing={2}>
        <Grid item xs={6}>
          <Stack>
            <SpaceAppBarDiv />
            <Stack spacing={2} p={3}>
              <Typography variant="h4">
                ODS - Objetivos de Desenvolvimento Sustentável
              </Typography>
              <Typography variant="body1" textAlign={"justify"}>
                Os Objetivos de Desenvolvimento Sustentável (ODS) são uma
                iniciativa global estabelecida pelas Nações Unidas em setembro
                de 2015 como parte da Agenda 2030 para o Desenvolvimento
                Sustentável. Esses objetivos foram desenvolvidos para abordar
                uma série de desafios mundiais, incluindo pobreza, fome, saúde,
                educação, igualdade de gênero, água limpa, saneamento, energia
                acessível, crescimento econômico, entre outros, enquanto levam
                em conta a proteção ambiental.
              </Typography>
              <Box p={1} />
              <Typography variant="h4">ODS3 - Saúde e Bem-Estar</Typography>
              <Typography variant="body1" textAlign={"justify"}>
                A ODS3 se refere ao terceiro Objetivo de Desenvolvimento
                Sustentável (ODS) estabelecido pelas Nações Unidas como parte da
                Agenda 2030 para o Desenvolvimento Sustentável. O ODS3 tem como
                foco "Saúde e Bem-Estar" e visa garantir uma vida saudável e
                promover o bem-estar para todas as pessoas em todas as idades.
              </Typography>
              <Box p={1} />
              <Typography variant="h6" textAlign={"justify"}>
                Neste site você terá meios de visualizar as métricas da ODS3,
                possibilitando um acompanhamento factual e realista do objetivo.
              </Typography>
            </Stack>
          </Stack>
        </Grid>
        <Grid item xs={6}>
          <ImagemEstilizada />
        </Grid>
      </Grid>
    </MyLayout>
  );
};
