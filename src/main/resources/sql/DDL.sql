CREATE TABLE res_asignatura_prerequisito 
(
	id INT PRIMARY KEY,
    materia INT NOT NULL,
    prerequisito INT NOT NULL,
    CONSTRAINT fk_materia FOREIGN KEY (materia)
        REFERENCES res_asignatura(codigo),
    CONSTRAINT fk_prerequisito FOREIGN KEY (prerequisito)
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
    color_html VARCHAR(50) NOT NULL
);

CREATE TABLE area_formacion 
(
	id INT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    color_html VARCHAR(50) NOT NULL
);