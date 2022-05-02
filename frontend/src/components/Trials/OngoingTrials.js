import Card from '../UI/Card';
import classes from './OngoingTrials.module.css';
import TrialPreview from './TrialPreview'

const OngoingTrials = (props) => {

    const trials = [
        {
            id: 123,
            name: 'Trial Pilot',
            description: 'This is the best desc ever',
            createDate: '01/05/2022',
            updateDate: '01/05/2022',
        },
        {
            id: 567,
            name: 'Trial 2',
            description: 'jfalsdjflaskjdflasjdk',
            createDate: '11/08/2022',
            updateDate: '11/08/2022',
        }
    ];

    const trialList = trials.map((t) => <TrialPreview key={t.id} trial={t} />);

    return (
        <section className={classes.trials}>
            <h1>Ongoing Trials - #</h1>
            <Card>
            <ul>
                {trialList}
            </ul>
            </Card>
        </section>
    );
};

export default OngoingTrials;