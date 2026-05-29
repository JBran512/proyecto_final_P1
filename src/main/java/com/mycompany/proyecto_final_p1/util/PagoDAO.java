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
    public boolean generarPagoIndividual(int idCobroCasa, int idCasa) throws SQLException {
        try {
            Connection con = Conexion.getConexion();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO pago (id_casa, id_cobro_casa, monto_pagado, pagado, created_by) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setInt(1, idCasa);
            ps.setInt(2, idCobroCasa);
            ps.setInt(3, 0);
            ps.setBoolean(4, false);
            ps.setInt(5, Sesion.getIdUsuario());
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
  //obtiene una lista con las deudas pendientes a un lote o grupo de cobro especifico
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
    
    public List<Pago> listarPagosPendientes(int idCasa) throws SQLException {
        List<Pago> lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT p.id_pago, p.id_casa, p.id_cobro, p.id_cobro_casa, p.monto_pagado, p.pagado, c.monto as monto_cuota " +
                "FROM pago p " +
                "INNER JOIN cobros co ON p.id_cobro = co.id_cobro " +
                "INNER JOIN cuota c ON co.id_cuota = c.id_cuota " +
                "WHERE p.id_casa = ? AND p.pagado = false " +
                "UNION ALL " +
                "SELECT p.id_pago, p.id_casa, p.id_cobro, p.id_cobro_casa, p.monto_pagado, p.pagado, cc.monto as monto_cuota " +
                "FROM pago p " +
                "INNER JOIN cobro_casa cc ON p.id_cobro_casa = cc.id_cobro_casa " +
                "WHERE p.id_casa = ? AND p.pagado = false"
            );
            ps.setInt(1, idCasa);
            ps.setInt(2, idCasa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pago p = new Pago();
                p.setIdPago(rs.getInt("id_pago"));
                p.setIdCasa(rs.getInt("id_casa"));
                p.setIdCobro(rs.getInt("id_cobro"));
                p.setIdCobroCasa(rs.getInt("id_cobro_casa"));
                p.setMontoPagado(rs.getInt("monto_cuota"));
                p.setPagado(rs.getBoolean("pagado"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
    
    public List<Pago> listarPagosSaldados(int idCasa) throws SQLException {
        List<Pago> lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT p.id_pago, p.id_casa, p.id_cobro, p.id_cobro_casa, p.monto_pagado, p.pagado, c.monto as monto_cuota " +
                "FROM pago p " +
                "INNER JOIN cobros co ON p.id_cobro = co.id_cobro " +
                "INNER JOIN cuota c ON co.id_cuota = c.id_cuota " +
                "WHERE p.id_casa = ? AND p.pagado = false " +
                "UNION ALL " +
                "SELECT p.id_pago, p.id_casa, p.id_cobro, p.id_cobro_casa, p.monto_pagado, p.pagado, cc.monto as monto_cuota " +
                "FROM pago p " +
                "INNER JOIN cobro_casa cc ON p.id_cobro_casa = cc.id_cobro_casa " +
                "WHERE p.id_casa = ? AND p.pagado = true"
            );
            ps.setInt(1, idCasa);
            ps.setInt(2, idCasa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pago p = new Pago();
                p.setIdPago(rs.getInt("id_pago"));
                p.setIdCasa(rs.getInt("id_casa"));
                p.setIdCobro(rs.getInt("id_cobro"));
                p.setIdCobroCasa(rs.getInt("id_cobro_casa"));
                p.setMontoPagado(rs.getInt("monto_cuota"));
                p.setPagado(rs.getBoolean("pagado"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
    
    public boolean registrarPago(int idPago, int idCobro, int idCobroCasa) throws SQLException {
        try {
            Connection con = Conexion.getConexion();
            int monto = 0;

            if (idCobro != 0) {
                // Es un cobro mensual
                PreparedStatement ps = con.prepareStatement(
                        "SELECT c.monto FROM cuota c "
                        + "INNER JOIN cobros co ON c.id_cuota = co.id_cuota "
                        + "WHERE co.id_cobro = ?"
                );
                ps.setInt(1, idCobro);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    monto = rs.getInt("monto");
                }
            } else {
                // Es un cobro individual
                PreparedStatement ps = con.prepareStatement(
                        "SELECT monto FROM cobro_casa WHERE id_cobro_casa = ?"
                );
                ps.setInt(1, idCobroCasa);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    monto = rs.getInt("monto");
                }
            }

            // Actualizar el pago
            PreparedStatement ps2 = con.prepareStatement(
                    "UPDATE pago SET pagado = true, monto_pagado = ? WHERE id_pago = ?"
            );
            ps2.setInt(1, monto);
            ps2.setInt(2, idPago);
            return ps2.executeUpdate() > 0;

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
    public List<Pago> listarMorosas(int idCobro) throws SQLException {
        List<Pago> lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT p.id_pago, p.id_casa, c.numero_casa, " +
                "pr.nombre, pr.telefono " +
                "FROM pago p " +
                "INNER JOIN casa c ON p.id_casa = c.id_casa " +
                "INNER JOIN propietario pr ON c.id_propietario = pr.id_propietario " +
                "WHERE p.id_cobro = ? AND p.pagado = false"
            );
            ps.setInt(1, idCobro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pago p = new Pago();
                p.setIdPago(rs.getInt("id_pago"));
                p.setIdCasa(rs.getInt("id_casa"));
                p.setNumeroCasa(rs.getInt("numero_casa"));
                p.setNombrePropietario(rs.getString("nombre"));
                p.setTelefonoPropietario(rs.getString("telefono"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}


