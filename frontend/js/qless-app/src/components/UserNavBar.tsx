import {
  AppBar,
  Toolbar,
  IconButton,
  Stack,
  Menu,
  MenuItem,
  Link,
  Paper,
  Typography,
} from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import AccountBoxIcon from "@mui/icons-material/AccountBox";
import Divider from "@mui/material/Divider";
import logo from "../images/QL_1.png";
import { useState } from "react";
import { Settings } from "./Settings";
import { useSignOut, useAuthHeader } from "react-auth-kit";
import { useNavigate } from "react-router-dom";

export function UserNavBar() {
  const authHeader = useAuthHeader();

  const hamburguer_menu = [
    {
      link: `/createTicket/${authHeader().split(" ")[1]}`,
      label: "Create Ticket",
      isStatus: false,
    },
    {
      link: `/tickets/${authHeader().split(" ")[1]}`,
      label: "My Tickets",
      isStatus: false,
    },
    {
      link: `/tickets/${authHeader().split(" ")[1]}`,
      label: "Created",
      isStatus: true,
    }, // /tickets/:qlessId?status=created
    {
      link: `/tickets/${authHeader().split(" ")[1]}`,
      label: "Ongoing",
      isStatus: true,
    }, // /tickets/:qlessId?status=ongoing
    {
      link: `/tickets/${authHeader().split(" ")[1]}`,
      label: "Solved",
      isStatus: true,
    }, // /tickets/:qlessId?status=solved
    {
      link: `/tickets/${authHeader().split(" ")[1]}`,
      label: "Cancelled",
      isStatus: true,
    }, // /tickets/:qlessId?status=cancelled
    {
      link: `/tickets/${authHeader().split(" ")[1]}`,
      label: "Archived",
      isStatus: true,
    }, // /tickets/:qlessId?status=archived
    { link: "/faq", label: "F.A.Q", isStatus: false },
    { link: "/about", label: "About", isStatus: false },
  ];

  const [anchorElHamburguer, setAnchorElHamburguer] =
    useState<null | HTMLElement>(null);
  const openHamburguer = Boolean(anchorElHamburguer);

  const [anchorElProfile, setAnchorElProfile] = useState<null | HTMLElement>(
    null
  );
  const openProfile = Boolean(anchorElProfile);

  const [openSettings, setOpenSettings] = useState(false);

  const handleHamburguerClick = (
    event: React.MouseEvent<HTMLButtonElement>
  ) => {
    setAnchorElHamburguer(event.currentTarget);
  };

  const handleProfileClick = (event: React.MouseEvent<HTMLButtonElement>) => {
    setAnchorElProfile(event.currentTarget);
  };

  const handleHamburguerClose = () => {
    setAnchorElHamburguer(null);
  };

  const handleProfileClose = () => {
    setAnchorElProfile(null);
  };

  const handleClickOpenSettings = () => {
    openSettings ? setOpenSettings(false) : setOpenSettings(true);
  };

  const signOut = useSignOut();
  const navigate = useNavigate();

  const logout = () => {
    signOut();
    navigate("/login");
  };

  return (
    <AppBar position="absolute" elevation={0} sx={{ background: "#f2ebc9" }}>
      <Toolbar>
        <IconButton
          id="hamburguer-button"
          onClick={handleHamburguerClick}
          size="large"
          edge="start"
          aria-controls={openHamburguer ? "hamburguer-menu" : undefined}
          aria-haspopup="true"
          aria-expanded={openHamburguer ? "true" : undefined}
          aria-label="menu"
        >
          <MenuIcon />
        </IconButton>
        <Stack
          direction="row"
          justifyContent="center"
          height="150px"
          sx={{ flexGrow: 1 }}
        >
          <img src={logo} alt="qless-logo" />
        </Stack>
        <IconButton
          id="profile-button"
          onClick={handleProfileClick}
          size="large"
          edge="end"
          aria-controls={openProfile ? "profile-menu" : undefined}
          aria-haspopup="true"
          aria-expanded={openProfile ? "true" : undefined}
          aria-label="profile"
        >
          <AccountBoxIcon />
        </IconButton>
        <Menu
          id="hamburguer-menu"
          anchorEl={anchorElHamburguer}
          open={openHamburguer}
          MenuListProps={{ "aria-labelledby": "hamburguer-button" }}
          onClose={handleHamburguerClose}
        >
          {hamburguer_menu.map((option) => (
            <>
              <MenuItem key={option.link}>
                {option.isStatus ? (
                  <Link
                    href={option.link}
                    underline="hover"
                    textAlign="center"
                    color="inherit"
                    fontFamily="monospace"
                    fontWeight={500}
                    paddingLeft={1}
                  >
                    {option.label}
                  </Link>
                ) : (
                  <Link
                    href={option.link}
                    underline="hover"
                    textAlign="center"
                    color="inherit"
                    fontFamily="monospace"
                    fontWeight={700}
                  >
                    {option.label}
                  </Link>
                )}
              </MenuItem>
              {option.label !== "About" ? <Divider /> : <div />}
            </>
          ))}
        </Menu>

        <Menu
          id="profile-menu"
          anchorEl={anchorElProfile}
          open={openProfile}
          MenuListProps={{ "aria-labelledby": "profile-button" }}
          onClose={handleProfileClose}
        >
          <Paper elevation={24} sx={{ padding: "16px", width: "45vh" }}>
            <Stack direction="row" justifyContent="center" spacing={1}>
              <Typography variant="h5" fontFamily="monospace" fontSize={25}>
                First name
              </Typography>
              <Typography variant="h5" fontFamily="monospace" fontSize={25}>
                Last name
              </Typography>
            </Stack>
            <p />
            <Typography
              align="center"
              variant="h6"
              fontFamily="monospace"
              fontSize={15}
            >
              Email
            </Typography>
            <Divider />
            <Stack direction="column" spacing={1}>
              <Link
                onClick={handleClickOpenSettings}
                underline="hover"
                textAlign="center"
                color="inherit"
                fontFamily="monospace"
                fontSize={20}
                paddingTop={1}
              >
                Settings
              </Link>

              {openSettings ? <Settings /> : null}

              <Link
                onClick={logout}
                underline="hover"
                textAlign="center"
                color="inherit"
                fontFamily="monospace"
                fontSize={20}
              >
                Logout
              </Link>
            </Stack>
          </Paper>
        </Menu>
      </Toolbar>
    </AppBar>
  );
}
