import { createContext, useEffect, useState } from "react";

const AuthContext = createContext({});

const initialAuth = {
	access_token: "",
	username: "",
	userId: "",
};

const AuthProvider = (props) => {
	const [auth, setAuth] = useState(initialAuth);

	const getAuthState = () => {
		try {
			const authData = localStorage.getItem("access_token");

			setAuth(authData);
		} catch (err) {
			setAuth({});
		}
	};

	const setAuthState = (token) => {
		try {
			localStorage.setItem("access_token", token);
			setAuth(token);
		} catch (err) {
			Promise.reject(err);
		}
	};

	useEffect(() => {
		getAuthState();
	}, []);

	return <AuthContext.Provider value={{ auth, setAuth }}>{props.children}</AuthContext.Provider>;
};

export { AuthContext, AuthProvider };
