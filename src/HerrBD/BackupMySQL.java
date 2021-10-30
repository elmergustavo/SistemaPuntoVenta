package HerrBD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rojeru San
 */
public class BackupMySQL {

    private String obtenerFecha() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String Fehca = dia + "-" + (mes + 1) + "-" + año;
        return Fehca;
    }

    int BUFFER = 10485760;

    public void exportDB(String nombreDB) {

        //nombre de usuario de la base de datos
        String mysqluser = "root";
        //password del usuario
        String mysqlpassword = "hacker.net";
        //nombre de la base de datos
        String mysqldb = "punto_de_ventas";
        //ruta donde se guardará el backup
        String path = "Respaldos/" + nombreDB + "_" + obtenerFecha() + ".sql";
        File existe = new File(path);
        if (existe.exists()) {
            if (JOptionPane.showConfirmDialog(null, "YA EXISTE UN RESPALDO CON ESE NOMBRE\n¿DESEA REEMPLAZARLO?", "RESTAURAR RESPALDO", JOptionPane.YES_NO_OPTION, 0,
                    new ImageIcon(getClass().getResource("/imagenes/inicio/msj_pregunta.png"))) == JOptionPane.YES_OPTION) {
                RealizaBackup(path, mysqluser, mysqlpassword, mysqldb);
            }
        } else {
            RealizaBackup(path, mysqluser, mysqlpassword, mysqldb);
        }
    }

    public void RealizaBackup(String path, String mysqluser, String mysqlpassword, String mysqldb) {
       // new CargandoBackup(new principal.Principal(), true).setVisible(true);
        String dumpCommand = "mysqldump.exe --hex-blob -u" + mysqluser + " -p" + mysqlpassword + " --skip-comments --skip-triggers " + mysqldb;
        
        FileWriter fw = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            File backupFile = new File(path);
            fw = new FileWriter(backupFile);
            System.out.println(dumpCommand);
            Process child = runtime.exec(dumpCommand);
            BufferedReader br;
            try (InputStreamReader irs = new InputStreamReader(child.getInputStream())) {
                br = new BufferedReader(irs);
                String line;
                while ((line = br.readLine()) != null) {
                    fw.write(line + "\n");
                }   fw.close();
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(BackupMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(BackupMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
