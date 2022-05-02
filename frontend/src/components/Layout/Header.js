import { Fragment } from "react";
import { Link } from "react-router-dom";

import classes from './Header.module.css';
import LoginButton from "./LoginButton";

const Header = props => {
    return (
    <div>
        <header className={classes.header}>
            <Link to='/'>
                <h1>TrialDex</h1>
            </Link>
            <LoginButton />
        </header>
    </div>
    );
};

export default Header;