/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Conexion.Conexion;
import static Views.ListaVenta.pedidos;
import static Views.Sistema.numFac;
import com.mysql.jdbc.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gustavo
 */
public class JreportJaper {
    private Conexion conexion = Conexion.createInstance();
    
    public void jasper (int idFac, int idMesa, int idCliente){
        try {          
            Connection conn = (Connection) conexion.getConnection();
            JasperReport reporte = null;
            String path = "C://Users//Gustavo//Desktop//SistemaPuntoVenta//src//JReport//Factura.jasper";
            
            
            System.out.println(idFac);
            Map parametro = new HashMap();
            parametro.put("id_Mesa", idMesa);
            System.out.println("La gran Puta");
            System.out.println(idCliente);
            parametro.put("id_Cliente",idCliente);
            parametro.put("id_Venta", idFac);
            
            
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);
            
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        }
    }
    
    public void jasperAlimento (){
        try {          
            Connection conn = (Connection) conexion.getConnection();
            JasperReport reporte = null;
            String path = "C://Users//Gustavo//Desktop//SistemaPuntoVenta//src//JReport//Alimentos.jasper";
            
            
            
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        }
    }
}
