package com.example.bookkeasy;

public class Usuario {

    public Usuario() {

    }

    public Usuario(String usuario, String correo, String direccion,String tipoUser) {
        this.usuario = usuario;
        this.correo = correo;
        this.direccion = direccion;
    }

    private String usuario;
    private String contraseña;
    private String correo;
    private String direccion;
    private String tipoUser;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }


}
