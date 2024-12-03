import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "./App.css"; 

function Tabla({ personas, setPersonas }) {
  const handleDelete = async (id, cargo) => {
    try {
      const endpoint =
        cargo === "Estudiante"
          ? `http://localhost:8080/api/alumnos/${id}`
          : `http://localhost:8080/api/profesores/${id}`;

      await axios.delete(endpoint);
      alert(`${cargo} eliminado exitosamente.`);
      setPersonas(personas.filter((persona) => persona.id !== id));
    } catch (error) {
      console.error(`Error al eliminar el ${cargo.toLowerCase()}:`, error);
      alert(`Hubo un error al eliminar el ${cargo.toLowerCase()}.`);
    }
  };

  return (
    <div className="App">
      {/* Contenedor principal */}
      <div className="main-content">
        <div className="table-container">
          <h2>Lista de Personas Registradas</h2>
          <table className="centered-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Identificación</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th>Dirección</th>
                <th>Cargo</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              {personas.map((persona) => (
                <tr key={persona.id}>
                  <td>{persona.id}</td>
                  <td>{persona.nombreCompleto}</td>
                  <td>{persona.identificacion}</td>
                  <td>{persona.email}</td>
                  <td>{persona.telefono}</td>
                  <td>{persona.direccion}</td>
                  <td>{persona.cargo}</td>
                  <td>
                    <button onClick={() => handleDelete(persona.id, persona.cargo)}>
                      Eliminar
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <Link to="/">
            <button>Volver al Formulario</button>
          </Link>
        </div>
      </div>

      {/* Footer */}
      <footer className="footer">
        <p>Correo electrónico: Registrouniversidad@gmail.com - Teléfono: 123456789</p>
        <p>Carrera 9 #21-02 Centro - Pereira - Risaralda - Colombia</p>
        <p>
          Síguenos en nuestras redes sociales: 
          <a href="https://facebook.com" target="_blank" rel="noopener noreferrer"> Facebook</a> | 
          <a href="https://twitter.com" target="_blank" rel="noopener noreferrer"> Twitter</a>
        </p>
      </footer>
    </div>
  );
}

export default Tabla;
