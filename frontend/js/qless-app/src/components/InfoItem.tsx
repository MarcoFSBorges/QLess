import Stack from "@mui/material/Stack";
import Typography from "@mui/material/Typography";

function InfoItem(logo: string, logoText: string) {
  return (
    <Stack direction={{ xs: "column", sm: "row" }}>
      <img className="renderLogo margin-auto" src={logo} alt="qless-logo" />
      <Typography
        padding="10px"
        margin="auto"
        align="left"
        variant="h4"
        fontFamily="sans-serif"
        gutterBottom
        sx={{ color: "black" }}
      >
        logoText
      </Typography>
    </Stack>
  );
}

export default InfoItem;
