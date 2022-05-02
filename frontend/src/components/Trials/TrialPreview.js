import { Link } from 'react-router-dom';
import classes from './TrialPreview.module.css'

const TrialPreview = (props) => {
    const trial = props.trial;
    const revealGroupHandler = (event) => {
        console.log("Reveal group clicked", event);
    };

    return ( 
        <li key={trial.id}>
            <div className={classes.trialPreview}>
                <h3>{trial.name}</h3>
                <div className={classes.description}>{trial.description}</div>
                <div className={classes.date}>{trial.createDate}</div>
                <div className={classes.date}>{trial.updateDate}</div>
                <div>
                    <Link to={`/trials/${trial.id}`}>
                    <button className='button' onClick={revealGroupHandler}>Open</button>
                    </Link>
                </div>
            </div>
        </li>
    );
};

export default TrialPreview;