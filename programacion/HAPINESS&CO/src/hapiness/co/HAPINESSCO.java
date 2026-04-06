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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HAPINESSCO {

    private static HashMap<String, usuarios> listaUsuarios = new HashMap<>();
    private static HashMap<Integer, Evento> listaEventos = new HashMap<>();
    private static ArrayList<Favorito> listaFavoritos = new ArrayList<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    añadirUsuario();
                    break;
                case 2:
                    eliminarUsuario();
                    break;
                case 3:
                    añadirEvento();
                    break;
                case 4:
                    eliminarEvento();
                    break;
                case 5:
                    aniadirGaleria();
                    break;
                case 6:
                    eliminarGaleria();
                    break;
                case 7:
                    añadirFavorito();
                    break;
                case 8:
                    eliminarFavorito();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema. Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion no valida. Ingrese un numero entre 1 y 9.");
            }

            System.out.println();

        } while (opcion != 9);

    }

    private static void mostrarMenu() {
        System.out.println("================================================");
        System.out.println("       SISTEMA DE GESTION DE EVENTOS            ");
        System.out.println("================================================");
        System.out.println("  1. Añadir usuario");
        System.out.println("  2. Eliminar usuario");
        System.out.println("  3. Añadir evento");
        System.out.println("  4. Eliminar evento");
        System.out.println("  5. Añadir galeria a un evento");
        System.out.println("  6. Eliminar galeria de un evento");
        System.out.println("  7. Añadir favorito");
        System.out.println("  8. Eliminar favorito");
        System.out.println("  9. Salir");
        System.out.println("================================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static int leerEntero(String mensaje) {
        int valor;
        System.out.print(mensaje);
        valor = teclado.nextInt();
        teclado.nextLine();
        return valor;
    }

    private static void mostrarEventos() {
        if (listaEventos.size() == 0) {
            System.out.println("No hay eventos registrados.");
        } else {
            System.out.println("--- LISTA DE EVENTOS ---");
            for (int i = 0; i < listaEventos.size(); i++) {
                Evento evento = (Evento) listaEventos.values().toArray()[i];
                System.out.println("ID: " + evento.getId()
                        + " | Titulo: " + evento.getTitulo()
                        + " | Fecha: " + evento.getFecha()
                        + " | Galerias: " + evento.getGalerias().size());
            }
            System.out.println("------------------------");
        }
    }

    private static void mostrarUsuarios() {
        if (listaUsuarios.size() == 0) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("--- LISTA DE USUARIOS ---");
            for (int i = 0; i < listaUsuarios.size(); i++) {
                usuarios u = (usuarios) listaUsuarios.values().toArray()[i];
                System.out.println("  Nombre: " + u.getNombre() + " | Email: " + u.getEmail());
            }
            System.out.println("-------------------------");
        }
    }

    private static void añadirUsuario() {
        System.out.println("=== ANIADIR USUARIO ===");

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Email: ");
        String email = teclado.nextLine();

        System.out.print("Password: ");
        String password = teclado.nextLine();

        if (listaUsuarios.containsKey(email)) {
            System.out.println("El usuario ya existe.");
        } else {
            usuarios nuevoUsuario = new usuarios(nombre, email, password);
            listaUsuarios.put(email, nuevoUsuario);
            System.out.println("Usuario creado correctamente.");
        }
    }

    private static void eliminarUsuario() {
        System.out.println("=== ELIMINAR USUARIO ===");

        System.out.print("Email del usuario a eliminar: ");
        String email = teclado.nextLine();

        if (!listaUsuarios.containsKey(email)) {
            System.out.println("El usuario no existe.");
        } else {
            listaUsuarios.remove(email);
            System.out.println("Usuario eliminado correctamente.");
        }
    }

    private static void añadirEvento() {

        System.out.println("=== ANIADIR EVENTO ===");

        System.out.print("Titulo: ");
        String titulo = teclado.nextLine();

        System.out.print("Fecha ( YYYY/MM/DD): ");
        String fecha = teclado.nextLine();

        System.out.print("Ubicacion: ");
        String ubicacion = teclado.nextLine();

        System.out.print("Descripcion: ");
        String descripcion = teclado.nextLine();

        Evento nuevoEvento = new Evento(fecha, titulo, ubicacion, descripcion);

        listaEventos.put(nuevoEvento.getId(), nuevoEvento);
        System.out.println("Evento creado correctamente con ID: " + nuevoEvento.getId());
    }

    private static void eliminarEvento() {
        int idEvento;
        System.out.println("=== ELIMINAR EVENTO ===");
        mostrarEventos();

        if (listaEventos.size() == 0) {
            System.out.println("No hay eventos para eliminar.");
        } else {
            idEvento = leerEntero("ID del evento a eliminar: ");
            if (!listaEventos.containsKey(idEvento)) {
                System.out.println("El evento no existe.");
            } else {
                listaEventos.remove(idEvento);
                System.out.println("Evento eliminado correctamente.");
            }
        }
    }

    private static void aniadirGaleria() {
        System.out.println("=== ANIADIR GALERIA ===");
        mostrarEventos();

        if (listaEventos.size() == 0) {
            System.out.println("No hay eventos para agregar galerias.");
        } else {
            int idEvento = leerEntero("ID del evento al que pertenece la galeria: ");
            if (!listaEventos.containsKey(idEvento)) {
                System.out.println("El evento no existe.");
            } else {
                Evento evento = listaEventos.get(idEvento);
                System.out.print("Titulo de la galeria: ");
                String titulo = teclado.nextLine();
                Galeria nuevaGaleria = new Galeria(titulo, idEvento);
                evento.getGalerias().add(nuevaGaleria);
                System.out.println("Galeria creada correctamente con ID: " + nuevaGaleria.getId());
            }
        }
    }

    private static void eliminarGaleria() {
        System.out.println("=== ELIMINAR GALERIA ===");
        mostrarEventos();
        int idEvento, idGaleria;
        if (listaEventos.size() == 0) {
            System.out.println("No hay eventos registrados.");
        } else {
            idEvento = leerEntero("ID del evento: ");
            if (!listaEventos.containsKey(idEvento)) {
                System.out.println("El evento no existe.");
            } else {
                Evento evento = listaEventos.get(idEvento);
                ArrayList<Galeria> listaGalerias = evento.getGalerias();

                if (listaGalerias.size() == 0) {
                    System.out.println("Este evento no tiene galerias registradas.");
                } else {
                    System.out.println("--- GALERIAS DEL EVENTO '" + evento.getTitulo() + "' ---");
                    for (int i = 0; i < listaGalerias.size(); i++) {
                        Galeria g = listaGalerias.get(i);
                        System.out.println("  ID: " + g.getId() + " | Titulo: " + g.getTitulo());
                    }
                    System.out.println("--------------------------------------------------");

                    idGaleria = leerEntero("ID de la galeria a eliminar: ");
                    Galeria galeriaAEliminar = null;

                    for (int i = 0; i < listaGalerias.size(); i++) {
                        if (listaGalerias.get(i).getId() == idGaleria) {
                            galeriaAEliminar = listaGalerias.get(i);
                            break;
                        }
                    }

                    if (galeriaAEliminar == null) {
                        System.out.println("La galeria no existe en este evento.");
                    } else {
                        listaGalerias.remove(galeriaAEliminar);
                        System.out.println("Galeria eliminada correctamente.");
                    }
                }
            }
        }
    }
    private static void añadirFavorito() {
        System.out.println("=== ANIADIR FAVORITO ===");
        mostrarUsuarios();
        mostrarEventos();

        if (listaUsuarios.size() == 0 || listaEventos.size() == 0) {
            System.out.println("Se necesitan usuarios y eventos registrados para crear favoritos.");
        } else {
            System.out.print("Email del usuario: ");
            String email = teclado.nextLine();
            int idEvento = leerEntero("ID del evento: ");

            if (!listaUsuarios.containsKey(email)) {
                System.out.println("El usuario no existe.");
            } else if (!listaEventos.containsKey(idEvento)) {
                System.out.println("El evento no existe.");
            } else {
                boolean existe = false;
                for (int i = 0; i < listaFavoritos.size(); i++) {
                    Favorito f = listaFavoritos.get(i);
                    if (f.getCorreoUsuario().equals(email) && f.getIdEvento() == idEvento) {
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    System.out.println("Este favorito ya existe.");
                } else {
                    Favorito nuevoFavorito = new Favorito(email, idEvento);
                    listaFavoritos.add(nuevoFavorito);
                    System.out.println("Favorito creado correctamente.");
                }
            }
        }
    }
     private static void eliminarFavorito() {
        System.out.println("=== ELIMINAR FAVORITO ===");

        if (listaFavoritos.size() == 0) {
            System.out.println("No hay favoritos registrados.");
        } else {
            System.out.println("--- LISTA DE FAVORITOS ---");
            for (int i = 0; i < listaFavoritos.size(); i++) {
                Favorito f = listaFavoritos.get(i);
                System.out.println("  Usuario: " + f.getCorreoUsuario()
                        + " | Evento ID: " + f.getIdEvento());
            }
            System.out.println("--------------------------");

            System.out.print("Email del usuario: ");
            String email = teclado.nextLine();
            int idEvento = leerEntero("ID del evento: ");

            Favorito favoritoAEliminar = null;
            for (int i = 0; i < listaFavoritos.size(); i++) {
                Favorito f = listaFavoritos.get(i);
                if (f.getCorreoUsuario().equals(email) && f.getIdEvento() == idEvento) {
                    favoritoAEliminar = f;
                    break;
                }
            }

            if (favoritoAEliminar == null) {
                System.out.println("El favorito no existe.");
            } else {
                listaFavoritos.remove(favoritoAEliminar);
                System.out.println("Favorito eliminado correctamente.");
            }
        }
    }
}
