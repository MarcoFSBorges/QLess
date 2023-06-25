import React from "react";
import { createRoot } from "react-dom/client";
import ReactRouter from "./ReactRouter";
import "./index.css";
import { AuthProvider } from "react-auth-kit";

const root = createRoot(document.getElementById("root")!);
root.render(
  <React.StrictMode>
    <AuthProvider
      authType={"cookie"}
      authName={"qless-cookie"}
      cookieDomain={window.location.hostname}
      cookieSecure={false}
    >
      <ReactRouter />
    </AuthProvider>
  </React.StrictMode>
);
