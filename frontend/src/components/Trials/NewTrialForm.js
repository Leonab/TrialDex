import { ErrorMessage, Field, Form, Formik, useFormik, yupToFormErrors } from "formik";
import * as Yup from 'yup';

const NewTrialForm = (props) => {
    return (
    <Formik
        initialValues={{
            name: '',
            description: '',
            numberOfGroups: 0
        }}
        validationSchema={Yup.object({
            name: Yup.string()
                .required('Required'),
            numberOfGroups: Yup.string()
                .min(1, 'Must be at least 1')
                .max(4, 'Must be less than or equal to 4')
                .required('Required')
        })}
        onSubmit={(values, {setSubmitting}) => {
            console.log(values);
        }}
    >
        <Form>
            <label htmlFor="name">Name: </label>
            <Field name="name" type="text" />
            <ErrorMessage name="name" />

            <label htmlFor="description">Description: </label>
            <Field name="description" as="textarea" />
            <ErrorMessage name="description" />

            <label htmlFor="numberOfGroups">Number of groups to distribute subjects: </label>
            <Field name="numberOfGroups" type="number" />
            <ErrorMessage name="numberOfGroups" />

            <button type="submit">Submit</button>
        </Form>
    </Formik>
    );
};

export default NewTrialForm;