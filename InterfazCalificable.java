package com.plataforma.model;

public interface Calificable {
    double calcularPromedioCalificaciones();
    int obtenerTotalCalificaciones();
    void agregarCalificacion(Calificacion calificacion);
}