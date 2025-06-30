CREATE TABLE res_asignatura_prerrequisito 
(
	id INT AUTO_INCREMENT PRIMARY KEY,
    asignatura_codigo  INT NOT NULL,
    prerrequisito_codigo INT NOT NULL,
    CONSTRAINT fk_materia FOREIGN KEY (asignatura_codigo)
        REFERENCES res_asignatura(codigo),
    CONSTRAINT fk_prerequisito FOREIGN KEY (prerrequisito_codigo)
        REFERENCES res_asignatura(codigo)
);


CREATE TABLE carrera 
(
	id INT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL
);


CREATE TABLE campo_formacion 
(
	id INT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    color_html VARCHAR(50) NOT NULL,
    cantidad_asignaturas INT
);

CREATE TABLE area_formacion 
(
	id INT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    color_html VARCHAR(50) NOT NULL,
	cantidad_asignaturas INT
);