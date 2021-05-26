/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaPuntoVenta;

import Views.Sistema;
import java.awt.Frame;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.lang.Short.MAX_VALUE;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Gustavo
 */
public class SistemaPuntoVenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLooKAndFeel");
        } catch (Exception e) {
            
        }
        Sistema sistema = new Sistema();
        sistema.setExtendedState(MAXIMIZED_BOTH); //Maximizar pantalla
        sistema.setVisible(true);
    }

}
