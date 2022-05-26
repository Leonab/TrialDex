import { useContext } from "react";
import { Navigate, Route, useLocation } from "react-router-dom";
import { AuthContext } from "../../store/AuthContext";

const RequireAuth = (props) => {
	let auth = useContext(AuthContext);
	let location = useLocation();

	const isAuthenticated = auth.username ?? false;

	if (!isAuthenticated) {
		return <Navigate to="/login" state={{ from: location }} replace />;
	}

	return props.children;
};

export default RequireAuth;
