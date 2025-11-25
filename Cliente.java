package com.plataforma.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario implements Calificable {
    private String direccion;
    private String descripcionNecesidades;
    private List<Servicio> serviciosPublicados;
    private List<Calificacion> calificacionesRecibidas;

    public Cliente() {
        super();
        this.tipo = "CLIENTE";
        this.serviciosPublicados = new ArrayList<>();
        this.calificacionesRecibidas = new ArrayList<>();
    }

    public Cliente(String email, String password, String nombreCompleto, String telefono) {
        super(email, password, nombreCompleto, telefono, "CLIENTE");
        this.serviciosPublicados = new ArrayList<>();
        this.calificacionesRecibidas = new ArrayList<>();
    }

    // Getters y Setters específicos
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getDescripcionNecesidades() { return descripcionNecesidades; }
    public void setDescripcionNecesidades(String descripcionNecesidades) { this.descripcionNecesidades = descripcionNecesidades; }

    public List<Servicio> getServiciosPublicados() { return serviciosPublicados; }
    public void setServiciosPublicados(List<Servicio> serviciosPublicados) { this.serviciosPublicados = serviciosPublicados; }

    public List<Calificacion> getCalificacionesRecibidas() { return calificacionesRecibidas; }
    public void setCalificacionesRecibidas(List<Calificacion> calificacionesRecibidas) { this.calificacionesRecibidas = calificacionesRecibidas; }

    // Implementación de Calificable
    @Override
    public double calcularPromedioCalificaciones() {
        if (calificacionesRecibidas == null || calificacionesRecibidas.isEmpty()) return 0.0;
        double suma = calificacionesRecibidas.stream().mapToInt(Calificacion::getPuntuacion).sum();
        return Math.round((suma / calificacionesRecibidas.size()) * 100.0) / 100.0;
    }

    @Override
    public int obtenerTotalCalificaciones() {
        return calificacionesRecibidas != null ? calificacionesRecibidas.size() : 0;
    }

    @Override
    public void agregarCalificacion(Calificacion calificacion) {
        if (calificacionesRecibidas == null) calificacionesRecibidas = new ArrayList<>();
        calificacionesRecibidas.add(calificacion);
    }

    // Métodos específicos
    public Servicio crearServicio(String titulo, String descripcion, String direccion, double precioBase) {
        Servicio servicio = new Servicio(titulo, descripcion, direccion, precioBase, this);
        serviciosPublicados.add(servicio);
        return servicio;
    }

    @Override
    public String obtenerInformacionEspecifica() {
        return String.format("Cliente - Servicios: %d, Calificación: %.2f", 
                serviciosPublicados.size(), calcularPromedioCalificaciones());
    }
}