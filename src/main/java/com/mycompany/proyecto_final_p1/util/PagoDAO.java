/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;
import com.mycompany.proyecto_final_p1.model.Casa;
import com.mycompany.proyecto_final_p1.model.Pago;
import com.mycompany.proyecto_final_p1.model.Sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chriss
 */

public class PagoDAO {
  public boolean generarPagos(int idCobro) throws SQLException{
      try{
          Connection con = Conexion.getConexion();
          CasaDAO casaDAO = new CasaDAO();
          List<Casa> casas = casaDAO.listarCasas();
          
          for (Casa c : casas){
              PreparedStatement ps = con.prepareStatement(
                      "INSERT INTO pago (id_cobro, id_casa, monto_pagado, pagado, created_by) VALUES (?, ?, ?, ?, ?)"
              );
              ps.setInt(1, idCobro);
              ps.setInt(2, c.getIdCasa());
              ps.setInt(3, 0);
              ps.setBoolean(4, false);
              ps.setInt(5, Sesion.getIdUsuario());
              ps.executeUpdate();
          }
          return true;
      }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
      return false;
  }
  
    public List<Pago> listarPendientes(int idCobro) throws SQLException {
        List<Pago> lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM pago WHERE id_cobro = ? AND pagado = false"
            );
            ps.setInt(1, idCobro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pago p = new Pago();
                p.setIdPago(rs.getInt("id_pago"));
                p.setIdCasa(rs.getInt("id_casa"));
                p.setMontoPagado(rs.getInt("monto_pagado"));
                p.setPagado(rs.getBoolean("pagado"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
    
    public boolean registrarPago(Pago pago) throws SQLException{
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE pago SET pagado = ?, monto_pagado = ? WHERE id_pago = ?"
            );
            ps.setBoolean(1, pago.isPagado());
            ps.setInt(2, pago.getMontoPagado());
            ps.setInt(3, pago.getIdPago());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    public boolean existePago(int idCasa, int idCobro) throws SQLException{
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM pago WHERE id_casa = ? AND id_cobro = ?"
            );
            ps.setInt(1, idCasa);
            ps.setInt(2, idCobro);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}


