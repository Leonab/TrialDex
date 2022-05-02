import classes from './Card.module.css';

const Card = props => {
    return (
        <div className={classes.card}>
            <h1>Hi from card</h1>
            {props.children}
        </div>
    );
};

export default Card;