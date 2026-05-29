/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.model;

/**
 *
 * @author Admin
 */
public class Pago {
    private int idPago;
    private int idCasa;
    private int idCuota;
    private int idCobro;
    private int montoPagado;
    private boolean pagado;
    private int idCobroCasa;
    private int numeroCasa;
    private String nombrePropietario;
    private String telefonoPropietario;

    // Constructor
    public Pago(int idCasa, int idCuota, int montoPagado, int idCobro, int idCobroCasa) {
        this.idCasa = idCasa;
        this.idCuota = idCuota;
        this.montoPagado = montoPagado;
        this.idCobro = idCobro;
        this.idCobroCasa = idCobroCasa;
        this.pagado = false; // por defecto false al crear
    }
    
    public Pago(){
        
    }

    // Getters y Setters
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public int getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(int montoPagado) {
        this.montoPagado = montoPagado;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    
    public int getIdCobro(){
        return idCobro;
    }
    
    public void setIdCobro(int idCobro){
        this.idCobro = idCobro;
    }
    
    public int getIdCobroCasa(){
        return idCobroCasa;
    }
    
    public void setIdCobroCasa(int idCobroCasa) {
        this.idCobroCasa = idCobroCasa;
    }
    public int getNumeroCasa() { 
        return numeroCasa; 
    }
    public void setNumeroCasa(int numeroCasa) { 
        this.numeroCasa = numeroCasa; 
    }
    public String getNombrePropietario() { 
        return nombrePropietario; 
    }
    public void setNombrePropietario(String nombrePropietario) { 
        this.nombrePropietario = nombrePropietario; 
    }
    public String getTelefonoPropietario() { 
        return telefonoPropietario; 
    }
    public void setTelefonoPropietario(String telefonoPropietario) { 
        this.telefonoPropietario = telefonoPropietario; 
    }
}
