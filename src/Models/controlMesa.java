/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author MATXHUN
 */
public class controlMesa {

    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ImageIcon icono;

    public controlMesa() {
        MesaSQL mesaSQL = new MesaSQL();
        for (int id = 1; id <= 10; id++) {
            mesas.add(mesaSQL.obtenerMesa(id));
        }
        for (int id = 0; id < 10; id++) {
           System.out.println("ID " + mesas.get(id).getNumero() + " ESTADO " + mesas.get(id).getEstado());
        }
    }
    
    public ImageIcon cambiarEstado(int id) {
        MesaSQL consulta = new MesaSQL();
        id = id - 1;
        if (mesas.get(id).getEstado().charAt(0) == 'D') {
            consulta.marcarOcupado(id+1);
            return ocupado();
        }
        else
        {
            consulta.marcarDisponible(id+1  );
            return disponible();
        }
    }
    public ImageIcon cambiarEstadoCobrado(int id) {
        MesaSQL consulta = new MesaSQL();
        consulta.marcarCobrado(id);
        return cobrado();
    }
    

    public ImageIcon obtenerEstado(int id) {
        id = id - 1;
        if (mesas.get(id).getEstado().charAt(0) == 'D') {
            System.out.println(mesas.get(id).getEstado());
            return disponible();
        } else if (mesas.get(id).getEstado().charAt(0) == 'C') {
            return cobrado();
        } else {
            System.out.println(mesas.get(id).getEstado());
            return ocupado();
        }
    }

    private ImageIcon disponible() {
        icono = new ImageIcon(getClass().getResource("/Resources/mesaDisponible.png"));
        Image imgEscalada = icono.getImage().getScaledInstance(129, 115, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imgEscalada);
        return icono;
    }

    private ImageIcon ocupado() {
        icono = new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png"));
        Image imgEscalada = icono.getImage().getScaledInstance(129, 115, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imgEscalada);
        return icono;
    }

    private ImageIcon cobrado() {
        icono = new ImageIcon(getClass().getResource("/Resources/mesaCobrada.png"));
        Image imgEscalada = icono.getImage().getScaledInstance(129, 115, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imgEscalada);
        return icono;
    }
}
