import { useState } from "react";
import {
  Paper,
  Stack,
  Typography,
  TextField,
  Button,
  Link,
  Box,
} from "@mui/material";
import logo from "../images/QL_1.png";
import axios from "axios";
import { useSignIn } from "react-auth-kit";
import { useNavigate } from "react-router-dom";

export function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const signIn = useSignIn();

  const handleSubmit = (e: any) => {
    e.preventDefault();
  };

  let navigate = useNavigate();

  const logIn = () => {
    axios
      .post(
        "http://localhost:8080/login",
        { email, password },
        { withCredentials: true }
      )
      .then((res) => {
        console.log(res.data)
        signIn({
          token: res.data,
          tokenType: "Bearer",
          expiresIn: 3600,
          authState: { email: email },
        });
        alert("Successfully logged in!");
        navigate(`/home`);
      })
      .catch((err) => {
        console.log(err);
        alert("Wrong username or password!");
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
                  Login to QLess
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
                  <Link href="/forgot" underline="hover" color="#757575">
                    Forgot password?
                  </Link>
                </Typography>
                <Typography align="left" variant="subtitle2">
                  Don't have an account?
                </Typography>
              </Stack>

              <Stack
                direction="row"
                justifyContent="center"
                alignItems="center"
                spacing={18}
                sx={{ paddingTop: "8px" }}
              >
                <Button
                  variant="outlined"
                  href="/signup"
                  sx={{
                    border: 1,
                    borderColor: "black",
                    backgroundColor: "#e0e0e0",
                    color: "black",
                  }}
                >
                  Sign up
                </Button>
                <Button
                  onClick={logIn}
                  variant="outlined"
                  type="submit"
                  sx={{
                    border: 1,
                    borderColor: "black",
                    backgroundColor: "#e0e0e0",
                    color: "black",
                  }}
                >
                  Login
                </Button>
              </Stack>
            </Paper>
          </form>
        </Stack>
      </Box>
    </>
  );
}
