import { useContext, useState } from "react";
import { Outlet, useParams } from "react-router-dom";
import SubjectContext from "../../store/subject-context";
import CreateSubjectForm from "../Subjects/CreateSubjectForm";

const TrialDetails = (props) => {
    const params = useParams();
    console.log(params);
    return (
        <div>
        <h1>Trial Details - {params.id}</h1>
        </div>
    );
};

export default TrialDetails;