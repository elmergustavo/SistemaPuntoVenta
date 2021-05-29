/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class Conexion {

    private String db = "punto_de_ventas";
    private String user = "root";
    private String password = "hacker.net";
    private String urlMysql = "jdbc:mysql://localhost:3310/";
    private String urlSql = "jdbc:sqlserver://localhost:1433;databaseName=" + db
            + ";integratedSecurity=true;";
    private Connection conn = null;
    // 

    public Conexion() {
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.urlMysql + this.db, this.user, this.password);
            System.out.println("conectado exitosamente xd");
            //Conexion a SQL Server
            //obtenemos el driver de para SQL Server
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn =DriverManager.getConnection(urlSql);
            if (conn != null) {
                System.out.println("Conexión a la base de datos " + this.db + "...... Listo ");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error : " + ex);
        }
    }

    public Connection getConn() {
        return conn;
    }

}
