import { useState } from 'react';
import OngoingTrials from "./OngoingTrials";

const Trial = () => {
    const [createModalShown, setCreateModalShown] = useState(false);

    const showCreateModalHandler = () => {
        setCreateModalShown(true);
    };

    const hideCreateModalHandler = () => {
        setCreateModalShown(false);
    };
    return (
            <OngoingTrials />
    );
};

export default Trial;