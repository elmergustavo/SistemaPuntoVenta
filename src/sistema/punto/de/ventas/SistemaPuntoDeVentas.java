/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.punto.de.ventas;


import Controller.LoginVM;
import Models.Usuarios.TUsuarios;
import Views.Login;
import Views.Sistema;
import Views.Splash;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
           //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
           //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

//           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            
        }
//        Sistema sistema = new Sistema();
//        //sistema.setExtendedState(MAXIMIZED_BOTH);
//        sistema.setVisible(true);

        
        
        
        Splash splash = new Splash();
        splash.setVisible(true);
        
    }
    
}
