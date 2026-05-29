/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;

import com.mycompany.proyecto_final_p1.model.Cobros;
import java.sql.SQLException;
import com.mycompany.proyecto_final_p1.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Chriss
 */
public class CobrosDAO {

    public int realizarCobro(Cobros cobros) {

        try {
            Connection con = Conexion.getConexion();
            String sql = "INSERT INTO cobros(id_cuota, fechaInicio, fechaLimite, createdBy) values (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cobros.getIdCuota());
            ps.setDate(2, cobros.getFechaInicio());
            ps.setDate(3, cobros.getFechaLimite());
            ps.setInt(4, cobros.getCreatedBy());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Datos guardados", "Cobros", JOptionPane.INFORMATION_MESSAGE);
                return rs.getInt(1); // retorna el id_cobro real
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se guardaron los datos", "Cobros", JOptionPane.INFORMATION_MESSAGE);
        }
        return -1;
    }
    
    public Cobros obtenerUlimoCobro() throws SQLException{
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM cobros ORDER BY id_cobro DESC LIMIT 1"
            );
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Cobros c = new Cobros();
                c.setIdCobro(rs.getInt("id_cobro"));
                java.util.Date fecha = rs.getDate("fechaInicio");
                Calendar cal = Calendar.getInstance();
                cal.setTime(fecha);
                c.setMes(cal.get(Calendar.MONTH)+1);
                c.setAnio(cal.get(Calendar.YEAR));
                return c;
            } 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se completo el proceso", "Cobros", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    public List<Cobros> listarCobros() throws SQLException {
        List<Cobros> lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cobros");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cobros c = new Cobros();
                c.setIdCobro(rs.getInt("id_cobro"));
                c.setFechaInicio(rs.getDate("fechaInicio"));
                c.setFechaLimite(rs.getDate("fechaLimite"));
                c.setIdCuota(rs.getInt("id_cuota"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}
