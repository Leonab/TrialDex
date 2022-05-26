import GoogleIcon from "@mui/icons-material/Google";
import FacebookIcon from '@mui/icons-material/Facebook';
import { Box, Button, Paper, Stack } from "@mui/material";
import React from "react";
import { GOOGLE_OAUTH_ENDPOINT } from "../../constants";

const Login = () => {
	return (
		<Box maxWidth="50%" margin="0 auto">
			<Box padding={10}>
				<Paper elevation={4} sx={{ padding: 10 }}>
					<Stack spacing={3}>
						<Button variant="contained" startIcon={<GoogleIcon />} size="large" href={GOOGLE_OAUTH_ENDPOINT}>
							Log in with Google
						</Button>
						<Button variant="contained" startIcon={<FacebookIcon />} size="large">
							Log in with Facebook
						</Button>
					</Stack>
				</Paper>
			</Box>
		</Box>
	);
};

export default Login;
