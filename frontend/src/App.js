import { AdapterDateFns } from "@mui/x-date-pickers/AdapterDateFns";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { Route, Routes } from "react-router-dom";
import "./App.css";
import Trial from "./components/Trials/Trials";
import TrialDetails from "./components/Trials/TrialDetails";
import DefaultLayout from "./components/Common/DefaultLayout";
import { AuthProvider } from "./store/AuthContext";
import RequireAuth from "./components/Common/RequireAuth";
import Login from "./components/Common/Login";

function App() {
	return (
		<LocalizationProvider dateAdapter={AdapterDateFns}>
			<AuthProvider>
				<DefaultLayout>
					<Routes>
						<Route path="trials">
							<Route
								index={true}
								element={
									<RequireAuth>
										<Trial />
									</RequireAuth>
								}
							/>
							<Route
								path=":id"
								element={
									<RequireAuth>
										<TrialDetails />
									</RequireAuth>
								}
							/>
						</Route>
						<Route path="login" element={<Login />} />
						<Route path="*" element={<p>Not Found</p>} />
					</Routes>
				</DefaultLayout>
			</AuthProvider>
		</LocalizationProvider>
	);
}

export default App;
