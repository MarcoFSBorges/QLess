import { Stack, Typography, Paper } from "@mui/material";

interface InfoItemProps {
  children: React.ReactNode;
  logo: string;
}

function InfoItem({ children, logo }: InfoItemProps) {
  return (
    <Paper elevation={4} sx={{ padding: "40px 10px" }}>
      <Stack direction={{ xs: "column", sm: "row" }}>
        <img className="renderLogo margin-auto" src={logo} alt="qless-logo" />

        <Typography
          padding="10px"
          align="left"
          variant="h6"
          fontFamily="sans-serif"
          gutterBottom
          sx={{ color: "black" }}
        >
          {children}
        </Typography>
      </Stack>
    </Paper>
  );
}

export default InfoItem;
