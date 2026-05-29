/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;

import com.mycompany.proyecto_final_p1.model.Cobroindividual;
import com.mycompany.proyecto_final_p1.model.Cobros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Chriss
 */
public class CobroindividualDAO {
    public ArrayList<Cobroindividual> listarCasas() {

    ArrayList<Cobroindividual> casas = new ArrayList<>();

    try {
        Connection con = Conexion.getConexion();

        String sql = """
                     SELECT id_casa, numero_casa
                     FROM casa
                     ORDER BY numero_casa
                     """;

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            casas.add(
                new Cobroindividual(
                    rs.getInt("id_casa"),
                    rs.getInt("numero_casa")
                )
            );

        }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
   return casas;
}
    
     public boolean insertarCobro(Cobroindividual cobro) throws SQLException{
       try{
           Connection con = Conexion.getConexion();
           PreparedStatement ps = con.prepareStatement(
                "INSERT INTO cobro_casa (id_casa, pagado,  descripcion, fechaInicio, fechaLimite, monto, tipo_cobro, mes, anio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
           ps.setInt(1, cobro.getId_casa());
           ps.setBoolean(2, false);
           ps.setString(3, cobro.getDescripcion());
           ps.setDate(4, cobro.getFechaInicio());
           ps.setDate(5, cobro.getFechaLimite());
           ps.setInt(6, cobro.getMonto());
           ps.setString(7, cobro.getTipo_cobro());
           ps.setInt(8, cobro.getMes());
           ps.setInt(9, cobro.getAnio());
           return ps.executeUpdate() > 0;
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al guardar el cobro: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
       return false;
    }
     
    public boolean existeMensualidad(int idCasa, int mes,int anio) {
       try {

        Connection con =
                Conexion.getConexion();

        String sql = """
            SELECT *
            FROM cobro_casa
            WHERE id_casa = ?
            AND tipo_cobro = ?
            AND mes = ?
            AND anio = ?
        """;

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, idCasa);

        ps.setString(
                2,
                "Mensualidad"
        );

        ps.setInt(3, mes);

        ps.setInt(4, anio);

       
        System.out.println(
                "ID CASA: " + idCasa
        );

        System.out.println(
                "MES: " + mes
        );

        System.out.println(
                "ANIO: " + anio
        );

        ResultSet rs =
                ps.executeQuery();

           if (rs.next()) {

               return true;

           }

    } catch (SQLException e) {

        System.out.println(
                e.getMessage()
        );

    }

    return false; 
    }
}
