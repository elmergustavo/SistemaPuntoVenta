package SaveColor;


import java.awt.Color;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elmer
 */
public class SaveColor {
    
    public static File colorFondo = new File("Color/colorFondo.txt");
    public static File colorBarra = new File("Color/colorBarra.txt");
    public static File colorTexto = new File("Color/colorTexto.txt");
    
    public static void colorFondo(Component componente){
        JColorChooser nuevoColor = new JColorChooser();
        nuevoColor.setVisible(true);
        Color nuevo = nuevoColor.showDialog(null,"Seleccionar Color de Fondo", componente.getBackground());
        if(nuevo != null){
            componente.setBackground(nuevo);
            String color = "rgb("+nuevo.getRed()+","+nuevo.getGreen()+","+nuevo.getBlue()+")";
            guardarColorFondo(color);
        }
    }
    
    private static void guardarColorFondo(String color){
        if(colorFondo.exists()){
            colorFondo.delete();
        }
        
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(colorFondo));
            FileWriter escribirArchivo = new FileWriter(colorFondo, true);
            BufferedWriter buffer = new BufferedWriter(escribirArchivo);
            buffer.write(color);
            buffer.newLine();
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveColor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //===================================================================================
    
    public static void colorBarra(Component componente){
        JColorChooser nuevoColor = new JColorChooser();
        nuevoColor.setVisible(true);
        Color nuevo = nuevoColor.showDialog(null,"Seleccionar Color de La Barra de Título", componente.getBackground());
        if(nuevo != null){
            componente.setBackground(nuevo);
            String color = "rgb("+nuevo.getRed()+","+nuevo.getGreen()+","+nuevo.getBlue()+")";
            guardarColorBarra(color);
        }
    }
    
    private static void guardarColorBarra(String color){
        if(colorBarra.exists()){
            colorBarra.delete();
        }
        
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(colorBarra));
            FileWriter escribirArchivo = new FileWriter(colorBarra, true);
            BufferedWriter buffer = new BufferedWriter(escribirArchivo);
            buffer.write(color);
            buffer.newLine();
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveColor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //===================================================================================
    
    public static void colorTexto(Component componente){
        JColorChooser nuevoColor = new JColorChooser();
        nuevoColor.setVisible(true);
        Color nuevo = nuevoColor.showDialog(null,"Seleccionar Color de Texto", componente.getForeground());
        if(nuevo != null){
            componente.setForeground(nuevo);
            String color = "rgb("+nuevo.getRed()+","+nuevo.getGreen()+","+nuevo.getBlue()+")";
            guardarColorTexto(color);
        }
    }
    
    private static void guardarColorTexto(String color){
        if(colorTexto.exists()){
            colorTexto.delete();
        }
        
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(colorTexto));
            FileWriter escribirArchivo = new FileWriter(colorTexto, true);
            BufferedWriter buffer = new BufferedWriter(escribirArchivo);
            buffer.write(color);
            buffer.newLine();
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveColor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
