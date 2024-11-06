package edu.badpals.Model;

public class Pelicula {

    private int id = 0;
    private String titulo = "";
    private String protagonista = "";
    private Genero genero;
    private String guion = "";
    private boolean disponible;

    public Pelicula() {
    }

    public Pelicula(int id, String titulo, String protagonista, Genero genero, String guion, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.protagonista = protagonista;
        this.genero = genero;
        this.guion = guion;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(String protagonista) {
        this.protagonista = protagonista;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getGuion() {
        return guion;
    }

    public void setGuion(String guion) {
        this.guion = guion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", protagonista='" + protagonista + '\'' +
                ", genero=" + genero +
                ", guion='" + guion + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
