import { Paper, Typography, styled } from "@mui/material";

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.secondary.main,
  color: theme.palette.text.primary,
}));

export const MyFooter = (props) => {
  return (
    <Item elevation={3} sx={{ display: "flex", justifyContent: "center" }}>
      <Typography variant="subtitle">
        Copyright © 2023 Gabriel e Breno. Todos os direitos reservados.
      </Typography>
    </Item>
  );
};
