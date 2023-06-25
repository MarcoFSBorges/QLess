import { useState } from "react";
import {
  Paper,
  Stack,
  Typography,
  TextField,
  Button,
  Link,
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
      <Box sx={{ width: "90%", margin: "auto", marginTop: "5%" }}>
        <Stack spacing={5}>
          <Paper elevation={4} sx={{ padding: "40px 10px" }}>
            <Stack direction={{ xs: "column", sm: "row" }}>
              <img
                className="renderLogo margin-auto"
                src={renderLogo}
                alt="qless-logo"
              />
              <Typography
                padding="10px"
                margin="auto"
                align="center"
                variant="h4"
                fontFamily="sans-serif"
                gutterBottom
                sx={{ color: "black" }}
              >
                This web application will utilize Render for hosting the
                front-end, back-end, and the database infrastructure.
              </Typography>
            </Stack>
          </Paper>
          <Paper elevation={4} sx={{ padding: "40px 10px" }}>
            <Stack direction={{ xs: "column", sm: "row" }}>
              <Typography
                padding="15px"
                margin="auto"
                align="center"
                variant="h4"
                fontFamily="sans-serif"
                gutterBottom
                sx={{ color: "black" }}
              >
                QLess web application developed using Kotlin, leveraging its
                features and capabilities for the backend implementation.
              </Typography>
              <img
                className="renderLogo margin-auto"
                src={kotlinLogo}
                alt="qless-logo"
              />
            </Stack>
          </Paper>
          <Paper elevation={4} sx={{ padding: "40px 10px" }}>
            <Stack direction={{ xs: "column", sm: "row" }}>
              <img
                className="renderLogo margin-auto"
                src={springLogo}
                alt="qless-logo"
              />
              <Typography
                padding="10px"
                margin="auto"
                align="left"
                variant="h4"
                fontFamily="sans-serif"
                gutterBottom
                sx={{ color: "black" }}
              >
                The backend of this web application will be built using the
                Spring framework, harnessing its robust features and
                functionalities.
              </Typography>
            </Stack>
          </Paper>
          <Paper elevation={4} sx={{ padding: "40px 10px" }}>
            <Stack direction={{ xs: "column", sm: "row" }}>
              <Typography
                padding="10px"
                margin="auto"
                align="left"
                variant="h4"
                fontFamily="sans-serif"
                gutterBottom
                sx={{ color: "black" }}
              >
                Gradle will serve as the primary build tool for this project,
                facilitating dependency management and project compilation.
              </Typography>
              <img
                className="renderLogo margin-auto"
                src={gradleLogo}
                alt="qless-logo"
              />
            </Stack>
          </Paper>
          <Paper elevation={4} sx={{ padding: "40px 10px" }}>
            <Stack direction={{ xs: "column", sm: "row" }}>
              <img
                className="renderLogo margin-auto"
                src={reactLogo}
                alt="qless-logo"
              />
              <Typography
                padding="10px"
                margin="auto"
                align="left"
                variant="h4"
                fontFamily="sans-serif"
                gutterBottom
                sx={{ color: "black" }}
              >
                The front-end of this web application will be developed using
                React, harnessing its powerful components and interactive UI
                capabilities.
              </Typography>
            </Stack>
          </Paper>
          <Paper elevation={4} sx={{ padding: "40px 10px" }}>
            <Stack direction={{ xs: "column", sm: "row" }}>
              <Typography
                padding="10px"
                margin="auto"
                align="left"
                variant="h4"
                fontFamily="sans-serif"
                gutterBottom
                sx={{ color: "black" }}
              >
                The UI of this web application will be designed using Material
                UI, leveraging its sleek components and modern styling.
              </Typography>
              <img
                className="renderLogo margin-auto"
                src={muiLogo}
                alt="qless-logo"
              />
            </Stack>
          </Paper>
        </Stack>
      </Box>
    </>
  );
}
