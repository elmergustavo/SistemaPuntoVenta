/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Conexion.Conexion;
import Models.Ordenador.Tordenadores;
import Models.Usuarios.TUsuarios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Gustavo
 */
public class UsuarioSQL {
    protected final Conexion conexion = Conexion.createInstance();
    private final QueryRunner QR = new QueryRunner();
    public List<TUsuarios> Usuarios() {
        List<TUsuarios> usuarios = new ArrayList();
        try {
            usuarios = (List<TUsuarios>) QR.query(conexion.getConnection(), "SELECT * FROM tusuarios",
                    new BeanListHandler(TUsuarios.class));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        return usuarios;
    }
    
    public List<Tordenadores> Ordenadores() {
        List<Tordenadores> odenadores = new ArrayList();
        try {
            odenadores = (List<Tordenadores>) QR.query(conexion.getConnection(), "SELECT * FROM tordenadores",
                    new BeanListHandler(Tordenadores.class));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        return odenadores;
    }
}
