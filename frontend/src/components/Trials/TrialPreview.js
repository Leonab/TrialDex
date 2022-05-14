import { Button, Divider, ListItem, ListItemText } from '@mui/material';
import { Fragment } from 'react';
import { Link } from 'react-router-dom';

const TrialPreview = (props) => {
    const trial = props.trial;
    const revealGroupHandler = (event) => {
        console.log("Reveal group clicked", event);
    };

    return ( 
        <Fragment>
            <ListItem
                secondaryAction={
                    <Button to={`${trial.id}`} component={Link} variant="contained" edge='end'>
                        Open
                    </Button>
                }
            >
                <ListItemText
                    primary={trial.name}
                    secondary={trial.description}
                />
            </ListItem>
            <Divider />
        </Fragment>
    );
};

export default TrialPreview;