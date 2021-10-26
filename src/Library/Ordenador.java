/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Gustavo
 */
public class Ordenador {

    public static String getSerialNumber(char drive) throws Exception {
        String line = null;
        String serial = null;
        Process process = Runtime.getRuntime().exec("cmd /c vol " + drive + ":");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        while ((line = in.readLine()) != null) {
            String[] strings = line.split(" ");
            serial = strings[strings.length - 1];
        }
        in.close();
        return serial;
    }
}
