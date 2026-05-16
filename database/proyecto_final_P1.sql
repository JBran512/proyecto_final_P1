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

CREATE TABLE condominio(
	id_condominio INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(9),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INT NOT NULL,
    FOREIGN KEY (created_by) REFERENCES usuario(id_usuario),
    PRIMARY KEY (id_condominio)
);

CREATE TABLE propietario(
	id_propietario INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(9) NOT NULL,
    correo VARCHAR (100) NOT NULL UNIQUE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by INT NOT NULL,
    updated_by INT NULL,
    FOREIGN KEY (updated_by) REFERENCES usuario(id_usuario),
    FOREIGN KEY (created_by) REFERENCES usuario(id_usuario),
    PRIMARY KEY (id_propietario)
);

CREATE TABLE casa(
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

CREATE TABLE cuota(
	id_cuota INT NOT NULL AUTO_INCREMENT,
    created_by INT NOT NULL,
    mes INT NOT NULL,
    anio INT NOT NULL,
    monto INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES usuario(id_usuario),
    UNIQUE KEY uk_mes_anio (mes, anio),
    PRIMARY KEY (id_cuota)
);

CREATE TABLE pago(
	id_pago INT NOT NULL AUTO_INCREMENT,
    id_casa INT NOT NULL,
    id_cuota INT NOT NULL,
    monto_pagado INT NOT NULL,
    pagado BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INT NOT NULL,
    FOREIGN KEY (created_by) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_casa) REFERENCES casa(id_casa),
    FOREIGN KEY (id_cuota) REFERENCES cuota(id_cuota),
    UNIQUE KEY uk_casa_cuota (id_casa, id_cuota),
    PRIMARY KEY (id_pago)
);

CREATE TABLE cobros(
	id_cobro INT AUTO_INCREMENT,
    monto INT NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaLimite DATE NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    createdBy INT NOT NULL,
    PRIMARY KEY(id_cobro)
);


