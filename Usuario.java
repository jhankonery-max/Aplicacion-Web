package com.plataforma.model;

import java.time.LocalDateTime;

public abstract class Usuario {
    protected int id;
    protected String email;
    protected String password;
    protected String nombreCompleto;
    protected String telefono;
    protected boolean verificado;
    protected LocalDateTime fechaRegistro;
    protected String tipo; // CLIENTE, TRABAJADOR, ADMINISTRADOR

    // Constructores
    public Usuario() {
        this.fechaRegistro = LocalDateTime.now();
        this.verificado = false;
    }

    public Usuario(String email, String password, String nombreCompleto, String telefono, String tipo) {
        this();
        this.email = email;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public boolean isVerificado() { return verificado; }
    public void setVerificado(boolean verificado) { this.verificado = verificado; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    // Método abstracto
    public abstract String obtenerInformacionEspecifica();

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", tipo='" + tipo + '\'' +
                ", verificado=" + verificado +
                '}';
    }
}