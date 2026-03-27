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
import java.util.ArrayList; // Importamos ArrayList para la lista de galerías

public class Evento {

    private static int contadorId = 0;

    private int id;

    private String fecha;

    private String titulo;

    private String ubicacion;

    private String descripcion;

    private ArrayList<Galeria> galerias;

    public Evento(String fecha, String titulo, String ubicacion, String descripcion) {
        this.id = contadorId; // Asignamos el ID actual
        contadorId++;   // Preparamos el ID para el siguiente evento
        this.fecha = fecha;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;

        this.galerias = new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // GETTERS
    // -------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Galeria> getGalerias() {
        return galerias;
    }

    // -------------------------------------------------------------------------
    // SETTERS
    // -------------------------------------------------------------------------
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setGalerias(ArrayList<Galeria> galerias) {
        this.galerias = galerias;
    }

}
