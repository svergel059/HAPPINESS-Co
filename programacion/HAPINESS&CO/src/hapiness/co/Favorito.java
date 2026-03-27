/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hapiness.co;

/**
 *
 * @author ALUMNOS-FP
 */
public class Favorito {

    private String correoUsuario;

    private int idEvento;

    public Favorito(String correoUsuario, int idEvento) {
        this.correoUsuario = correoUsuario; // Guardamos el email del usuario
        this.idEvento = idEvento;      // Guardamos el ID del evento
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String toString() {
        return "Favorito [correoUsuario=" + correoUsuario + ", idEvento=" + idEvento + "]";
    }
}
