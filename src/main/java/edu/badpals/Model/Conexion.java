package edu.badpals.Model;

import edu.badpals.View.Print;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexion {

    private static Connection connectDatabase() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/videoclub";
            return DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Pelicula> getPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            Connection conexion = connectDatabase();
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM peliculas");
            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setId(rs.getInt("id"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setProtagonista(rs.getString("actor_protagonista"));
                String generoString = rs.getString("tematica");
                pelicula.setGenero(Genero.valueOf(generoString.toUpperCase().replace(" ", "_")));
                pelicula.setGuion(rs.getString("guion"));
                pelicula.setDisponible(rs.getBoolean("disponible"));
                peliculas.add(pelicula);
            }
            rs.close();
            s.close();
            conexion.close();
        } catch (SQLException e) {
            Print.showError();
        }
        return peliculas;
    }

    public static boolean insertPelicula(Pelicula pelicula) {
        try {
            Connection conexion = connectDatabase();
            PreparedStatement s = conexion.prepareStatement("INSERT INTO peliculas (id, titulo, actor_protagonista, tematica, guion, disponible)  " +
                    " VALUES (?,?,?,?,?,?)");
            s.setInt(1, pelicula.getId());
            s.setString(2, pelicula.getTitulo());
            s.setString(3, pelicula.getProtagonista());
            s.setString(4, pelicula.getGenero().toString());
            s.setString(5, pelicula.getGuion());
            s.setBoolean(6, pelicula.isDisponible());
            s.executeUpdate();
            conexion.close();
            return true;
        } catch (Exception e) {
            Print.showError();
            return false;
        }
    }

    public static void modifPelicula(Integer id, Pelicula pelicula) {
        try {
            Connection conexion = connectDatabase();
            PreparedStatement s = conexion.prepareStatement("UPDATE peliculas SET titulo = ?, actor_protagonista = ?, tematica = ?, guion = ?, disponible = ? WHERE id = ?");
            s.setString(1, pelicula.getTitulo());
            s.setString(2, pelicula.getProtagonista());
            s.setString(3, pelicula.getGenero().toString());
            s.setString(4, pelicula.getGuion());
            s.setBoolean(5, pelicula.isDisponible());
            s.setInt(6, id);
            s.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            Print.showError();
        }
    }

    public static void deletePelicula(Integer id) {
        try {
            Connection conexion = connectDatabase();
            PreparedStatement s = conexion.prepareStatement("DELETE FROM peliculas WHERE id = ?");
            s.setInt(1, id);
            s.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            Print.showError();
        }
    }
}
