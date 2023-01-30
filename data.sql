CREATE TABLE USUARIO (
    id int(11) AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    apellido varchar(50) NOT NULL,
    contrasena varchar(50) NOT NULL,
    imagen varchar(100),
    descripcion varchar(100),
    direccion varchar(100),
    cp INT(5),
    municipio varchar(100),
    provincia varchar(50),
    pais varchar(100),
    telefono int(9),
    email varchar(100),
    validado int(1),
    strValidado varchar(100),
    CONSTRAINT PK_USUARIO PRIMARY KEY (id)
);
INSERT INTO USUARIO (nombre, apellido, contrasena, imagen, descripcion, direccion, cp, municipio, provincia, pais, telefono, email, validado, strValidado) VALUES ('admin', 'Super', 'admin', null, 'Cuenta Super Admin', 'Calle 12/Bermuda', '01010', 'Alaba', 'Vitoria', 'España', '693482193', 'admin@gmail.com', '1', 'ADAX90Cnjshd5!S');
INSERT INTO USUARIO (nombre, apellido, contrasena, imagen, descripcion, direccion, cp, municipio, provincia, pais, telefono, email, validado, strValidado) VALUES ('juan', 'Gutierrez', 'juan', null, 'Cuenta Juan Gutierrez', 'Calle 9/Nantes', '01010', 'Alaba', 'Vitoria', 'España', '64759312', 'juangutierrez@gmail.com', '1', 'sdje3342SDHJ!A');
CREATE TABLE CATEGORIA (
    id int(11),
    nombre varchar(50) NOT NULL, 
    CONSTRAINT PK_CATEGORIA PRIMARY KEY (id) 
);
INSERT INTO CATEGORIA (id, nombre) VALUES (1, 'DOCENTES');
INSERT INTO CATEGORIA (id, nombre) VALUES (2, 'POLITICOS');
INSERT INTO CATEGORIA (id, nombre) VALUES (3, 'CIVILES');
INSERT INTO CATEGORIA (id, nombre) VALUES (4, 'EX PAREJAS');
CREATE TABLE PRODUCTO (
    id int(11) AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    descripcion varchar(200),
    precio double,
    CONSTRAINT PK_PRODUCTO PRIMARY KEY (id),
    idCategoria int(11) FOREIGN KEY REFERENCES CATEGORIA(id)
);
INSERT INTO PRODUCTO (nombre, precio, descripcion, idCategoria) VALUES ('Doctor Muerte', 745.19, 'Doctor muerte practica el sadismo con sus victimas. Prefiere a los civiles. Cuando el sadismo tiene carácter predominantemente sexual es una parafilia, y consiste en una forma de obtener excitación y placer sexual causando dolor físico o humillación. El sadismo implica impulsos sexuales y comportamientos que implican actos reales, no simulados, con o sin el consentimiento de la víctima, en los que el sufrimiento psicológico o físico y la humillación del sujeto sometido es lo que genera la excitación sexual.', 4);
INSERT INTO PRODUCTO (nombre, precio, descripcion, idCategoria) VALUES ('Barba Azul', 1245.29, 'Barba Azul practica el asesinato ritual con sus victimas. Una vez obtenido el objetivo a asesinar le hara pasar un buen rato antes de dejarlo descansar. Jugara con cada una de sus partes hasta que no pueda sentir dolor alguno. Cuando eso ocurre es porque ya esta muerto. Un asesinato eficaz y de lo menos discreto para que se entere todo el mundo. Barba Azul se centra en los POLITICOS corruptos.', 2);
INSERT INTO PRODUCTO (nombre, precio, descripcion, idCategoria) VALUES ('Ángel de la Muerte', 725.99, 'El Ángel de la Muerte practica el asesinato en serie. Usualmente empleado como un cuidador o enfermero. Según los mitos se trataría de asesinas; por el contrario, en realidad, una parte sustancial de los ángeles de la muerte ha estado conformada por hombres.​ A menudo, el ángel de la muerte se encuentra en una posición de poder o son motivados por mantener el control.', 2);
INSERT INTO PRODUCTO (nombre, precio, descripcion, idCategoria) VALUES ('El Asesino del Turbante', 945.29, 'El Ángel de la Muerte practica el asesinato en serie. Usualmente empleado como un cuidador o enfermero. Según los mitos se trataría de asesinas; por el contrario, en realidad, una parte sustancial de los ángeles de la muerte ha estado conformada por hombres.​ A menudo, el ángel de la muerte se encuentra en una posición de poder o son motivados por mantener el control.', 2);
INSERT INTO PRODUCTO (nombre, precio, descripcion, idCategoria) VALUES ('El Carnicero de Rostov', 1645.39, 'El Carnicero de Rostov practica el vampirismo. El vampirismo clínico es un raro trastorno mental, una parafilia caracterizada por ser asociada con una necesidad compulsiva de ver, sentir o ingerir la sangre existiendo o no el autoengaño creencial de ser un vampiro.', 1);
INSERT INTO PRODUCTO (nombre, precio, descripcion, idCategoria) VALUES ('Alfredo Romperalph', 1345.39, 'Alfredo Romperalph practica el vampirismo y tiene una gran obsesion con los docentes. El vampirismo clínico es un raro trastorno mental, una parafilia caracterizada por ser asociada con una necesidad compulsiva de ver, sentir o ingerir la sangre existiendo o no el autoengaño creencial de ser un vampiro.', 1);

CREATE TABLE PEDIDO (
    id int(11) AUTO_INCREMENT, 
    total double,
    fecha datetime DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_PEDIDO PRIMARY KEY (id),
    idUser int(11) FOREIGN KEY REFERENCES USUARIO(id)
);
CREATE TABLE LINEASPEDIDO (
    id int(11) AUTO_INCREMENT,
    cantidad int(10), 
    CONSTRAINT PK_LINEASPEDIDO PRIMARY KEY (id),
    idPedido int(11) FOREIGN KEY REFERENCES PEDIDO(id),
    idProducto int(11) FOREIGN KEY REFERENCES PRODUCTO(id)
);

