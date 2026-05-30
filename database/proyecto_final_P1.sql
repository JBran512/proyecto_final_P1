CREATE DATABASE IF NOT EXISTS proyecto_final_P1;
USE proyecto_final_P1;

CREATE TABLE usuario (
    id_usuario INT NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_usuario)
);

CREATE TABLE condominio (
    id_condominio INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INT NOT NULL,
    FOREIGN KEY (created_by) REFERENCES usuario(id_usuario),
    PRIMARY KEY (id_condominio)
);

CREATE TABLE propietario (
    id_propietario INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by INT NOT NULL,
    updated_by INT NULL,
    FOREIGN KEY (updated_by) REFERENCES usuario(id_usuario),
    FOREIGN KEY (created_by) REFERENCES usuario(id_usuario),
    PRIMARY KEY (id_propietario)
);

CREATE TABLE casa (
    id_casa INT NOT NULL AUTO_INCREMENT,
    numero_casa INT NOT NULL UNIQUE,
    id_propietario INT NOT NULL,
    id_condominio INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by INT NOT NULL,
    updated_by INT NULL,
    FOREIGN KEY (updated_by) REFERENCES usuario(id_usuario),
    FOREIGN KEY (created_by) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_propietario) REFERENCES propietario(id_propietario),
    FOREIGN KEY (id_condominio) REFERENCES condominio(id_condominio),
    PRIMARY KEY (id_casa)
);

CREATE TABLE cuota (
    id_cuota INT NOT NULL AUTO_INCREMENT,
    mes INT NOT NULL,
    anio INT NOT NULL,
    monto INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INT NOT NULL,
    FOREIGN KEY (created_by) REFERENCES usuario(id_usuario),
    UNIQUE KEY uk_mes_anio (mes, anio),
    PRIMARY KEY (id_cuota)
);

CREATE TABLE cobros (
    id_cobro INT NOT NULL AUTO_INCREMENT,
    id_cuota INT NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaLimite DATE NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    createdBy INT NOT NULL,
    PRIMARY KEY (id_cobro),
    FOREIGN KEY (id_cuota) REFERENCES cuota(id_cuota),
    FOREIGN KEY (createdBy) REFERENCES usuario(id_usuario)
);

CREATE TABLE cobro_casa (
    id_cobro_casa INT NOT NULL AUTO_INCREMENT,
    id_casa INT NOT NULL,
    monto INT NOT NULL,
    descripcion VARCHAR(255),
    fechaInicio DATE,
    fechaLimite DATE,
    tipo_cobro VARCHAR(50),
    mes INT NULL,
    anio INT NULL,
    PRIMARY KEY (id_cobro_casa),
    FOREIGN KEY (id_casa) REFERENCES casa(id_casa)
);

CREATE TABLE pago (
    id_pago INT NOT NULL AUTO_INCREMENT,
    id_casa INT NOT NULL,
    id_cobro INT NULL,
    id_cobro_casa INT NULL,
    monto_pagado INT NOT NULL,
    pagado BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INT NOT NULL,
    FOREIGN KEY (created_by) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_casa) REFERENCES casa(id_casa),
    FOREIGN KEY (id_cobro) REFERENCES cobros(id_cobro),
    FOREIGN KEY (id_cobro_casa) REFERENCES cobro_casa(id_cobro_casa),
    UNIQUE KEY uk_casa_cobro (id_casa, id_cobro),
    PRIMARY KEY (id_pago)
);

#Datos de prueba directos de sql
INSERT INTO usuario (usuario, contrasena, activo) 
VALUES ('iusr_vistaverde', 'R3sidencial2026%', true);

-- Condominio
INSERT INTO condominio (nombre, direccion, telefono, created_by)
VALUES ('Residencial Vista Verde', 'Zona 10, Ciudad de Guatemala', '23456789', 1);

-- Propietarios
INSERT INTO propietario (nombre, telefono, correo, created_by) VALUES
('Carlos Méndez', '+502 55551001', 'carlos.mendez@gmail.com', 1),
('María López', '+502 55551002', 'maria.lopez@gmail.com', 1),
('José Martínez', '+502 55551003', 'jose.martinez@gmail.com', 1),
('Ana García', '+502 55551004', 'ana.garcia@gmail.com', 1),
('Luis Rodríguez', '+502 55551005', 'luis.rodriguez@gmail.com', 1),
('Sofia Hernández', '+502 55551006', 'sofia.hernandez@gmail.com', 1),
('Pedro Ramírez', '+502 55551007', 'pedro.ramirez@gmail.com', 1),
('Laura Torres', '+502 55551008', 'laura.torres@gmail.com', 1),
('Diego Flores', '+502 55551009', 'diego.flores@gmail.com', 1),
('Valeria Cruz', '+502 55551010', 'valeria.cruz@gmail.com', 1);

-- Casas
INSERT INTO casa (numero_casa, id_propietario, id_condominio, created_by) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1),
(3, 3, 1, 1),
(4, 4, 1, 1),
(5, 5, 1, 1),
(6, 6, 1, 1),
(7, 7, 1, 1),
(8, 8, 1, 1),
(9, 9, 1, 1),
(10, 10, 1, 1);
