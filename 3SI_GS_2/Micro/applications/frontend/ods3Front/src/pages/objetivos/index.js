import React, { useEffect } from "react";
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
import { getObjetivos } from "../../services/objetivos";

export const Objetivos = (props) => {
  useEffect(() => {
    getObjetivos();
  }, []);

  return (
    <MyLayout>
      <Grid container spacing={2} pt={7} px={7} pb={3}>
        <Grid item xs={12}>
          <Typography variant="h3">Objetivos</Typography>
        </Grid>
        <Grid
          item
          xs={12}
          sx={{ display: "flex", flexDirection: "row-reverse" }}
        >
          <ButtonGroup
            variant="contained"
            aria-label="outlined primary button group"
          >
            <Button>Brasil</Button>
            <Button>Mundo</Button>
          </ButtonGroup>
        </Grid>
        <Grid item xs={12}>
          <Paper elevation={4}>
            <Accordion>
              <AccordionSummary expandIcon={<ExpandMoreIcon />}>
                <Stack spacing={1}>
                  <Typography variant="h6">3.1</Typography>
                  <Typography variant="body1">
                    Até 2030, reduzir a taxa de mortalidade materna global para
                    menos de 70 mortespor 100.000 nascidos vivos.{" "}
                  </Typography>
                </Stack>
              </AccordionSummary>
              <AccordionDetails>
                <Paper elevation={4}>
                  <List>
                    <ListItem disablePadding>
                      <ListItemButton>
                        <ListItemIcon>
                          <Search />
                        </ListItemIcon>
                        <ListItemText primary="3.2.1 - Taxa de mortalidade em menores de 5 anos." />
                      </ListItemButton>
                    </ListItem>
                  </List>
                </Paper>
              </AccordionDetails>
            </Accordion>
          </Paper>
        </Grid>
      </Grid>
    </MyLayout>
  );
};
