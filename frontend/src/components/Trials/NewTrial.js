import Modal from '../UI/Modal';
import classes from './NewTrial.module.css';
import NewTrialForm from './NewTrialForm';

 const NewTrial = props => {
    return <Modal onClose={props.onCloseModal}>
        {/* <span>Enter details for the Trial</span>
        <div>Enter Name</div>
        <div className={classes.total}>Enter description</div>
        <div>Enter numberOfGroups</div>
        <div className={classes.actions}>
            <button className={classes['button--alt']} onClick={props.onCloseModal}>Close</button>
            <button className={classes.button}>Create</button>
        </div> */}
        <NewTrialForm />
    </Modal>
 };

 export default NewTrial;