import styled from "@emotion/styled";
import { AppBar, Button, Toolbar, Typography } from "@mui/material";
import React from "react";
import logo from "../static/images/cardio.png";
import { useNavigate } from "react-router-dom";
import { PATH_HOME, PATH_INDICADORES, PATH_OBJETIVOS } from "../router";

const ImagemEstilizada = styled.img`
  width: 30px;
  height: auto;
  margin-right: 12px;
`;

export const SpaceAppBarDiv = styled.div`
  height: 64px;
`;

export const MyAppBar = (props) => {
  const navigate = useNavigate();

  return (
    <AppBar
      position="fixed"
      color="default"
      elevation={0}
      sx={{ borderBottom: (theme) => `1px solid ${theme.palette.divider}` }}
    >
      <Toolbar sx={{ flexWrap: "wrap" }}>
        <ImagemEstilizada src={logo} />
        <Typography variant="h6" color="inherit" noWrap sx={{ flexGrow: 1 }}>
          ODS3 - Saúde e Bem-Estar
        </Typography>
        <Button
          variant="outlined"
          sx={{ my: 1, mx: 1.5 }}
          onClick={() => {
            navigate(PATH_HOME);
          }}
        >
          Home
        </Button>
        <Button
          variant="outlined"
          sx={{ my: 1, mx: 1.5 }}
          onClick={() => {
            navigate(PATH_OBJETIVOS);
          }}
        >
          Objetivos
        </Button>
        <Button
          variant="outlined"
          sx={{ my: 1, mx: 1.5 }}
          onClick={() => {
            navigate(PATH_INDICADORES);
          }}
        >
          Indicadores
        </Button>
      </Toolbar>
    </AppBar>
  );
};
