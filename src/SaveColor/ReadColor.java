package SaveColor;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elmer
 */
public class ReadColor {

    public static File colorFondo = new File("Color/colorFondo.txt");
    public static File colorBarra = new File("Color/colorBarra.txt");
    public static File colorTexto = new File("Color/colorTexto.txt");

    public static Color leerColorFondo() {
        String colorCadena = "";
        Color color = null;

        if (colorFondo.exists()) {
            String linea = "";

            try {
                FileReader leerArchivo = new FileReader(colorFondo);
                BufferedReader buffer = new BufferedReader(leerArchivo);

                while ((linea = buffer.readLine()) != null) {
                    colorCadena += linea;
                }

                color = parseColor(colorCadena);

                return color;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReadColor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReadColor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    //============================================================================================
    
    public static Color leerColorBarra() {
        String colorCadena = "";
        Color color = null;

        if (colorBarra.exists()) {
            String linea = "";

            try {
                FileReader leerArchivo = new FileReader(colorBarra);
                BufferedReader buffer = new BufferedReader(leerArchivo);

                while ((linea = buffer.readLine()) != null) {
                    colorCadena += linea;
                }

                color = parseColor(colorCadena);

                return color;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReadColor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReadColor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    //============================================================================================
    
    public static Color leerColorTexto() {
        String colorCadena = "";
        Color color = null;

        if (colorTexto.exists()) {
            String linea = "";

            try {
                FileReader leerArchivo = new FileReader(colorTexto);
                BufferedReader buffer = new BufferedReader(leerArchivo);

                while ((linea = buffer.readLine()) != null) {
                    colorCadena += linea;
                }

                color = parseColor(colorCadena);

                return color;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReadColor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReadColor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static Color parseColor(String color) {
        Pattern c = Pattern.compile("rgb *\\( *([0-9]+), *([0-9]+), *([0-9]+) *\\)");
        Matcher m = c.matcher(color);

        if (m.matches()) {
            return new Color(
                    Integer.valueOf(m.group(1)),//R}
                    Integer.valueOf(m.group(2)),//G
                    Integer.valueOf(m.group(3))//B
            );
        }
        return null;
    }

}
