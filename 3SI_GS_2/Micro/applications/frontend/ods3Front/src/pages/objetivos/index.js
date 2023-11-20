import React, { useEffect, useState } from "react";
import { MyLayout } from "../../components/layout/MyLayout";
import {
  Accordion,
  AccordionDetails,
  AccordionSummary,
  Button,
  ButtonGroup,
  Grid,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Paper,
  Stack,
  Typography,
} from "@mui/material";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import { Search } from "@mui/icons-material";
import { getMetas } from "../../services/objetivos";
import { useNavigate } from "react-router-dom";
import { PATH_INDICADORES } from "../../router";

const ORIGEM_BRASIL = "Brasil";
const ORIGEM_NACOES_UNIDAS = "Nações Unidas";

export const Objetivos = (props) => {
  const [metas, setMetas] = useState([]);
  const [origem, setOrigem] = useState(ORIGEM_BRASIL);

  const navigate = useNavigate();

  useEffect(() => {
    getMetas().then((metas) => {
      setMetas(metas);
    });
  }, []);

  return (
    <MyLayout>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <Typography variant="h3">Objetivos</Typography>
        </Grid>
        <Grid
          item
          xs={12}
          sx={{ display: "flex", flexDirection: "row-reverse" }}
          my={2}
        >
          <ButtonGroup
            variant="contained"
            aria-label="outlined primary button group"
          >
            <Button
              disabled={origem === ORIGEM_BRASIL}
              onClick={() => {
                setOrigem(ORIGEM_BRASIL);
              }}
            >
              Brasil
            </Button>
            <Button
              disabled={origem === ORIGEM_NACOES_UNIDAS}
              onClick={() => {
                setOrigem(ORIGEM_NACOES_UNIDAS);
              }}
            >
              Mundo
            </Button>
          </ButtonGroup>
        </Grid>
        <Grid item xs={12}>
          <Paper elevation={4}>
            {metas.map((meta) => (
              <Accordion key={meta?.codMeta}>
                <AccordionSummary expandIcon={<ExpandMoreIcon />}>
                  <Stack spacing={1}>
                    <Typography variant="h6">{meta?.codMeta}</Typography>
                    <Typography variant="body1">
                      {
                        meta?.objetivos?.filter((o) => o.origem === origem)[0]
                          ?.objetivo
                      }
                    </Typography>
                  </Stack>
                </AccordionSummary>
                <AccordionDetails>
                  <Paper elevation={4}>
                    <List>
                      {meta?.indicadores?.map((indicador) => (
                        <ListItem disablePadding key={indicador.codIndicador}>
                          <ListItemButton
                            onClick={() => {
                              navigate(PATH_INDICADORES, {
                                state: { codIndicador: indicador.codIndicador },
                              });
                            }}
                          >
                            <ListItemIcon>
                              <Search />
                            </ListItemIcon>
                            <ListItemText
                              primary={`${indicador.codIndicador} - ${indicador.descricao}`}
                            />
                          </ListItemButton>
                        </ListItem>
                      ))}
                    </List>
                  </Paper>
                </AccordionDetails>
              </Accordion>
            ))}
          </Paper>
        </Grid>
      </Grid>
    </MyLayout>
  );
};
