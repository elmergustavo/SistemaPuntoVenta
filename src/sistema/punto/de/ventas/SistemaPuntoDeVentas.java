/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.punto.de.ventas;

import Views.Sistema;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.UIManager;

/**
 *
 * @author Gustavo
 */
public class SistemaPuntoDeVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //     UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            
//           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
        Sistema sistema = new Sistema();
        sistema.setExtendedState(MAXIMIZED_BOTH);
        sistema.setVisible(true);
    }

}
