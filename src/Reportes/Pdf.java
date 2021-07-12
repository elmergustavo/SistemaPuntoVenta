/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Conexion.Conexion;
import static Views.ListarClientes.telefono;
import Views.Sistema;
import static Views.Sistema.Subtotal;
import static Views.Sistema.TotalCotizacion;
import static Views.Sistema.descuento;
import static Views.Sistema.nidCotizacion;
import static Views.Sistema.porcentaje;
import static Views.Sistema.tablaCotizaciones;
import static Views.Sistema.tablePedidos;
import static Views.Sistema.rSLabelHora1;
import static Views.ListaVenta.pedidos;
import static Views.ListaVenta.total;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import rojerusan.RSNotifyFade;

/**
 *
 * @author elmer
 */
public class Pdf {

    public void pdf() {
        try {
            //  int id = Vdao.IdVenta();
            FileOutputStream archivo;
            File file = new File("src/pdf/venta" + "1" + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Resources/logo.png");

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{60f, 10f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);

            String ruc = "234234234";
            String nom = "Restaurante calle real";
            String tel = "234234324";
            String dir = "Guatemala";
            String ra = "Tavcode";

            Encabezado.addCell("");
            Encabezado.addCell("Ruc: " + ruc + "\nNombre: " + nom + "\nTelefono: " + tel + "\nDireccion: " + dir + "\nRazon: " + ra);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            Conexion conexion = Conexion.createInstance();
            //  String ruta = System.getProperty("user.home");
            //  PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Alumnos.pdf"));
            //   documento.open();

            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("REPORTE SUMINISTROS" + "\n\n");
            doc.add(cli);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            float[] ColumnaTabla = new float[]{15f, 30f, 10f, 10f, 30f};
            tabla.setWidths(ColumnaTabla);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cl1 = new PdfPCell(new Phrase("Código", negrita));
            PdfPCell cl2 = new PdfPCell(new Phrase("Nombre del Suministro", negrita));
            PdfPCell cl3 = new PdfPCell(new Phrase("Stock", negrita));
            PdfPCell cl4 = new PdfPCell(new Phrase("Precio", negrita));
            PdfPCell cl5 = new PdfPCell(new Phrase("Categoria", negrita));
            cl1.setBackgroundColor(BaseColor.ORANGE);
            cl2.setBackgroundColor(BaseColor.ORANGE);
            cl3.setBackgroundColor(BaseColor.ORANGE);
            cl4.setBackgroundColor(BaseColor.ORANGE);
            cl5.setBackgroundColor(BaseColor.ORANGE);

            tabla.addCell(cl1);
            tabla.addCell(cl2);
            tabla.addCell(cl3);
            tabla.addCell(cl4);
            tabla.addCell(cl5);

            try {
                Connection cn = conexion.getConnection();
                PreparedStatement pst = cn.prepareStatement("select * from suministros");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    doc.add(tabla);
                }

                //Desktop.getDesktop().open();
            } catch (DocumentException | SQLException e) {
            }
            // documento.close();
            new rojerusan.RSNotifyFade("Reportes", "Reporte Generado Correctamente", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {

        }
    }

    public void pdfAlimentos() {
        try {
            //  int id = Vdao.IdVenta();
            FileOutputStream archivo;
            File file = new File("src/pdf/ReporteAlimentos" + "" + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Resources/logo.png");

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{60f, 10f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);

            String ruc = "234234234";
            String nom = "Restaurante calle real";
            String tel = "234234324";
            String dir = "Guatemala";
            String ra = "Tavcode";

            Encabezado.addCell("");
            Encabezado.addCell("Ruc: " + ruc + "\nNombre: " + nom + "\nTelefono: " + tel + "\nDireccion: " + dir + "\nRazon: " + ra);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            Conexion conexion = Conexion.createInstance();
            //  String ruta = System.getProperty("user.home");
            //  PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Alumnos.pdf"));
            //   documento.open();

            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("REPORTE PLATILLOS" + "\n\n");
            doc.add(cli);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            float[] ColumnaTabla = new float[]{12f, 30f, 10f, 20f};
            tabla.setWidths(ColumnaTabla);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cl1 = new PdfPCell(new Phrase("Código", negrita));
            PdfPCell cl2 = new PdfPCell(new Phrase("Nombre del Platillo", negrita));
            PdfPCell cl3 = new PdfPCell(new Phrase("Precio", negrita));
            PdfPCell cl4 = new PdfPCell(new Phrase("Tipo Alimento", negrita));
            cl1.setBackgroundColor(BaseColor.ORANGE);
            cl2.setBackgroundColor(BaseColor.ORANGE);
            cl3.setBackgroundColor(BaseColor.ORANGE);
            cl4.setBackgroundColor(BaseColor.ORANGE);

            tabla.addCell(cl1);
            tabla.addCell(cl2);
            tabla.addCell(cl3);
            tabla.addCell(cl4);

            try {
                Connection cn = conexion.getConnection();
                PreparedStatement pst = cn.prepareStatement("select * from alimentos");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    doc.add(tabla);
                }

                //Desktop.getDesktop().open();
            } catch (DocumentException | SQLException e) {
            }
            // documento.close();
            new rojerusan.RSNotifyFade("Reportes", "Reporte Generado Correctamente", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {

        }
    }
    
    
    public void pdfCotizacion() {
        try {
            //  int id = Vdao.IdVenta();
            FileOutputStream archivo;
            File file = new File("src/pdf/Cotizacion" + "" + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Resources/logo.png");

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{60f, 10f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);

            String ruc = "234234234";
            String nom = "Restaurante calle real";
            String tel = "234234324";
            String dir = "Guatemala";
            String ra = "Comida Tipica";

            Encabezado.addCell("");
            Encabezado.addCell("Ruc: " + ruc + "\nNombre: " + nom + "\nTelefono: " + tel + "\nDireccion: " + dir + "\nRazon: " + ra);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            Conexion conexion = Conexion.createInstance();
            //  String ruta = System.getProperty("user.home");
            //  PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Alumnos.pdf"));
            //   documento.open();

            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("DATOS DEL CLIENTE" + "\n\n");
            doc.add(cliente);
            
            PdfPTable tablaCliente = new PdfPTable(1);
            tablaCliente.setWidthPercentage(100);
            float[] ColumnaTablaCliente = new float[]{50f};
            tablaCliente.setWidths(ColumnaTablaCliente);
            tablaCliente.getDefaultCell().setBorder(0);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            

            String nid = nidCotizacion.getText();
            String nombreCliente = Sistema.nombreCotizacion.getText();
            String apellido = Sistema.apellidoCotizacion.getText();
            String direccion = Sistema.dirCotizacion.getText();
            
    
            
            
            tablaCliente.addCell("Nid: " + nid + "\nNombre: " + nombreCliente + "\nApellido: " + apellido + "\nDireccion: " + direccion + "\nTelefono: " + telefono);
            

            
            
            doc.add(tablaCliente);
            
            
            
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("REPORTE COTIZACIÓN" + "\n\n");
            doc.add(cli);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            float[] ColumnaTabla = new float[]{12f, 30f, 10f, 20f,20f};
            tabla.setWidths(ColumnaTabla);
            tabla.getDefaultCell().setBorder(0);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cl1 = new PdfPCell(new Phrase("Código", negrita));
            PdfPCell cl2 = new PdfPCell(new Phrase("Nombre del Platillo", negrita));
            PdfPCell cl3 = new PdfPCell(new Phrase("Precio", negrita));
            PdfPCell cl4 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell cl5 = new PdfPCell(new Phrase("Importe", negrita));
            cl1.setBackgroundColor(BaseColor.ORANGE);
            cl2.setBackgroundColor(BaseColor.ORANGE);
            cl3.setBackgroundColor(BaseColor.ORANGE);
            cl4.setBackgroundColor(BaseColor.ORANGE);
            cl5.setBackgroundColor(BaseColor.ORANGE);

            tabla.addCell(cl1);
            tabla.addCell(cl2);
            tabla.addCell(cl3);
            tabla.addCell(cl4);
            tabla.addCell(cl5);
            
            for (int i = 0; i < tablaCotizaciones.getRowCount(); i++) {
                String codigo = tablaCotizaciones.getValueAt(i, 0).toString();
                String nombre = tablaCotizaciones.getValueAt(i, 1).toString();
                String precio = tablaCotizaciones.getValueAt(i, 2).toString();
                String cantidad = tablaCotizaciones.getValueAt(i, 3).toString();
                String importe = tablaCotizaciones.getValueAt(i, 4).toString();
                tabla.addCell(codigo);
                tabla.addCell(nombre);
                tabla.addCell(precio);
                tabla.addCell(cantidad);
                tabla.addCell(importe);
            }
            doc.add(tabla);

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("\nSubtotal:          " + Subtotal.getText() + "\nDescuento " + porcentaje.getText() +"% :          " +descuento.getText() + 
                    "\nTotal a Pagar:          " + TotalCotizacion.getText());
  
            
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            
            // documento.close();
            new rojerusan.RSNotifyFade("Reportes", "Reporte Generado Correctamente", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);


            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {

        }
    }
    
    
    public void pdfVenta(){
        try {
            //  int id = Vdao.IdVenta();
            FileOutputStream archivo;
            File file = new File("src/pdf/Venta" + "" + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Resources/logo.png");

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            String hora = rSLabelHora1.getHora();
            fecha.add("No. Factura: "+ "\nFecha: " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\nHora: " + hora + "\n" );

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{60f, 10f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);

            String ruc = "234234234";
            String nom = "Restaurante calle real";
            String tel = "234234324";
            String dir = "Guatemala";
            String ra = "Comida Tipica";

            Encabezado.addCell("");
            Encabezado.addCell("Ruc: " + ruc + "\nNombre: " + nom + "\nTelefono: " + tel + "\nDireccion: " + dir + "\nRazon: " + ra);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

         
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("DATOS DEL CLIENTE" + "\n\n");
            doc.add(cliente);
            
            PdfPTable tablaCliente = new PdfPTable(1);
            tablaCliente.setWidthPercentage(100);
            float[] ColumnaTablaCliente = new float[]{50f};
            tablaCliente.setWidths(ColumnaTablaCliente);
            tablaCliente.getDefaultCell().setBorder(0);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            

            String nid = nidCotizacion.getText();
            String nombreCliente = Sistema.nombreCotizacion.getText();
            String apellido = Sistema.apellidoCotizacion.getText();
            String direccion = Sistema.dirCotizacion.getText();
            
    
            
            
            tablaCliente.addCell("Nid: " + nid + "\nNombre: " + nombreCliente + "\nApellido: " + apellido + "\nDireccion: " + direccion + "\nTelefono: " + telefono);
            

            
            
            doc.add(tablaCliente);
            
            
            
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Factura: " + "\n\n");
            doc.add(cli);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            float[] ColumnaTabla = new float[]{12f, 30f, 10f, 20f};
            tabla.setWidths(ColumnaTabla);
            tabla.getDefaultCell().setBorder(0);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cl1 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell cl2 = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell cl3 = new PdfPCell(new Phrase("Precio", negrita));
            PdfPCell cl4 = new PdfPCell(new Phrase("Monto", negrita));
            
            cl1.setBackgroundColor(BaseColor.ORANGE);
            cl2.setBackgroundColor(BaseColor.ORANGE);
            cl3.setBackgroundColor(BaseColor.ORANGE);
            cl4.setBackgroundColor(BaseColor.ORANGE);
            

            tabla.addCell(cl1);
            tabla.addCell(cl2);
            tabla.addCell(cl3);
            tabla.addCell(cl4);
            
            
            for (int i = 0; i < pedidos.getRowCount(); i++) {
                String cantidad = pedidos.getValueAt(i, 0).toString();
                String nombre = pedidos.getValueAt(i, 1).toString();
                String precio = pedidos.getValueAt(i, 2).toString();
                String monto = pedidos.getValueAt(i, 3).toString();
                
                tabla.addCell(cantidad);
                tabla.addCell(nombre);
                tabla.addCell(precio);
                tabla.addCell(monto);
            }
            doc.add(tabla);

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total: " + total.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            
            // documento.close();
            new rojerusan.RSNotifyFade("Factura", "factura Generado Correctamente", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);


            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {

        }
    }
    
    
    

    public void GenerarPedidos() {
        try {
            //  int id = Vdao.IdVenta();
            FileOutputStream archivo;
            File file = new File("src/pdf/Pedido1" + "" + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            
            Date date = new Date();
            
            LocalTime horaActual = LocalTime.now();
            fecha.add("No. PEDIDO: " + "0001" + "\n" + "Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n" + "Hora: "+horaActual);

            PdfPTable Encabezado = new PdfPTable(3);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(4);
            float[] ColumnaEncabezado = new float[]{10f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            String ruc = "234234234";
            String nom = "Restaurante calle real";
            String tel = "234234324";
            String dir = "Guatemala";
            String ra = "Tavcode";

            Encabezado.addCell("");
            Encabezado.addCell("Ruc: " + ruc + "\nNombre: " + nom + "\nTelefono: " + tel + "\nDireccion: " + dir + "\nRazon: " + ra);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("                                                             DATOS DEL PEDIDO" + "\n");
            doc.add(cli);
            
            Paragraph mesa = new Paragraph();
            mesa.add(Chunk.NEWLINE);
            mesa.add("No. MESA: "+ "1" + "\n\n");
            doc.add(mesa);

            PdfPTable tabla = new PdfPTable(5);
            tabla.getDefaultCell().setBorder(0);
            tabla.setWidthPercentage(100);
            
            float[] ColumnaTabla = new float[]{12f, 30f, 15f, 15f, 16f};
            tabla.setWidths(ColumnaTabla);
            
            PdfPCell cl1 = new PdfPCell(new Phrase("Código", negrita));
            PdfPCell cl2 = new PdfPCell(new Phrase("Nombre del Platillo", negrita));
            PdfPCell cl3 = new PdfPCell(new Phrase("Precio", negrita));
            PdfPCell cl4 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell cl5 = new PdfPCell(new Phrase("Importe", negrita));
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
            cl1.setBackgroundColor(BaseColor.ORANGE);
            cl2.setBackgroundColor(BaseColor.ORANGE);
            cl3.setBackgroundColor(BaseColor.ORANGE);
            cl4.setBackgroundColor(BaseColor.ORANGE);
            cl5.setBackgroundColor(BaseColor.ORANGE);
            cl1.setBorder(0);
            cl2.setBorder(0);
            cl3.setBorder(0);
            cl4.setBorder(0);
            cl5.setBorder(0);
            tabla.addCell(cl1);
            tabla.addCell(cl2);
            tabla.addCell(cl3);
            tabla.addCell(cl4);
            tabla.addCell(cl5);

            for (int i = 0; i < tablePedidos.getRowCount(); i++) {
                String codigo = tablePedidos.getValueAt(i, 0).toString();
                String nombre = tablePedidos.getValueAt(i, 2).toString();
                String precio = tablePedidos.getValueAt(i, 3).toString();
                String tipo = tablePedidos.getValueAt(i, 4).toString();
                String importe = tablePedidos.getValueAt(i, 5).toString();
                tabla.addCell(codigo);
                tabla.addCell(nombre);
                tabla.addCell(precio);
                tabla.addCell(tipo);
                tabla.addCell(importe);
            }
            doc.add(tabla);

            // documento.close();
            new rojerusan.RSNotifyFade("Reportes", "Reporte Generado Correctamente", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {

        }
    }
}
