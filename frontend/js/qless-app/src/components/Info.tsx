import { useState } from "react";
import {
  Paper,
  Box,
  Container,
  Grid,
} from "@mui/material";

import logo from "../images/QL_1.png";
import renderLogo from "../images/render.webp";
import kotlinLogo from "../images/Kotlin_logo.png";
import springLogo from "../images/springLogo.png";
import reactLogo from "../images/Reactlogopng.png";
import muiLogo from "../images/MateriauiLogo.png";
import gradleLogo from "../images/gradle.svg";
import { red } from "@mui/material/colors";
import InfoNavBar from "./InfoNavBar";
import { styled } from "@mui/material/styles";
import InfoItem from "./InfoItem";

export function Info() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e: any) => {
    e.preventDefault();
  };

  const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === "dark" ? "#1A2027" : "#fff",
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: "center",
    color: theme.palette.text.secondary,
  }));

  return (
    <>
      <InfoNavBar>
        <Container
          sx={{ display: "flex", float: "right", backgroundColor: red }}
        >
          <img className="qlessLogo" src={logo} alt="qless-logo" />
        </Container>
      </InfoNavBar>
      <Box
        display="flex"
        justifyContent="center"
        alignItems="center"
        sx={{ margin: "40px 0px" }}
      >
        <Box width="80%">
          <Grid
            alignItems="center"
            justifyContent="center"
            container
            rowSpacing={{ xs: 1, sm: 2, md: 3 }}
            columnSpacing={{ xs: 1, sm: 2, md: 3 }}
          >
            <Grid item xs={12} md={6}>
              <InfoItem logo={renderLogo}>
                This web application utilizes Render for hosting the front-end,
                back-end, and the database infrastructure.
              </InfoItem>
            </Grid>
            <Grid item xs={12} md={6}>
              <InfoItem logo={kotlinLogo}>
                QLess web application developed with Kotlin, leveraging its
                features and capabilities for the backend implementation.
              </InfoItem>
            </Grid>
            <Grid item xs={12} md={6}>
              <InfoItem logo={springLogo}>
                The backend of this web application uses the Spring framework,
                harnessing its robust features and functionalities.
              </InfoItem>
            </Grid>
            <Grid item xs={12} md={6}>
              <InfoItem logo={gradleLogo}>
                Gradle serves as the primary build tool for this project,
                facilitating dependency management and project compilation.
              </InfoItem>
            </Grid>
            <Grid item xs={12} md={6}>
              <InfoItem logo={reactLogo}>
                The front-end of this web application uses React, harnessing its
                powerful components and interactive UI capabilities.
              </InfoItem>
            </Grid>
            <Grid item xs={12} md={6}>
              <InfoItem logo={muiLogo}>
                The UI of this web application uses Material UI, leveraging its
                sleek components and modern styling.
              </InfoItem>
            </Grid>
          </Grid>
        </Box>
      </Box>
    </>
  );
}
