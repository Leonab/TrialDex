import { Box, Slider, TextField, Typography } from "@mui/material";
import { useFormik } from "formik";
import { forwardRef, useImperativeHandle } from "react";
import * as yup from "yup";

const CreateTrialForm = forwardRef((props, ref) => {
	const validationSchema = yup.object({
		name: yup.string("Enter first name").required("Required"),
	});

	useImperativeHandle(ref, () => ({
		onClickSave() {
			formik.handleSubmit();
		},
	}));

	const formik = useFormik({
		initialValues: {
			name: "",
			description: "",
			subjectcount: 20,
			groupcount: 2,
		},
		validationSchema: validationSchema,
		onSubmit: (values) => {
			console.log(values);
		},
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
				fullWidth
				id="name"
				name="name"
				label="Name"
				value={formik.values.name}
				onChange={formik.handleChange}
				onBlur={formik.handleBlur}
				error={formik.touched.name && Boolean(formik.errors.name)}
				helperText={formik.touched.name && formik.errors.name}
			/>
			<TextField
				multiline
				fullWidth
				id="description"
				name="description"
				label="Description"
				value={formik.values.description}
				onChange={formik.handleChange}
				error={formik.touched.description && Boolean(formik.errors.description)}
				helperText={formik.touched.description && formik.errors.description}
			/>
			<Box padding={1}>
				<Typography id="input-slider-subjects" gutterBottom>
					No. of Subjects
				</Typography>
				<Slider
					id="subjectcount"
					name="subjectcount"
					value={formik.values.subjectcount}
					onChange={formik.handleChange}
					aria-labelledby="input-slider-subjects"
					defaultValue={2}
					valueLabelDisplay="auto"
					step={1}
					// marks
					min={1}
					max={200}
				/>
			</Box>
			<Box padding={1}>
				<Typography id="input-slider-group" gutterBottom>
					No. of Groups
				</Typography>
				<Slider
					id="groupcount"
					name="groupcount"
					value={formik.values.groupcount}
					onChange={formik.handleChange}
					aria-labelledby="input-slider-group"
					defaultValue={2}
					valueLabelDisplay="auto"
					step={1}
					marks
					min={2}
					max={4}
				/>
			</Box>
		</Box>
	);
});

export default CreateTrialForm;
