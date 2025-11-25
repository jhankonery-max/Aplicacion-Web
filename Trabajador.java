package com.plataforma.model;

import java.util.ArrayList;
import java.util.List;

public class Trabajador extends Usuario implements Calificable {
    private String descripcion;
    private List<Habilidad> habilidades;
    private List<Postulacion> postulaciones;
    private List<Calificacion> calificacionesRecibidas;
    private double calificacionPromedio;

    public Trabajador() {
        super();
        this.tipo = "TRABAJADOR";
        this.habilidades = new ArrayList<>();
        this.postulaciones = new ArrayList<>();
        this.calificacionesRecibidas = new ArrayList<>();
    }

    public Trabajador(String email, String password, String nombreCompleto, String telefono, String descripcion) {
        super(email, password, nombreCompleto, telefono, "TRABAJADOR");
        this.descripcion = descripcion;
        this.habilidades = new ArrayList<>();
        this.postulaciones = new ArrayList<>();
        this.calificacionesRecibidas = new ArrayList<>();
    }

    // Getters y Setters específicos
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Habilidad> getHabilidades() { return habilidades; }
    public void setHabilidades(List<Habilidad> habilidades) { this.habilidades = habilidades; }

    public List<Postulacion> getPostulaciones() { return postulaciones; }
    public void setPostulaciones(List<Postulacion> postulaciones) { this.postulaciones = postulaciones; }

    public List<Calificacion> getCalificacionesRecibidas() { return calificacionesRecibidas; }
    public void setCalificacionesRecibidas(List<Calificacion> calificacionesRecibidas) { this.calificacionesRecibidas = calificacionesRecibidas; }

    public double getCalificacionPromedio() { return calificacionPromedio; }
    public void setCalificacionPromedio(double calificacionPromedio) { this.calificacionPromedio = calificacionPromedio; }

    // Implementación de Calificable
    @Override
    public double calcularPromedioCalificaciones() {
        if (calificacionesRecibidas == null || calificacionesRecibidas.isEmpty()) return 0.0;
        double suma = calificacionesRecibidas.stream().mapToInt(Calificacion::getPuntuacion).sum();
        double promedio = Math.round((suma / calificacionesRecibidas.size()) * 100.0) / 100.0;
        this.calificacionPromedio = promedio;
        return promedio;
    }

    @Override
    public int obtenerTotalCalificaciones() {
        return calificacionesRecibidas != null ? calificacionesRecibidas.size() : 0;
    }

    @Override
    public void agregarCalificacion(Calificacion calificacion) {
        if (calificacionesRecibidas == null) calificacionesRecibidas = new ArrayList<>();
        calificacionesRecibidas.add(calificacion);
        calcularPromedioCalificaciones();
    }

    // Métodos específicos
    public void agregarHabilidad(Habilidad habilidad) {
        if (habilidades == null) habilidades = new ArrayList<>();
        if (!habilidades.contains(habilidad)) habilidades.add(habilidad);
    }

    public Postulacion postularServicio(Servicio servicio, double precioPropuesto, String mensaje) {
        Postulacion postulacion = new Postulacion(precioPropuesto, mensaje, this, servicio);
        postulaciones.add(postulacion);
        return postulacion;
    }

    @Override
    public String obtenerInformacionEspecifica() {
        return String.format("Trabajador - Habilidades: %d, Calificación: %.2f", 
                habilidades.size(), calificacionPromedio);
    }
}