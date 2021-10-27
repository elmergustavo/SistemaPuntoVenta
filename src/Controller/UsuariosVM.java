/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Library.Uploadimage;
import Models.Usuarios.TUsuarios;
import javax.swing.JLabel;

/**
 *
 * @author Gustavo
 */
public class UsuariosVM {

    private static TUsuarios _dataUsuario;
    private static JLabel _nombrePerfil;
    private static JLabel _picturePerfil;
    private Uploadimage _uploadimage = new Uploadimage();

    public UsuariosVM(TUsuarios dataUsuario, Object[] perfil) {
        _dataUsuario = dataUsuario;
        _nombrePerfil = (JLabel) perfil[0];
        _picturePerfil = (JLabel) perfil[1];
        Perfil();
    }

    private void Perfil() {
        _nombrePerfil.setText(_dataUsuario.getUsuario());
        if (null != _dataUsuario.getImagen()) {
            _uploadimage.byteImage(_picturePerfil, _dataUsuario.getImagen());
        }
    }
}
