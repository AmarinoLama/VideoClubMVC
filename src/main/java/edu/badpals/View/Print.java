package edu.badpals.View;

import edu.badpals.Controller.Controller;
import edu.badpals.Model.Conexion;
import edu.badpals.Model.Pelicula;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Print {

    public static void showMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("\n============= Menu ==============\n");
        menu.append("1. Mostrar todas las peliculas\n");
        menu.append("2. Añadir pelicula\n");
        menu.append("3. Eliminar pelicula\n");
        menu.append("4. Modificar pelicula\n");
        menu.append("5. Salir\n");
        System.out.println(menu);
    }

    public static void showPreguntarMenu() {
        System.out.println("¿Que quieres hacer?");
    }

    public static void showTextoPeliculas() {
        System.out.println("============= Peliculas ==============");
    }

    public static void showPeliculas() {
        List<Pelicula> peliculas = Conexion.getPeliculas();
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public static void showPreguntarId() {
        System.out.println("Introduce el id de la pelicula:");
    }

    public static void showPreguntarTitulo() {
        System.out.println("Introduce el titulo de la pelicula:");
    }

    public static void showPreguntarProtagonista() {
        System.out.println("Introduce el protagonista de la pelicula:");
    }

    public static void showPreguntarGenero() {
        System.out.println("Introduce el genero de la pelicula:");
    }

    public static void showPreguntarGuion() {
        System.out.println("Introduce el guion de la pelicula:");
    }

    public static void showPreguntarDisponible() {
        System.out.println("Introduce si la pelicula esta disponible (s/N):");
    }

    public static void showPeliculaCreada() {
        System.out.println("Pelicula creada con exito");
    }

    public static void showPeliculaModificada() {
        System.out.println("Pelicula modificada con exito");
    }

    public static void showPeliculaEliminada() {
        System.out.println("Pelicula eliminada con exito");
    }

    public static void showExit() {
        System.out.println("¿Seguro que quieres salir? (s/N)");
    }

    public static void showError() {
        System.out.println("No se ha podido realizar la operacion");
    }
}
