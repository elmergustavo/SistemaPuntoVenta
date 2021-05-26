
package Libreria;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author elmer
 */
public class UploadImage extends javax.swing.JFrame{
    private File archivo;
    private JFileChooser abrirArchivo;
    private static String urlOrigen = null;
    private static byte[]imageByte = null;

    public static byte[] getImageByte() {
        return imageByte;
    }
    
    
    public void CargarImagen(JLabel label){
        abrirArchivo = new JFileChooser();
        abrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivos de Imagen", "jpg","png","gif"));
        int respuesta = abrirArchivo.showOpenDialog(this);
        
        if (respuesta==JFileChooser.APPROVE_OPTION){
            archivo = abrirArchivo.getSelectedFile();
            urlOrigen = archivo.getAbsolutePath();
            Image foto = getToolkit().getImage(urlOrigen);
            foto = foto.getScaledInstance(140, 140, 1);
            label.setIcon(new ImageIcon(foto));
            imageByte = new byte[(int) archivo.length()];
        }
    }
}
