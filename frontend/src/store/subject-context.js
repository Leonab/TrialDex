import * as React from 'react';

const SubjectContext = React.createContext({
    subjects: [],
    addSubject: (subject) => {},
    removeSubject: (id) => {}
});

export default SubjectContext;