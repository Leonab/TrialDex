import { ErrorMessage, Field, Form, Formik, FormikProps } from "formik";
import * as Yup from 'yup';
import Input from "../UI/Input";
import classes from './NewTrialForm.module.css';

const NewTrialForm = (props) => {
    return (
    <Formik
        initialValues={{
            name: '',
            description: '',
            numberOfGroups: ''
        }}
        validationSchema={Yup.object({
            name: Yup.string()
                .required('Required'),
            numberOfGroups: Yup.number()
                .min(1, 'Must be at least 1')
                .max(4, 'Must be less than or equal to 4')
                .required('Required')
        })}
        onSubmit={(values, { setSubmitting }) => {
            console.log(values);
        }}
    >
        <Form className={classes.form}>
                <Input name="name" type="text" label="Name: " />

            <div className={classes.control}>
                <label htmlFor="description">Description: </label>
                <Field name="description" as="textarea" />
                <ErrorMessage name="description" />
            </div>

            <div className={classes.control}>
                <label htmlFor="numberOfGroups">Number of groups to distribute subjects: </label>
                <Field name="numberOfGroups" type="number" />
                <ErrorMessage name="numberOfGroups" component="div" className={classes.invalid} />
            </div>

            <div className={classes.actions}>
                <button type='button' onClick={props.onCancel}>Cancel</button>
                <button type="submit">Submit</button>
            </div>
        </Form>
    </Formik>
    );
};

export default NewTrialForm;