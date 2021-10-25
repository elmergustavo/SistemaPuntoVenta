/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Ordenador;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Tordenadores {

    public int IdOrdenador;
    public String Ordenador;
    public boolean Is_active;
    public String Usuario;
    public Date InFecha;
    public Date OutFehca;
    public int IdUsuario;

    public Tordenadores() {
    }

    public int getIdOrdenador() {
        return IdOrdenador;
    }

    public void setIdOrdenador(int IdOrdenador) {
        this.IdOrdenador = IdOrdenador;
    }

    public String getOrdenador() {
        return Ordenador;
    }

    public void setOrdenador(String Ordenador) {
        this.Ordenador = Ordenador;
    }

    public boolean isIs_active() {
        return Is_active;
    }

    public void setIs_active(boolean Is_active) {
        this.Is_active = Is_active;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public Date getInFecha() {
        return InFecha;
    }

    public void setInFecha(Date InFecha) {
        this.InFecha = InFecha;
    }

    public Date getOutFehca() {
        return OutFehca;
    }

    public void setOutFehca(Date OutFehca) {
        this.OutFehca = OutFehca;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
}
