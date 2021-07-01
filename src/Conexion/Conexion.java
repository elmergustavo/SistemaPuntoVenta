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
    // datos para la conexion a un servidor de BD
    private String db = "punto_de_ventas";
    private String user = "root";
    private String password = "dlk123456";
    private String urlMysql = "jdbc:mysql://localhost:3306/";
    private String urlSql = "jdbc:sqlserver://localhost:1433;databaseName=" + db
            + ";integratedSecurity=true;";
    private Connection conn = null;
    private static Conexion instance = null;
     
    private Conexion() {
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
    
    public static Conexion createInstance(){
        if (instance == null){
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

}
