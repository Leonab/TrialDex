import { Typography } from "@mui/material";

const TrialExpanded = (props) => {
    const trial = props.trial;

    return (
        <div>
            <Typography variant="h2">Trial - {trial.id}</Typography>
            <Typography variant="h4">{trial.name}</Typography>

            <Typography variant="p">Description: {trial.description}</Typography>
            <Typography variant="subtitle2" mb={2}>No of Groups: {trial.noOfGroups}</Typography>

        </div>
    );
};

export default TrialExpanded;