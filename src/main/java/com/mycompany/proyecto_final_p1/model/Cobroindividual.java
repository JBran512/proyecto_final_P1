/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.model;

import java.sql.Date;

/**
 *
 * @author Chriss
 */

// representa la couta individual asignada a una casa espcifica incluyendo montos, fechas y estado de la deuda
public class Cobroindividual {
    private int id_cobro_casa;
    private int numero_casa;
    private int id_casa;
    private boolean pagado;
    private String descripcion;
    private int monto;
    private Date fechaInicio;
    private Date fechaLimite;
    private String tipo_cobro;
    private int mes;
    private int anio;
// el constructor vacio es necesario para el mapeo automatico desde la base de datos
    public Cobroindividual() {
    }
//inicia un cobro y lo vincula a la casa especifica apoyandose del ID y numero de casa
    public Cobroindividual(int id_casa, int numero_casa) {
        this.id_casa = id_casa;
        this.numero_casa = numero_casa;
    }
// recupera los regristros existentes desde la base de datos
    public Cobroindividual(int id_cobro_casa, int numero_casa, int id_casa, boolean pagado, String descripcion, int monto, Date fechaInicio, Date fechaLimite, String tipo_cobro, int mes, int anio) {
        this.id_cobro_casa = id_cobro_casa;
        this.numero_casa = numero_casa;
        this.id_casa = id_casa;
        this.pagado = pagado;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.tipo_cobro = tipo_cobro;
        this.mes = mes;
        this.anio = anio;
    }

//metodos de acceso
    public int getId_cobro_casa() {
        return id_cobro_casa;
    }

    public void setId_cobro_casa(int id_cobro_casa) {
        this.id_cobro_casa = id_cobro_casa;
    }

    public int getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(int numero_casa) {
        this.numero_casa = numero_casa;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getTipo_cobro() {
        return tipo_cobro;
    }

    public void setTipo_cobro(String tipo_cobro) {
        this.tipo_cobro = tipo_cobro;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
  
    
    
     @Override
    public String toString() {
        return "Casa " + numero_casa;
    }
    
}
