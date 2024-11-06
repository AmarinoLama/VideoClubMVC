package edu.badpals.View;

import edu.badpals.Model.Genero;

import java.util.Scanner;

public class Input {

    static Scanner sc = new Scanner(System.in);

    public static Integer askMenuOption() {
        Print.showPreguntarMenu();
        String opcion = sc.nextLine();
        return Integer.parseInt(opcion);
    }

    public static Integer askPeliculaId() {
        Print.showPreguntarId();
        return Integer.parseInt(sc.nextLine());
    }

    public static String askPeliculaTitle() {
        Print.showPreguntarTitulo();
        return sc.nextLine();
    }

    public static String askPeliculaProtagonist() {
        Print.showPreguntarProtagonista();
        return sc.nextLine();
    }

    public static Genero askPeliculaGenre() {
        Print.showPreguntarGenero();
        return Genero.valueOf(sc.nextLine().toUpperCase().replace(" ", "_"));
    }

    public static String askPeliculaGuion() {
        Print.showPreguntarGuion();
        return sc.nextLine();
    }

    public static Boolean askPeliculaAvailable() {
        Print.showPreguntarDisponible();
        String available = sc.nextLine();
        return available.equals("s");
    }

    public static boolean askSalir() {
        Print.showExit();
        String salir = sc.nextLine();
        return salir.equals("s");
    }
}
