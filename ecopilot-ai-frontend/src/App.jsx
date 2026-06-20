import { Routes, Route } from "react-router-dom";

import Home from "./pages/Home";
import Questionnaire from "./pages/Questionnaire";
import Dashboard from "./pages/Dashboard";
import History from "./pages/History";
import Profile from "./pages/Profile";

import "./App.css";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/questionnaire" element={<Questionnaire />} />
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/history" element={<History />} />
      <Route path="/profile" element={<Profile />} />
    </Routes>
  );
}

export default App;