import AddIcon from "@mui/icons-material/Add";
import { Box, Button, Paper, Typography } from "@mui/material";
import { Fragment, useState } from "react";
import CreateTrialDialog from "./CreateTrialDialog";
import trials from "./trials.json";
import TrialsTable from "./TrialsTable";

const Trial = () => {
	const [open, setOpen] = useState(false);

	const clickHandler = () => {
		setOpen(true);
	};

	const closeHandler = () => {
		setOpen(false);
	};

	return (
		<Fragment>
			<Box padding={2} display="flex" justifyContent="space-between">
				<Typography variant="h4" component="p">
					Ongoing Trials -
				</Typography>
				<Button variant="contained" startIcon={<AddIcon />} padding={2} size="small" onClick={clickHandler}>
					Create New Trial
				</Button>
			</Box>
			<Paper>
				<Box padding={2}>
					<TrialsTable data={trials} />
				</Box>
			</Paper>
			<CreateTrialDialog open={open} closeHandler={closeHandler}></CreateTrialDialog>
		</Fragment>
	);
};

export default Trial;
