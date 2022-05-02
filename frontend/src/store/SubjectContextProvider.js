import { useReducer } from "react";
import SubjectContext from "./subject-context";

const defaultSubjectState = {
    subjects: []
};

const subjectReducer = (state, action) => {
    if(action.type === 'ADD') {
        const updatedSubjects = state.subjects.concat(action.subject);
        return {
            subjects: updatedSubjects
        }
    }
    else if(action.type === 'REMOVE') {

    }
    return defaultSubjectState;    
};

const SubjectContextProvider = props => {
    const [subjectState, dispatchSubjectAction] = useReducer(subjectReducer, defaultSubjectState);

    const addSubjectToContextHandler = subject => {
        dispatchSubjectAction({type: 'ADD', subject: subject});
    };

    const removeSubjectFromContextHandler = id => {
        dispatchSubjectAction({type: 'REMOVE', id: id});
    };

    const subjectContext = {
        subjects: subjectState.subjects,
        addSubject: addSubjectToContextHandler,
        removeSubject: removeSubjectFromContextHandler
    };

    return <SubjectContext.Provider value={subjectContext}>
        {props.children}
    </SubjectContext.Provider>
};

export default SubjectContextProvider;