import React, { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "./App.css";

function Formulario({ personas, setPersonas }) {
  const [formData, setFormData] = useState({
    nombre: "",
    identificacion: "",
    telefono: "",
    correo: "",
    direccion: "",
    genero: "",
    cargo: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    let dataToSend;

    if (formData.cargo === "Estudiante") {
      dataToSend = {
        nombreCompleto: formData.nombre,
        identificacion: formData.identificacion,
        telefono: formData.telefono,
        email: formData.correo,
        direccion: formData.direccion,
        genero: formData.genero,
        numeroMatricula: "MAT12345",
        programa: "Ingeniería de Sistemas",
        notaPromedio: 4.5,
        cargo: "Estudiante",
      };
    } else if (formData.cargo === "Profesor") {
      dataToSend = {
        nombreCompleto: formData.nombre,
        identificacion: formData.identificacion,
        telefono: formData.telefono,
        email: formData.correo,
        direccion: formData.direccion,
        genero: formData.genero,
        salario: 1300000.0,
        dependencia: "Ingenieria",
        materia: "Sistemas",
        cargo: "Profesor",
      };
    } else {
      alert("Por favor selecciona un cargo válido.");
      return;
    }

    try {
      const endpoint =
        formData.cargo === "Estudiante"
          ? "http://localhost:8080/api/alumnos"
          : "http://localhost:8080/api/profesores";

      const response = await axios.post(endpoint, dataToSend, {
        headers: {
          "Content-Type": "application/json",
        },
      });

      alert(`${formData.cargo} registrado exitosamente.`);

      setPersonas([
        ...personas,
        { ...dataToSend, id: response.data.id },
      ]);

      setFormData({
        nombre: "",
        identificacion: "",
        telefono: "",
        correo: "",
        direccion: "",
        genero: "",
        cargo: "",
      });
    } catch (error) {
      console.error(`Error al registrar el ${formData.cargo.toLowerCase()}:`, error);
      alert(`Hubo un error al registrar el ${formData.cargo.toLowerCase()}.`);
    }
  };

  return (
    <div className="App">
      {/* Header */}
      <header className="header">
        <h1>Formulario de Registro</h1>
        <img
          src={`${process.env.PUBLIC_URL}/cuestionario.jpg`}
          alt="Logo"
          className="header-logo"
        />
      </header>

      {/* Formulario */}
      <div className="form-container">
        <form onSubmit={handleSubmit}>
          <label>Nombre:</label>
          <input type="text" name="nombre" value={formData.nombre} onChange={handleChange} required />

          <label>Identificación:</label>
          <input type="text" name="identificacion" value={formData.identificacion} onChange={handleChange} required />

          <label>Teléfono:</label>
          <input type="text" name="telefono" value={formData.telefono} onChange={handleChange} required />

          <label>Correo Electrónico:</label>
          <input type="email" name="correo" value={formData.correo} onChange={handleChange} required />

          <label>Dirección:</label>
          <input type="text" name="direccion" value={formData.direccion} onChange={handleChange} required />

          <label>Género:</label>
          <select name="genero" value={formData.genero} onChange={handleChange} required>
            <option value="">--Selecciona--</option>
            <option value="Masculino">Masculino</option>
            <option value="Femenino">Femenino</option>
            <option value="Otro">Otro</option>
          </select>

          <label>Cargo:</label>
          <select name="cargo" value={formData.cargo} onChange={handleChange} required>
            <option value="">--Selecciona--</option>
            <option value="Profesor">Profesor</option>
            <option value="Estudiante">Estudiante</option>
          </select>

          <div className="button-group">
            <button type="submit">Enviar</button>
            <Link to="/tabla">
              <button type="button" className="secondary-button">Ir a la Tabla</button>
            </Link>
          </div>
        </form>
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

export default Formulario;
