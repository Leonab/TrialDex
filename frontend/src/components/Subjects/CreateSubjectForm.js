import { useRef, useState } from 'react';
// import Input from '../UI/Input';
import classes from './CreateSubjectForm.module.css';

const CreateSubjectForm = props => {
    const firtNameRef = useRef();
    const [isFormValid, setIsFormValid] = useState(true);

    const submitHandler = event => {
    
        event.preventDefault();
        const enteredName = firtNameRef.current.value;
        if(enteredName.trim().length === 0) {
            setIsFormValid(false);
            return;
        }

        props.addSubjectToContext(enteredName); //should actually be form object
    };

    return (
        <form className={classes} onSubmit={submitHandler}>
            {/* <Input 
                label='FirtName'
                ref={firtNameRef}
                input={{
                    
                    type: 'input'
                }}
                
            /> */}
            <button>Create</button>
            {!isFormValid && <p>Please enter valid fields</p>}
        </form>
    );
};

export default CreateSubjectForm;