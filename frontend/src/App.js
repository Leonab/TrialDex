import './App.css';
import TrialDetails from './components/Trials/TrialDetails';
import Trial from './components/Trials/Trials';
import { Route, Routes } from 'react-router-dom';
import Card from './components/UI/Card';
import Layout from './components/Layout/Layout';

function App() {
  return (
    <Layout>
      <Routes>
        <Route path='trials'>
          <Route index={true} element={<Trial />} />
          <Route path=':id' element={<TrialDetails />} />
        </Route>
          <Route path='*' element={<Card />} />
      </Routes>
    </Layout>
  );
}

export default App;
