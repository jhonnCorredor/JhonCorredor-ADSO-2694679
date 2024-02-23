
CREATE DATABASE sistema_notas;

USE sistema_notas;

CREATE TABLE estudiantes(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombre VARCHAR(40) NOT NULL,
edad VARCHAR(40) NOT NULL,
documento VARCHAR(40) NOT NULL,
telefono VARCHAR(40) NOT NULL,
correo VARCHAR(40) NOT NULL,
deleted_at DATETIME,	
updated_at DATETIME,
created_at DATETIME
);

CREATE TABLE materia(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
descripcion VARCHAR(40) NOT NULL,
Aula VARCHAR(40) NOT NULL,
horas_duracion VARCHAR(40),
deleted_at DATETIME,	
updated_at DATETIME,
created_at DATETIME
);

CREATE TABLE matricula(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
codigo VARCHAR(40) NOT NULL,
estudiante_id INT,
materia_id INT,
nota INT,
deleted_at DATETIME,	
updated_at DATETIME,
created_at DATETIME,
FOREIGN key (estudiante_id) REFERENCES estudiantes(id),
FOREIGN key (materia_id) REFERENCES materia(id)
);