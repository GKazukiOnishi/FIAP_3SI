import React from "react";
import { MyAppBar, SpaceAppBarDiv } from "../MyAppBar";
import { MyFooter } from "../MyFooter";
import { Box } from "@mui/material";

export const MyLayout = (props) => {
  const { ignoreBarSpace = true, applyPadding = true } = props;

  return (
    <>
      <Box sx={{ minHeight: "100vh" }}>
        <MyAppBar />
        {ignoreBarSpace ? <SpaceAppBarDiv /> : null}
        {applyPadding ? (
          <Box pt={7} px={7} pb={4}>
            {props.children}
          </Box>
        ) : (
          props.children
        )}
      </Box>
      <MyFooter />
    </>
  );
};
