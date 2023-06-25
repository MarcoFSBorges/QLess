import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import Menu from "@mui/material/Menu";
import MenuIcon from "@mui/icons-material/Menu";
import Container from "@mui/material/Container";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import Tooltip from "@mui/material/Tooltip";
import MenuItem from "@mui/material/MenuItem";
import AdbIcon from "@mui/icons-material/Adb";

import logo from "../images/QL_1.png";

const pages = ["Products", "Pricing", "Blog"];
const settings = ["Profile", "Account", "Dashboard", "Logout"];

function InfoNavBar(props: any) {
  return (
    <AppBar
      sx={{ backgroundColor: "#B8B08D", color: "black" }}
      position="static"
    >
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <Box sx={{ display: { xs: "none", md: "flex" } }}>
            <img src={logo} alt="qless-logo" height={"50px"} />
          </Box>

          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              flexGrow: 1,
              display: { xs: "none", md: "flex" },
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            QLess
          </Typography>
          <Box sx={{ display: { xs: "flex", md: "none" } }}>
            <img src={logo} alt="qless-logo" height={"50px"} />
          </Box>
          <Typography
            variant="h5"
            noWrap
            component="a"
            href=""
            sx={{
              mr: 2,
              display: { xs: "flex", md: "none" },
              flexGrow: 1,
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            QLess
          </Typography>

          <Button
            href="/login"
            variant="contained"
            sx={{
              color: "#283845",
              borderColor: "black",
              backgroundColor: "white",
              "&:hover": {
                color: "white",
                backgroundColor: "#283845",
              },
            }}
          >
            Log In
          </Button>
          <Button
            href="/signup"
            variant="contained"
            sx={{
              color: "white",
              borderColor: "#",
              marginLeft: "20px",
              backgroundColor: "#283845",
              "&:hover": {
                color: "#283845",
                backgroundColor: "white",
                borderColor: "white",
              },
            }}
          >
            Sign Up
          </Button>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default InfoNavBar;
