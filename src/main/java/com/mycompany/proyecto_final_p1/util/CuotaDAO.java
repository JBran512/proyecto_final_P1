/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;

import com.mycompany.proyecto_final_p1.model.Cuota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CuotaDAO {
    public List<Cuota> listarCuotas() throws SQLException{
        List<Cuota> lista = new ArrayList<>();
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM cuota"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Cuota c = new Cuota();
                c.setIdCuota(rs.getInt("id_cuota"));
                c.setMes(rs.getInt("mes"));
                c.setAnio(rs.getInt("anio"));
                c.setMonto(rs.getInt("monto"));
                lista.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al cargar las cuotas: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public boolean insertar(Cuota cuota) throws SQLException{
       try{
           Connection con = Conexion.getConexion();
           PreparedStatement ps = con.prepareStatement(
                "INSERT INTO cuota (mes, anio, monto, created_by) VALUES (?, ?, ?, ?)"
            );
           ps.setInt(1, cuota.getMes());
           ps.setInt(2, cuota.getAnio());
           ps.setInt(3, cuota.getMonto());
           ps.setInt(4, cuota.getCreatedBy());
           return ps.executeUpdate() > 0;
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al guardar la cuota: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
       return false;
    }
    
    public Cuota obtenerCuotaPorMes(int mes, int anio) throws SQLException{
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM cuota WHERE mes = ? AND anio = ?"
            );
            ps.setInt(1, mes);
            ps.setInt(2, anio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Cuota c = new Cuota();
                c.setIdCuota(rs.getInt("id_cuota"));
                c.setMes(rs.getInt("mes"));
                c.setAnio(rs.getInt("anio"));
                c.setMonto(rs.getInt("monto"));
                return c;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al obtener la cuota: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean existeCuota(int mes, int anio) throws SQLException{
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM cuota WHERE mes = ? AND anio = ?"
            );
            ps.setInt(1, mes);
            ps.setInt(2, anio);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al validar la cuota: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public List<String[]> obtenerEstadoCuentaPorCasa(int idCasa) throws SQLException {
    List<String[]> lista = new ArrayList<>();
    
    // Consulta exacta uniendo la cuota general, el cobro y el pago asignado a la casa
    String sql = "SELECT c.anio, c.mes, c.monto, p.monto_pagado, p.pagado " +
                 "FROM cuota c " +
                 "INNER JOIN cobros cb ON c.id_cuota = cb.id_cuota " +
                 "INNER JOIN pago p ON cb.id_cobro = p.id_cobro " +
                 "WHERE p.id_casa = ? " +
                 "ORDER BY c.anio DESC, c.mes DESC";
                 
    try {
        Connection con = Conexion.getConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCasa);
        ResultSet rs = ps.executeQuery();
        
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
        while (rs.next()) {
            String anio = String.valueOf(rs.getInt("anio"));
            int numMes = rs.getInt("mes");
            String mesNombre = (numMes >= 1 && numMes <= 12) ? meses[numMes - 1] : "Mes " + numMes;
            
            String montoCuota = "Q." + rs.getInt("monto");
            String montoPagado = "Q." + rs.getInt("monto_pagado");
            
            boolean esPagado = rs.getBoolean("pagado");
            String estado = esPagado ? "Pagado" : "Pendiente";
            
            lista.add(new String[]{anio, mesNombre, montoCuota, montoPagado, estado});
        }
    } catch (SQLException e) {
        System.out.println("Error en Estado de Cuenta: " + e.getMessage());
    }
    return lista;
}
}