import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Formulario from "./formulario";
import Tabla from "./Tabla";

function App() {
  const [personas, setPersonas] = useState([]);

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route
            path="/"
            element={<Formulario personas={personas} setPersonas={setPersonas} />}
          />
          <Route
            path="/tabla"
            element={<Tabla personas={personas} setPersonas={setPersonas} />}
          />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
