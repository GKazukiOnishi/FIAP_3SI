import { Paper, Typography, styled } from "@mui/material";

const Item = styled(Paper)(({ theme }) => ({
  color: theme.palette.text.primary,
}));

export const MyFooter = (props) => {
  return (
    <Item elevation={6} sx={{ display: "flex", justifyContent: "center" }}>
      <Typography variant="subtitle" py={1}>
        Copyright © 2023 Gabriel e Breno. Todos os direitos reservados.
      </Typography>
    </Item>
  );
};
