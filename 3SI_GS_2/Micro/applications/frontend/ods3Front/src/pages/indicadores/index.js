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

function gerarCoresHexadecimais(listaValores) {
  const numCores = listaValores.length;

  const coresHex = [];

  const incremento = Math.floor(360 / numCores);

  for (let i = 0; i < numCores; i++) {
    const corR = Math.floor(
      Math.sin((i * incremento + 0) * (Math.PI / 180)) * 127 + 128
    );
    const corG = Math.floor(
      Math.sin((i * incremento + 120) * (Math.PI / 180)) * 127 + 128
    );
    const corB = Math.floor(
      Math.sin((i * incremento + 240) * (Math.PI / 180)) * 127 + 128
    );

    const corHex = `#${((corR << 16) | (corG << 8) | corB)
      .toString(16)
      .padStart(6, "0")}`;

    coresHex.push(corHex);
  }

  return coresHex;
}

export const Indicadores = (props) => {
  const { state } = useLocation();

  const [codIndicador, setCodIndicador] = useState(state?.codIndicador);
  const [indicadores, setIndicadores] = useState([]);
  const [indicador, setIndicador] = useState();
  const [categorias, setCategorias] = useState([]);
  const [valoresXSelecionados, setValoresXSelecionados] = useState([]);
  const [numCategoriasSelecionadas, setNumCategoriasSelecionadas] = useState(
    []
  );

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
    setNumCategoriasSelecionadas(novosValores);
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

  const getCategoriasFromNumCategorias = (numCategorias) => {
    return numCategorias.map((numCategoria) =>
      categorias.find((c) => c.numCategoria === numCategoria)
    );
  };

  const categoriasDistintas = getCategoriasFromNumCategorias(
    numCategoriasDistintas
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

  const valoresXFiltrados =
    valoresXSelecionados.length > 0 ? valoresXSelecionados : valoresXDistintos;

  const dadosDoGrafico = valoresXFiltrados.map((vlX) => ({
    colunaX: vlX,
    ...porX.get(vlX),
  }));

  const categoriasFiltradas =
    numCategoriasSelecionadas.length > 0
      ? getCategoriasFromNumCategorias(numCategoriasSelecionadas)
      : categoriasDistintas;

  const cores = gerarCoresHexadecimais(categoriasFiltradas);
  categoriasFiltradas.forEach((categoria, index) => {
    categoria.cor = cores[index];
  });

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
                  value={numCategoriasSelecionadas}
                  label="Categoria"
                  onChange={onChangeCategoriasSelecionadas}
                  renderValue={(selecionados) => (
                    <Box sx={{ display: "flex", flexWrap: "wrap", gap: 0.5 }}>
                      {selecionados.map((valor) => {
                        const nmCategoria = categorias.find(
                          (c) => c.numCategoria === valor
                        )?.nmCategoria;
                        console.log(nmCategoria);
                        return <Chip key={valor} label={nmCategoria} />;
                      })}
                    </Box>
                  )}
                >
                  {categoriasMenuItem}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={6} sx={{ display: "flex", justifyContent: "end" }}>
              <Stack spacing={1} direction="row">
                <Button
                  variant="outlined"
                  startIcon={<Clear />}
                  onClick={() => {
                    setValoresXSelecionados([]);
                    setNumCategoriasSelecionadas([]);
                  }}
                >
                  Limpar Filtros
                </Button>
              </Stack>
            </Grid>
          </Grid>
        )}
        {dadosDoGrafico.length > 0 ? (
          <Box p={2} pr={6} pt={5}>
            <ResponsiveContainer minHeight={400} minWidth={100}>
              <LineChart data={dadosDoGrafico}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="colunaX" />
                <YAxis />
                <Tooltip />
                <Legend />
                {categoriasFiltradas.map((categoria) => (
                  <Line
                    type="monotone"
                    dataKey={categoria.nmCategoria}
                    stroke={`${categoria.cor}`}
                  />
                ))}
              </LineChart>
            </ResponsiveContainer>
          </Box>
        ) : null}
        {!dados || dados.length === 0 ? (
          <Box sx={{ display: "flex", justifyContent: "center" }} pt={3}>
            <Typography variant="h6">
              Não existem dados cadastrados para o indicador
            </Typography>
          </Box>
        ) : null}
      </Stack>
    </MyLayout>
  );
};
