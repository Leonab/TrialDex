import classes from './LoginButton.module.css'

const LoginButton = props => {
    return (
        <button className={classes.button}>
            <span>Login</span>
        </button>
    );
};

export default LoginButton;