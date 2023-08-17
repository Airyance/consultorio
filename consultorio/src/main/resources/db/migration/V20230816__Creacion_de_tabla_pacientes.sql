CREATE TABLE pacientes (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    direccion VARCHAR(255),
    fecha_nacimiento DATE,
    identificacion BIGINT,
    telefono BIGINT
);