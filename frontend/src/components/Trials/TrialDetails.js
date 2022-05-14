import { Box, Button, Paper, Typography } from "@mui/material";
import { Fragment, useState } from "react";
import { useParams } from "react-router-dom";
import subjects from "../Subjects/subjects.json";
import SubjectsTable from "../Subjects/SubjectsTable";
import TrialExpanded from "./TrialExpanded";
import AddIcon from '@mui/icons-material/Add';
import CreateSubjectDialog from "../Subjects/CreateSubjectDialog";

const TrialDetails = (props) => {
    const params = useParams();
    const [open, setOpen] = useState(false);

    const clickHandler = () => {
        setOpen(true);
    };

    const closeHandler = () => {
        setOpen(false);
    };

    console.log(params);

    const trial = {
        id: params.id,
        name: 'Name hulula ' + params.id,
        description: 'Best desc ever',
        noOfGroups: 3
    };

    return (
        <Fragment>
            <TrialExpanded trial={trial} />
            <Paper>
                <Box padding={2} display="flex" justifyContent="space-between">
                    <Typography variant="h4" component="p" >Subjects: </Typography>
                    <Button variant="contained" startIcon={<AddIcon />} padding={2} size="small" onClick={clickHandler}>Add New Subjects</Button>
                </Box>
                <Box padding={1}>
                    <SubjectsTable data={subjects} />
                </Box>
            </Paper>
            <CreateSubjectDialog open={open} closeHandler={closeHandler}></CreateSubjectDialog>
        </Fragment>
    );
};

export default TrialDetails;