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
public class Galeria {

    private static int contadorId = 0;

    private int id;

    private String titulo;

    private int idEvento;

    public Galeria(String titulo, int idEvento) {
        this.id = contadorId; // Asignamos el ID actual al objeto
        contadorId++;  // Incrementamos el contador para el siguiente objeto
        this.titulo = titulo;
        this.idEvento = idEvento;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Galeria.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Galeria [id=" + id + ", titulo=" + titulo + ", idEvento=" + idEvento + "]";
    }

}
