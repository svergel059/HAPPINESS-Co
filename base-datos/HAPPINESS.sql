
DROP TABLE Favoritos;
DROP TABLE Imagenes_Galerias;
DROP TABLE galerias;
DROP TABLE eventos;
DROP TABLE usuarios;


CREATE TABLE usuarios (
idUsuario CHAR(10) PRIMARY KEY,
nombre VARCHAR2(50) NOT NULL,
email VARCHAR2(50) NOT NULL UNIQUE, 
contraseña VARCHAR2(15) NOT NULL 
);

CREATE TABLE eventos (
idEvento CHAR(10) PRIMARY KEY,
fecha DATE NOT NULL,
titulo VARCHAR2(40) NOT NULL,
ubicacion VARCHAR2(40) NOT NULL,
descripcion VARCHAR2(50)
);

CREATE TABLE galerias (
idGalerias CHAR(10) PRIMARY KEY,
titulo VARCHAR2(30) NOT NULL,
id_evento CHAR(10) NOT NULL,
CONSTRAINT fk_eventos_galerias FOREIGN KEY (id_evento) REFERENCES eventos (idEvento)
);

CREATE TABLE Imagenes_Galerias (
idImagenes_galeria CHAR(10) PRIMARY KEY,
título VARCHAR2(40),
imagen VARCHAR2(100) NOT NULL,
id_galeria CHAR(10) NOT NULL,
CONSTRAINT fk_galeria_imagen FOREIGN KEY (id_galeria) REFERENCES galerias (idGalerias) 
);

CREATE TABLE Favoritos (
id_usuario CHAR(10) NOT NULL,
id_evento CHAR(10) NOT NULL,
PRIMARY KEY (id_usuario, id_evento),
CONSTRAINT fk_fav_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (idUsuario),
CONSTRAINT fk_fav_evento FOREIGN KEY (id_evento) REFERENCES eventos (idEvento)
);

INSERT INTO Usuarios VALUES (4, 'Ana García', 'ana.garcia@happiness.com', 'pass4ana');
INSERT INTO Usuarios VALUES (5, 'Carlos Ruiz', 'c.ruiz@happiness.com', 'pass5carlos');
INSERT INTO Usuarios VALUES (6, 'Laura Martínez', 'l.martinez@happiness.com', 'pass6laura');
INSERT INTO Usuarios VALUES (7, 'Diego López', 'd.lopez@happiness.com', 'pass7diego');
INSERT INTO Usuarios VALUES (8, 'Elena Sanz', 'e.sanz@happiness.com', 'pass8elena');


INSERT INTO Eventos VALUES (1, TO_DATE('2026-01-01', 'YYYY-MM-DD'), 'Año Nuevo Musical', 'Plaza Central', 'Concierto inicio año');
INSERT INTO Eventos VALUES (2, TO_DATE('2026-01-12', 'YYYY-MM-DD'), 'Teatro Clásico', 'Teatro Real', 'Obra de Shakespeare');
INSERT INTO Eventos VALUES (3, TO_DATE('2026-01-24', 'YYYY-MM-DD'), 'Exposición Arte', 'Museo Local', 'Pintura moderna');
INSERT INTO Eventos VALUES (4, TO_DATE('2026-06-05', 'YYYY-MM-DD'), 'Festival Verano', 'Parque Sur', 'Música al aire libre');
INSERT INTO Eventos VALUES (5, TO_DATE('2026-06-15', 'YYYY-MM-DD'), 'Cine de Verano', 'Playa Grande', 'Proyección nocturna');
INSERT INTO Eventos VALUES (6, TO_DATE('2026-06-25', 'YYYY-MM-DD'), 'Feria Gastronómica', 'Recinto Ferial', 'Comida local');
INSERT INTO Eventos VALUES (7, TO_DATE('2026-04-09', 'YYYY-MM-DD'), 'Cuarteto de flautas dulces', 'Bogotá', 'Música antigua para nuestro tiempo');
INSERT INTO Eventos VALUES (8, TO_DATE('2026-02-02', 'YYYY-MM-DD'), 'Tiempos de curación', 'Leticia', 'Animación pedagógica');
INSERT INTO Eventos VALUES (9, TO_DATE('2026-03-25', 'YYYY-MM-DD'), 'Huellas de diversidad', 'Leticia', 'Talleres con maletas didácticas del Museo del Oro');
INSERT INTO Eventos VALUES (10, TO_DATE('2026-03-26', 'YYYY-MM-DD'), 'Laboratorio artístico', 'Leticia', 'Labor-Arte');

INSERT INTO Galerias (idGalerias, titulo, id_evento) VALUES ('10', 'Galería Año Nuevo', '1');
INSERT INTO Galerias (idGalerias, titulo, id_evento) VALUES ('20', 'Galería Teatro', '2');
INSERT INTO Galerias (idGalerias, titulo, id_evento) VALUES ('30', 'Galería Arte', '3');
INSERT INTO Galerias (idGalerias, titulo, id_evento) VALUES ('70', 'Galería Flautas Dulces', '7');
INSERT INTO Galerias (idGalerias, titulo, id_evento) VALUES ('80', 'Galería Curación', '8');
INSERT INTO Galerias (idGalerias, titulo, id_evento) VALUES ('90', 'Galería Diversidad', '9');
INSERT INTO Galerias (idGalerias, titulo, id_evento) VALUES ('100', 'Galería Labor-Arte', '10');    

INSERT INTO Imagenes_Galerias (idImagenes_galeria, título, imagen, id_galeria) VALUES ('1', 'Foto 1', 'imagen1.jpg', '10');
INSERT INTO Imagenes_Galerias (idImagenes_galeria, título, imagen, id_galeria) VALUES ('2', 'Foto 2', 'imagen2.jpg', '10');
INSERT INTO Imagenes_Galerias (idImagenes_galeria, título, imagen, id_galeria) VALUES ('3', 'Foto 3', 'imagen3.jpg', '10');

/*Imágenes para la Galería (Teatro)*/
INSERT INTO Imagenes_Galerias (idImagenes_galeria, título, imagen, id_galeria) VALUES ('4', 'Escena 1', 'teatro1.jpg', '20');
INSERT INTO Imagenes_Galerias (idImagenes_galeria, título, imagen, id_galeria) VALUES ('5', 'Escena 2', 'teatro2.jpg', '20');
INSERT INTO Imagenes_Galerias (idImagenes_galeria, título, imagen, id_galeria) VALUES ('6', 'Escena 3', 'teatro3.jpg', '20');

/*Imágenes para la Galería (Arte)*/
INSERT INTO Imagenes_Galerias (idImagenes_galeria, título, imagen, id_galeria) VALUES ('7', 'Cuadro 1', 'arte1.jpg', '30');
INSERT INTO Imagenes_Galerias (idImagenes_galeria, título, imagen, id_galeria) VALUES ('8', 'Cuadro 2', 'arte2.jpg', '30');
INSERT INTO Imagenes_Galerias (idImagenes_galeria, título, imagen, id_galeria) VALUES ('9', 'Cuadro 3', 'arte3.jpg', '30');

/*Imágenes para la Galería (Agregados)*/

/*Imágenes para Flautas*/
INSERT INTO Imagenes_Galerias VALUES ('10', 'Concierto Bogotá', 'flautas1.jpg', '70');
INSERT INTO Imagenes_Galerias VALUES ('11', 'Música Antigua', 'flautas2.jpg', '70');

/*Imágenes para Tiempos de Curación*/
INSERT INTO Imagenes_Galerias VALUES ('12', 'Taller Leticia', 'curacion1.jpg', '80');

/*Imágenes para Huellas de Diversidad */
INSERT INTO Imagenes_Galerias VALUES ('13', 'Museo del Oro', 'huellas1.jpg', '90');
INSERT INTO Imagenes_Galerias VALUES ('14', 'Maletas Didácticas', 'huellas2.jpg', '90');

/*Imágenes para Laboratorio Artístico */
INSERT INTO Imagenes_Galerias VALUES ('15', 'Laboratorio 1', 'laboratorio1.jpg', '100');

INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('4', '1');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('5', '2');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('6', '3');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('7', '1');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('8', '2');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('4', '3');
/*favortos nuevos*/
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('4', '7');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('5', '9');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('6', '10');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('7', '8');


/* Usuario 5: Ya tiene (5,2) Le faltan dos (uno historial y uno próximo)*/
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('5', '1');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('5', '6');

/*Usuario 6: Ya tiene (6,3) Le faltan dos*/
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('6', '2');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('6', '5');

/*Usuario 7: Ya tiene (7,1) Le faltan dos*/
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('7', '2');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('7', '4');

/*Usuario 8: Ya tiene (8,2) Le faltan dos*/
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('8', '3');
INSERT INTO Favoritos (id_usuario, id_evento) VALUES ('8', '6');

/*vistas pedidas*/
SELECT *
FROM vista_galerias_antes_febrero;
SELECT *
FROM vista_favoritos_usuario1;
SELECT *
FROM vista_imagenes_evento_2;
SELECT *
FROM vista_favoritos_usuario2;


/*vista de galerias*/
CREATE OR REPLACE VIEW vista_galerias_antes_febrero AS
SELECT galerias.idGalerias, galerias.titulo, eventos.idEvento, eventos.fecha
FROM galerias
JOIN eventos ON galerias.id_evento = eventos.idEvento
WHERE eventos.fecha < TO_DATE('2026-02-28', 'YYYY-MM-DD');

/*vista de favoritos usuario 1*/
CREATE OR REPLACE VIEW vista_favoritos_usuario1 AS
SELECT eventos.idEvento, eventos.fecha, eventos.titulo, eventos.ubicacion, eventos.descripcion
FROM eventos
JOIN favoritos ON eventos.idEvento = favoritos.id_evento
WHERE favoritos.id_usuario = '4';

/*vista de imagenes del evento 12-01-2026*/
CREATE OR REPLACE VIEW vista_imagenes_evento_2 AS
SELECT Imagenes_Galerias.idImagenes_galeria, Imagenes_Galerias.título, Imagenes_Galerias.imagen, Imagenes_Galerias.id_galeria
FROM Imagenes_Galerias
JOIN galerias ON Imagenes_Galerias.id_galeria = galerias.idGalerias
WHERE galerias.id_evento = '2';

/*vista vista favoritos usuario2 28-02-2026*/
CREATE OR REPLACE VIEW vista_favoritos_usuario2 AS
SELECT eventos.idEvento, eventos.fecha, eventos.titulo, eventos.ubicacion, eventos.descripcion
FROM eventos
JOIN favoritos ON eventos.idEvento = favoritos.id_evento
WHERE favoritos.id_usuario = '5'
AND eventos.fecha > TO_DATE('2026-02-28', 'YYYY-MM-DD');


