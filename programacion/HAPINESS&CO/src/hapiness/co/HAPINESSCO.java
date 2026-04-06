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
                    aniadirEvento();
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
                    aniadirFavorito();
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
}
