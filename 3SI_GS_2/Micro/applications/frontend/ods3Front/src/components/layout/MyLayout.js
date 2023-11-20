import React from "react";
import { MyAppBar, SpaceAppBarDiv } from "../MyAppBar";
import { MyFooter } from "../MyFooter";

export const MyLayout = (props) => {
  const { ignoreBarSpace = true } = props;

  return (
    <>
      <MyAppBar />
      {ignoreBarSpace ? <SpaceAppBarDiv /> : null}
      {props.children}
      <MyFooter />
    </>
  );
};
