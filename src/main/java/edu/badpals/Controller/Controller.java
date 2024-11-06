package edu.badpals.Controller;

import edu.badpals.Model.Conexion;
import edu.badpals.Model.Pelicula;
import edu.badpals.View.Input;
import edu.badpals.View.Print;

public class Controller {

    public static void logicaMenu() {
        try {
            do {
                Print.showMenu();
                Integer opcion = Input.askMenuOption();
                switch (opcion) {
                    case 1:
                        leerPelis();
                        break;
                    case 2:
                        addPeli();
                        break;
                    case 3:
                        delPeli();
                        break;
                    case 4:
                        modifPeli();
                        break;
                    case 5:
                        salir();
                        break;
                }
            } while (true);
        } catch (Exception e) {
            logicaMenu();
        }
    }

    public static void leerPelis() {
        Print.showTextoPeliculas();
        Print.showPeliculas();
    }

    public static void addPeli() {
        try {
            Pelicula peli = new Pelicula(Input.askPeliculaId(), Input.askPeliculaTitle(), Input.askPeliculaProtagonist(),
                    Input.askPeliculaGenre(), Input.askPeliculaGuion(), Input.askPeliculaAvailable());
            Conexion.insertPelicula(peli);
            Print.showPeliculaCreada();
        } catch (Exception e) {
            Print.showError();
        }
    }

    public static void delPeli() {
        Integer idDel = Input.askPeliculaId();
        Conexion.deletePelicula(idDel);
        Print.showPeliculaEliminada();
    }

    public static void modifPeli() {
        try {
            Integer idModif = Input.askPeliculaId();
            Pelicula peliModif = new Pelicula(idModif, Input.askPeliculaTitle(), Input.askPeliculaProtagonist(),
                    Input.askPeliculaGenre(), Input.askPeliculaGuion(), Input.askPeliculaAvailable());
            Conexion.modifPelicula(idModif, peliModif);
            Print.showPeliculaModificada();
        } catch (Exception e) {
            Print.showError();
        }
    }

    public static void salir() {
        if (Input.askSalir()) {
            System.exit(0);
        }
    }
}
