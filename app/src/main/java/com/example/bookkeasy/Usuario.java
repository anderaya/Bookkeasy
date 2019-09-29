package com.example.bookkeasy;

public class Usuario {

    public Usuario() {

    }

    public Usuario(String usuario, String correo,String longitud,String latitud,String tipoUser) {
        this.usuario = usuario;
        this.correo = correo;
        this.longitud=longitud;
        this.latitud=latitud;
        this.tipoUser=tipoUser;

    }

    private String usuario;
    private String contraseña;
    private String correo;;

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    private String tipoUser;

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

    private String longitud;
    private String latitud;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCorreo() {
        return correo;
    }




}
