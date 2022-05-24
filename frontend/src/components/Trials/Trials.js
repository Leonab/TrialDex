import AddIcon from "@mui/icons-material/Add";
import { Box, Button, CircularProgress, Paper, Typography } from "@mui/material";
import { Fragment, useEffect, useState } from "react";
import CreateTrialDialog from "./CreateTrialDialog";
import TrialsTable from "./TrialsTable";

const Trial = () => {
	const [open, setOpen] = useState(false);
	const [isloaded, setIsLoaded] = useState(false);
	const [trials, setTrials] = useState([]);
	const [error, setError] = useState(null);

	const getTrialData = () => {
		fetch("/api/v1/trial?ownerId=1")
		.then(res => res.json())
		.then(
			(result) => {
				setIsLoaded(true);
				setTrials(result);
			},
			(error) => {
				setIsLoaded(true);
				setError(error);
			}
		)
	};

	useEffect(() => {
		getTrialData();
	}, []);

	const createTrialClickHandler = () => {
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
				<Button variant="contained" startIcon={<AddIcon />} padding={2} size="small" onClick={createTrialClickHandler}>
					Create New Trial
				</Button>
			</Box>
			<Paper>
				<Box padding={2}>
					{error && <Typography variant="div">Error: {error.message}</Typography>}
					{!isloaded && <CircularProgress />}
					{isloaded && <TrialsTable data={trials} />}
				</Box>
			</Paper>
			<CreateTrialDialog open={open} closeHandler={closeHandler}></CreateTrialDialog>
		</Fragment>
	);
};

export default Trial;
