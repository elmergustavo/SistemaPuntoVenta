/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria;

import java.awt.event.KeyEvent;

/**
 *
 * @author elmer
 */
public class TextFieldEvent {
    public void textKeyPress(KeyEvent evt){
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_BACK_SPACE) && 
                (car != (char) KeyEvent.VK_SPACE )){
            evt.consume();
        }
    }
    
    public void NumberKeyPress(KeyEvent evt){
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)){
            evt.consume();
        }
    }
}
