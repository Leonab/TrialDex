import { AdapterDateFns } from "@mui/x-date-pickers/AdapterDateFns";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { Route, Routes } from "react-router-dom";
import "./App.css";
import DefaultLayout from "./components/Layout/DefaultLayout";
import Trial from "./components/Trials/Trials";
import TrialDetails from "./components/Trials/TrialDetails";

function App() {
	return (
		<LocalizationProvider dateAdapter={AdapterDateFns}>
			<DefaultLayout>
				<Routes>
					<Route path="trials">
						<Route index={true} element={<Trial />} />
						<Route path=":id" element={<TrialDetails />} />
					</Route>
					<Route path="*" element={<Trial />} />
				</Routes>
			</DefaultLayout>
		</LocalizationProvider>
	);
}

export default App;
