import { Link } from "react-router-dom";
import { Fragment } from "react";
import { Container } from "@mui/material";
import Header from "./Header";

const DefaultLayout = (props) => {
	return (
		<Fragment>
			<Header />
			<Container maxWidth="lg">{props.children}</Container>
		</Fragment>
	);
};

export default DefaultLayout;
