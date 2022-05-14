import './App.css';
import TrialDetails from './components/Trials/TrialDetails';
import Trial from './components/Trials/Trials';
import { Route, Routes } from 'react-router-dom';
import Card from './components/UI/Card';
import DefaultLayout from './components/Layout/DefaultLayout';

function App() {
  return (
    <DefaultLayout>
      <Routes>
        <Route path='trials'>
          <Route index={true} element={<Trial />} />
          <Route path=':id' element={<TrialDetails />} />
        </Route>
        <Route path='*' element={<Card />} />
      </Routes>
    </DefaultLayout>
  );
}

export default App;