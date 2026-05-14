/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Conexion {
    private static Connection conexion = null;
    public static Connection getConexion() throws SQLException{
          if (conexion == null){
              try {
                  Properties props = new Properties();
                  InputStream input = Conexion.class.getClassLoader().getResourceAsStream("db.properties");
                  props.load(input);
                  String url = props.getProperty("db.url");
                  String user = props.getProperty("db.user");
                  String password = props.getProperty("db.password");
                  
                  conexion = DriverManager.getConnection(url, user, password);
              } catch (IOException e){
                  System.out.println("Error leyendo db.properties: " + e.getMessage());
              }
          }
          return conexion;
    }
}

/**
 * Clase utilitaria para gestionar la conexión a la base de datos.
 * 
 * INSTRUCCIONES PARA USAR EN LOS DAOs:
 * 
 * 1. Importar esta clase:
 *    import com.mycompany.proyecto_final_p1.util.Conexion;
 * 
 * 2. Importar las clases de SQL:
 *    import java.sql.Connection;
 *    import java.sql.PreparedStatement;
 *    import java.sql.ResultSet;
 *    import java.sql.SQLException;
 * 
 * 3. Obtener la conexión dentro de cada método:
 *    Connection con = Conexion.getConexion();
 * 
 * 4. Ejemplo de método en un DAO:
 *    public boolean insertar(Propietario p) {
 *        try {
 *            Connection con = Conexion.getConexion();
 *            PreparedStatement ps = con.prepareStatement(
 *                "INSERT INTO propietario (nombre, telefono, correo) VALUES (?, ?, ?)"
 *            );
 *            ps.setString(1, p.getNombre());
 *            ps.setString(2, p.getTelefono());
 *            ps.setString(3, p.getCorreo());
 *            return ps.executeUpdate() > 0;
 *        } catch (SQLException e) {
 *            System.out.println("Error: " + e.getMessage());
 *        }
 *        return false;
 *    }
 */
