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
        this.titulo   = titulo;
        this.idEvento = idEvento;
    }
}