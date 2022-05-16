import { Button, Checkbox, TableCell, TableRow, Tooltip } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";

const TrialRow = (props) => {
	const row = props.data;
	const handleClick = (event, id) => {
		console.log(event);
		console.log(id);
	};

	return (
		<TableRow hover onClick={(event) => handleClick(event, row.id)} role="checkbox" key={row.id}>
			<TableCell padding="checkbox">
				<Checkbox
					color="primary"
					inputProps={{
						"aria-labelledby": row.id,
					}}
				/>
			</TableCell>
			<TableCell component="th" id={row.id} scope="row" padding="normal">
				{row.name}
			</TableCell>
			<TableCell>{row.description}</TableCell>
			<TableCell>{new Date().toDateString()}</TableCell>
			<TableCell>
				<Tooltip title="Go to Trial">
					<Button to={`${row.id}`} component={Link} variant="contained">
						Open
					</Button>
				</Tooltip>
			</TableCell>
		</TableRow>
	);
};

export default TrialRow;
