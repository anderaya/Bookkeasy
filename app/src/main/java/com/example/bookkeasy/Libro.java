package com.example.bookkeasy;

public class Libro {

    //se utiliza para crear un libro

    private String titulo;
    private String autor;
    private String estadodellibro;
    private String estadofisico;
    private String idioma;
    private String ediccion;
    private String editorial;
    private String año;
    private String usuario;
    private String cliente;
    private String longitud;
    private String latitud;
    public Libro() {
    }





    public Libro(String titulo, String autor, String estadodellibro, String estadofisico, String idioma, String ediccion, String editorial, String año, String usuario, String cliente,String longitud,String latitud) {
        this.titulo = titulo;
        this.autor = autor;
        this.estadodellibro = estadodellibro;
        this.estadofisico = estadofisico;
        this.idioma = idioma;
        this.ediccion = ediccion;
        this.editorial = editorial;
        this.año = año;
        this.usuario = usuario;
        this.cliente = cliente;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEstadodellibro(String estadodellibro) {
        this.estadodellibro = estadodellibro;
    }

    public void setEstadofisico(String estadofisico) {
        this.estadofisico = estadofisico;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setEdiccion(String ediccion) {
        this.ediccion = ediccion;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEstadodellibro() {
        return estadodellibro;
    }

    public String getEstadofisico() {
        return estadofisico;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getEdiccion() {
        return ediccion;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAño() {
        return año;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCliente() {
        return cliente;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
}
