import { useState } from "react";
import {
  Paper,
  Stack,
  Typography,
  TextField,
  Button,
  Box,
} from "@mui/material";
import logo from "../images/QL_1.png";
import axios from "axios";

export function Signup() {
  const [email, setEmail] = useState("");
  const [fname, setFname] = useState("");
  const [lname, setLname] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e: any) => {
    e.preventDefault();
  };

  const register = () => {
    axios
      .post("http://localhost:8080/signup", {
        email,
        fname,
        lname,
        password,
      })
      .then((resp) => {
        console.log(resp);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <>
      <Box>
        <Stack
          direction="column"
          justifyContent="center"
          alignItems="center"
          spacing={2}
        >
          <img className="qlessLogo" src={logo} alt="qless-logo" />
          <form className="qlessResponsiveForm" onSubmit={handleSubmit}>
            <Paper elevation={24} sx={{ padding: "24px" }}>
              <Stack
                direction="column"
                justifyContent="flex-start"
                alignItems="center"
                spacing={2}
              >
                <Typography align="center" variant="h3" fontFamily="sans-serif">
                  Sign up to QLess
                </Typography>

                <TextField
                  fullWidth
                  label="Email"
                  variant="outlined"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
                <TextField
                  fullWidth
                  label="First Name"
                  variant="outlined"
                  value={fname}
                  onChange={(e) => setFname(e.target.value)}
                />
                <TextField
                  fullWidth
                  label="Last Name"
                  variant="outlined"
                  value={lname}
                  onChange={(e) => setLname(e.target.value)}
                />
                <TextField
                  fullWidth
                  label="Password"
                  type="password"
                  variant="outlined"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
              </Stack>
              <Stack
                direction="column"
                justifyContent="flex-start"
                alignItems="flex-start"
                sx={{ paddingTop: "8px" }}
              >
                <Typography align="left" variant="subtitle2">
                  Already have an account?
                </Typography>
              </Stack>

              <Stack
                direction="row"
                justifyContent="center"
                alignItems="center"
                spacing={24}
                sx={{ paddingTop: "4px" }}
              >
                <Button
                  variant="outlined"
                  href="/login"
                  sx={{
                    border: 1,
                    borderColor: "black",
                    backgroundColor: "#e0e0e0",
                    color: "black",
                  }}
                >
                  Login
                </Button>
                <Button
                  onClick={register}
                  variant="outlined"
                  type="submit"
                  sx={{
                    border: 1,
                    borderColor: "black",
                    backgroundColor: "#e0e0e0",
                    color: "black",
                  }}
                >
                  Sign up
                </Button>
              </Stack>
            </Paper>
          </form>
        </Stack>
      </Box>
    </>
  );
}
