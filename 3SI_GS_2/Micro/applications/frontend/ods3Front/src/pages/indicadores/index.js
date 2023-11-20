import { Clear } from "@mui/icons-material";
import {
  Box,
  Button,
  Chip,
  FormControl,
  Grid,
  InputLabel,
  MenuItem,
  Select,
  Stack,
  Typography,
} from "@mui/material";
import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import {
  CartesianGrid,
  Legend,
  Line,
  LineChart,
  ResponsiveContainer,
  Tooltip,
  XAxis,
  YAxis,
} from "recharts";
import { MyLayout } from "../../components/layout/MyLayout";
import { getCategorias } from "../../services/categorias";
import { getIndicador, getIndicadores } from "../../services/indicador";

const nivelEnum = new Map()
  .set("PA", "País")
  .set("GR", "Grande Região")
  .set("UF", "Unidade da Federação")
  .set("RE", "Região");

export const Indicadores = (props) => {
  const { state } = useLocation();

  const [codIndicador, setCodIndicador] = useState(state?.codIndicador);
  const [indicadores, setIndicadores] = useState([]);
  const [indicador, setIndicador] = useState();
  const [categorias, setCategorias] = useState([]);
  const [valoresXSelecionados, setValoresXSelecionados] = useState([]);
  const [categoriasSelecionadas, setCategoriasSelecionadas] = useState([]);

  useEffect(() => {
    getIndicadores().then((indicadores) => {
      setIndicadores(indicadores);
    });
    getCategorias().then((categorias) => {
      setCategorias(categorias);
    });
  }, []);

  useEffect(() => {
    if (!codIndicador) return;
    getIndicador(codIndicador).then((indicador) => {
      setIndicador(indicador);
    });
  }, [codIndicador]);

  const onChangeIndicador = (event) => {
    const codIndicador = event.target.value;
    setCodIndicador(codIndicador);
  };

  const onChangeValoresXSelecionados = (event) => {
    const valor = event.target.value;
    const novosValores = valor === "string" ? valor.split(",") : valor;
    setValoresXSelecionados(novosValores);
  };

  const onChangeCategoriasSelecionadas = (event) => {
    const valor = event.target.value;
    const novosValores = valor === "string" ? valor.split(",") : valor;
    setCategorias(novosValores);
  };

  const colunaX = indicador?.nmColunaX;
  const colunaY = indicador?.nmColunaY;
  const observacao = indicador?.observacao;
  const dados = indicador?.dados ?? [];
  const valoresXDistintos = [];
  let numCategoriasDistintas = [];
  dados.forEach((d) => {
    if (!valoresXDistintos.includes(d.vlX)) {
      valoresXDistintos.push(d.vlX);
    }
    if (!numCategoriasDistintas.includes(d.numCategoria)) {
      numCategoriasDistintas.push(d.numCategoria);
    }
  });
  const categoriasDistintas = numCategoriasDistintas.map((numCategoria) =>
    categorias.find((c) => c.numCategoria === numCategoria)
  );
  categoriasDistintas.sort((a, b) =>
    a.nmCategoria.localeCompare(b.nmCategoria)
  );
  const categoriasPorNivel = new Map();
  categoriasDistintas.forEach((c) => {
    if (categoriasPorNivel.has(c.nivel)) {
      categoriasPorNivel.get(c.nivel).push(c);
    } else {
      categoriasPorNivel.set(c.nivel, [c]);
    }
  });

  const categoriasMenuItem = [];
  for (const nivel of categoriasPorNivel.keys()) {
    categoriasMenuItem.push(
      <Typography key={nivel} pl={1} variant="subtitle1" fontWeight="bold">
        {nivelEnum.get(nivel)}
      </Typography>
    );
    const categorias = categoriasPorNivel.get(nivel);
    categorias.forEach((categoria) => {
      categoriasMenuItem.push(
        <MenuItem key={categoria.numCategoria} value={categoria.numCategoria}>
          {categoria.nmCategoria}
        </MenuItem>
      );
    });
  }

  const getDescricaoCategoria = (numCategoria) =>
    categorias.find((c) => c.numCategoria === numCategoria)?.nmCategoria;

  const porX = new Map();
  dados.forEach((d) => {
    porX.set(d.vlX, {
      ...(porX.get(d.vlX) ?? {}),
      [getDescricaoCategoria(d.numCategoria)]: d.vlY,
    });
  });

  const dadosDoGrafico = valoresXDistintos.map((vlX) => ({
    colunaX: vlX,
    ...porX.get(vlX),
  }));

  return (
    <MyLayout>
      <Stack spacing={2}>
        <Typography variant="h4">Indicadores da ODS3</Typography>
        <FormControl fullWidth={true}>
          <InputLabel htmlFor="indicador-select">Indicador</InputLabel>
          <Select
            id="indicador-select"
            defaultValue=""
            value={codIndicador}
            label="Indicador"
            onChange={onChangeIndicador}
          >
            {indicadores.map((indicador) => (
              <MenuItem
                key={indicador.codIndicador}
                value={indicador.codIndicador}
              >{`${indicador.codIndicador} - ${indicador.descricao}`}</MenuItem>
            ))}
          </Select>
        </FormControl>
        {observacao && <Typography variant="h5">{observacao}</Typography>}
        {valoresXDistintos.length > 0 && (
          <Grid container>
            <Grid item xs={3}>
              <Box mr={1}>
                <FormControl fullWidth={true}>
                  <InputLabel htmlFor={`${colunaX}-select`}>
                    {colunaX}
                  </InputLabel>
                  <Select
                    id={`${colunaX}-select`}
                    defaultValue=""
                    multiple
                    value={valoresXSelecionados}
                    label={colunaX}
                    onChange={onChangeValoresXSelecionados}
                    renderValue={(selecionados) => (
                      <Box sx={{ display: "flex", flexWrap: "wrap", gap: 0.5 }}>
                        {selecionados.map((valor) => (
                          <Chip key={valor} label={valor} />
                        ))}
                      </Box>
                    )}
                  >
                    {valoresXDistintos.map((valorX) => (
                      <MenuItem key={valorX} value={valorX}>
                        {valorX}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
              </Box>
            </Grid>
            <Grid item xs={3}>
              <FormControl fullWidth={true}>
                <InputLabel htmlFor="categoria-select">Categoria</InputLabel>
                <Select
                  id="categoria-select"
                  defaultValue=""
                  multiple
                  value={categoriasSelecionadas}
                  label="Categoria"
                  onChange={onChangeCategoriasSelecionadas}
                  renderValue={(selecionados) => (
                    <Box sx={{ display: "flex", flexWrap: "wrap", gap: 0.5 }}>
                      {selecionados.map((valor) => (
                        <Chip key={valor} label={valor} />
                      ))}
                    </Box>
                  )}
                >
                  {categoriasMenuItem}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={6} sx={{ display: "flex", justifyContent: "end" }}>
              <Stack spacing={1} direction="row">
                <Button variant="outlined" startIcon={<Clear />}>
                  Limpar
                </Button>
                <Button variant="contained">Filtrar</Button>
              </Stack>
            </Grid>
          </Grid>
        )}
        <Box p={2}>
          <LineChart data={dadosDoGrafico} width={800} height={300}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="colunaX" />
            <YAxis />
            <Tooltip />
            <Legend />
            <Line type="monotone" dataKey="Brasil" stroke="#8884d8" />
          </LineChart>
        </Box>
      </Stack>
    </MyLayout>
  );
};
