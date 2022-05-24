import AddIcon from "@mui/icons-material/Add";
import { Box, Button, Paper, Typography } from "@mui/material";
import { Fragment, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import CreateSubjectDialog from "../Subjects/CreateSubjectDialog";
import SubjectsTable from "../Subjects/SubjectsTable";
import TrialExpanded from "./TrialExpanded";

const TrialDetails = (props) => {
	const params = useParams();
	const [open, setOpen] = useState(false);
	const [isloaded, setIsLoaded] = useState(false);
	const [subjects, setSubjects] = useState([]);
	const [error, setError] = useState(null);

	useEffect(() => {
		fetch(`/api/v1/subject?trialId=${params.id}`)
			.then((res) => res.json())
			.then(
				(result) => {
					setIsLoaded(true);
					setSubjects(result);
				},
				(error) => {
					setIsLoaded(true);
					setError(error);
				}
			);
	}, []);

	const clickHandler = () => {
		setOpen(true);
        
	};

	const closeHandler = () => {
		setOpen(false);
	};

	const trial = {
		id: params.id,
		name: "Name hulula",
		description: "Best desc ever",
		noOfGroups: 3,
	};

	return (
		<Fragment>
			<TrialExpanded trial={trial} />
			<Paper>
				<Box padding={2} display="flex" justifyContent="space-between">
					<Typography variant="h4" component="p">
						Subjects:{" "}
					</Typography>
					<Button variant="contained" startIcon={<AddIcon />} padding={2} size="small" onClick={clickHandler}>
						Add New Subjects
					</Button>
				</Box>
				<Box padding={1}>
					<SubjectsTable data={subjects} />
				</Box>
			</Paper>
			<CreateSubjectDialog open={open} closeHandler={closeHandler} id={params.id}></CreateSubjectDialog>
		</Fragment>
	);
};

export default TrialDetails;
