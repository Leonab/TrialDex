import { Box, MenuItem, TextField } from "@mui/material";
import { DatePicker } from "@mui/x-date-pickers";
import { useFormik } from "formik";
import { forwardRef, useImperativeHandle } from "react";
import * as yup from "yup";
import postData from "../../services/http-service";

const CreateSubjectForm = forwardRef((props, ref) => {
	const validationSchema = yup.object({
		firstname: yup.string("Enter first name").required("Required"),
		dob: yup.date().required("Required").typeError("Enter valid date"),
		orientation: yup.string("Select orientation").required("Required"),
	});

	useImperativeHandle(ref, () => ({
		onClickSave() {
			formik.handleSubmit();
		},
	}));

	const formik = useFormik({
		initialValues: {
			firstname: "",
			lastname: "",
			dob: null,
			orientation: "",
			hospitalId: "",
		},
		validationSchema: validationSchema,
		onSubmit: (values) => {
			postData(`http://localhost:8080/api/v1/subject?trialId=${props.id}`, values);
		}
	});

	return (
		<Box
			component="form"
			sx={{
				"& .MuiTextField-root": { m: 1 },
			}}
			autoComplete="off"
			onSubmit={formik.handleSubmit}
		>
			<TextField
				id="firstname"
				name="firstname"
				label="Firstname"
				value={formik.values.firstname}
				onChange={formik.handleChange}
				onBlur={formik.handleBlur}
				error={formik.touched.firstname && Boolean(formik.errors.firstname)}
				helperText={formik.touched.firstname && formik.errors.firstname}
			/>
			<TextField
				id="lastname"
				name="lastname"
				label="Lastname"
				value={formik.values.lastname}
				onChange={formik.handleChange}
				error={formik.touched.lastname && Boolean(formik.errors.lastname)}
				helperText={formik.touched.lastname && formik.errors.lastname}
			/>
			<DatePicker
				disableFuture
				id="dob"
				name="dob"
				label="Date of Birth"
				value={formik.values.dob}
				onChange={(val) => {
					formik.setFieldValue("dob", val, true);
				}}
				onError={(reason, val) => {
					formik.setFieldError("dob", true, true);
				}}
				renderInput={(params) => (
					<TextField
						id="dob"
						name="dob"
						onBlur={() => {
							formik.setFieldTouched("dob", true, true);
						}}
						onError={(reason, val) => {
							console.log(reason);
						}}
						// error={formik.touched.dob && Boolean(formik.errors.dob)}
						error
						helperText={formik.touched.dob && formik.errors.dob}
						{...params}
					/>
				)}
			/>
			<TextField
				select
				fullWidth
				id="orientation"
				name="orientation"
				value={formik.values.orientation}
				label="Orientation"
				onChange={formik.handleChange}
				onBlur={formik.handleBlur}
				error={formik.touched.orientation && Boolean(formik.errors.orientation)}
				helperText={formik.touched.orientation && formik.errors.orientation}
			>
				<MenuItem value="Male">Male</MenuItem>
				<MenuItem value="Female">Female</MenuItem>
				<MenuItem value="Other">Other</MenuItem>
			</TextField>
			<TextField
				fullWidth
				id="hospitalId"
				name="hospitalId"
				label="Hospital Id"
				value={formik.values.hospitalId}
				onChange={formik.handleChange}
				error={formik.touched.hospitalId && Boolean(formik.errors.hospitalId)}
				helperText={formik.touched.hospitalId && formik.errors.hospitalId}
			/>
		</Box>
	);
});

export default CreateSubjectForm;
