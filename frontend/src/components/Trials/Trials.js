import CreateSubjectForm from "../Subjects/CreateSubjectForm";
import OngoingTrials from "./OngoingTrials";
import classes from './Trials.module.css';
import NewTrial from "./NewTrial";
import { Fragment, useState  } from 'react';
import { Outlet } from "react-router-dom";

const Trial = () => {
    const [createModalShown, setCreateModalShown] = useState(false);

    const showCreateModalHandler = () => {
        setCreateModalShown(true);
    };

    const hideCreateModalHandler = () => {
        setCreateModalShown(false);
    };
    return (
        <Fragment>
            <h2>This is your landing page</h2>
            <button onClick={showCreateModalHandler}>Create new Trial+</button>
            {createModalShown && <NewTrial onCloseModal={hideCreateModalHandler}/>}
            <OngoingTrials />
            <Outlet />
            {/* <CreateSubjectForm></CreateSubjectForm> */}
        </Fragment>
    );
};

export default Trial;