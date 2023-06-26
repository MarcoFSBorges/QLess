import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./ReactRouter.css";
import { Info } from "./components/Info";
import { Login } from "./components/Login";
import { Signup } from "./components/Signup";
import { ForgotPassword } from "./components/ForgotPassword";
import { ResetPassword } from "./components/ResetPassword";
import { UserHomePage } from "./components/UserHomePage";
import { UserNavBar } from "./components/UserNavBar";
import { CreateTicket } from "./components/CreateTicket";

import {
  Link as RouterLink,
  LinkProps as RouterLinkProps,
} from "react-router-dom";
import { LinkProps } from "@mui/material/Link";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import { forwardRef } from "react";
import { RequireAuth } from "react-auth-kit";

/**
 * Change href, from MaterialUI, behaviour. The Original specification only
 * allows the use of href, defeating the purpose of React, since it will force
 * the page to load all elements again
 */
const LinkBehavior = forwardRef<
  HTMLAnchorElement,
  Omit<RouterLinkProps, "to"> & { href: RouterLinkProps["to"] }
>((props, ref) => {
  const { href, ...other } = props;
  // Map href (MUI) -> to (react-router)
  return (
    <RouterLink data-testid="custom-link" ref={ref} to={href} {...other} />
  );
});

/**
 * Theme override to some MaterialUI Components
 */
const theme = createTheme({
  components: {
    MuiLink: {
      defaultProps: {
        component: LinkBehavior,
      } as LinkProps,
    },
    MuiButtonBase: {
      defaultProps: {
        LinkComponent: LinkBehavior,
      },
    },
  },
});

function ReactRouter() {
  return (
    <Router>
      <ThemeProvider theme={theme}>
        <Routes>
          <Route path="/" element={<Info />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/forgot" element={<ForgotPassword />} />
          <Route path="/reset/:resetId" element={<ResetPassword />} />
          <Route
            path="/home"
            element={
              <RequireAuth loginPath="/login">
                <div>
                  <UserNavBar />
                  <UserHomePage />
                </div>
              </RequireAuth>
            }
          ></Route>
          <Route
            path="/createTicket"
            element={
              <RequireAuth loginPath="/login">
                <div>
                  <UserNavBar />
                  <CreateTicket />
                </div>
              </RequireAuth>
            }
          ></Route>
        </Routes>
      </ThemeProvider>
    </Router>
  );
}

export default ReactRouter;