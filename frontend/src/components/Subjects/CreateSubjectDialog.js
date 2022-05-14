import { useState } from 'react';
import { Dialog, DialogTitle, DialogContent, DialogContentText, TextField, DialogActions, Button} from '@mui/material';

const CreateSubjectDialog = (props) => {
    const diaglogOpen = props.open;

    const closeHandler = () => {
        props.closeHandler();
    };

    return (
        <Dialog open={diaglogOpen} onClose={closeHandler}>
            <DialogTitle>Create a new Subject</DialogTitle>
            <DialogContent>
                <DialogContentText>
                    Please fill in all the required fields - 
                </DialogContentText>
                <TextField
                    autoFocus
                    margin="dense"
                    id="name"
                    label="Full name"
                    type="name"
                    fullWidth
                    variant="standard"
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={closeHandler}>Cancel</Button>
                <Button onClick={closeHandler}>Save</Button>
            </DialogActions>
        </Dialog>
    );
};

export default CreateSubjectDialog;