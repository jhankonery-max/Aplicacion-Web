package com.plataforma.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private int id;
    private String titulo;
    private String descripcion;
    private String direccion;
    private double precioBase;
    private EstadoServicio estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaFinalizacion;
    private Cliente cliente;
    private Trabajador trabajadorAsignado;
    private List<Postulacion> postulaciones;
    private Calificacion calificacionCliente;
    private Calificacion calificacionTrabajador;
    private Pago pago;

    public Servicio() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoServicio.ABIERTO;
        this.postulaciones = new ArrayList<>();
    }

    public Servicio(String titulo, String descripcion, String direccion, double precioBase, Cliente cliente) {
        this();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.precioBase = precioBase;
        this.cliente = cliente;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public EstadoServicio getEstado() { return estado; }
    public void setEstado(EstadoServicio estado) { this.estado = estado; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaFinalizacion() { return fechaFinalizacion; }
    public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) { this.fechaFinalizacion = fechaFinalizacion; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Trabajador getTrabajadorAsignado() { return trabajadorAsignado; }
    public void setTrabajadorAsignado(Trabajador trabajadorAsignado) { this.trabajadorAsignado = trabajadorAsignado; }

    public List<Postulacion> getPostulaciones() { return postulaciones; }
    public void setPostulaciones(List<Postulacion> postulaciones) { this.postulaciones = postulaciones; }

    public Calificacion getCalificacionCliente() { return calificacionCliente; }
    public void setCalificacionCliente(Calificacion calificacionCliente) { this.calificacionCliente = calificacionCliente; }

    public Calificacion getCalificacionTrabajador() { return calificacionTrabajador; }
    public void setCalificacionTrabajador(Calificacion calificacionTrabajador) { this.calificacionTrabajador = calificacionTrabajador; }

    public Pago getPago() { return pago; }
    public void setPago(Pago pago) { this.pago = pago; }

    // Métodos de negocio
    public void agregarPostulacion(Postulacion postulacion) {
        if (postulaciones == null) postulaciones = new ArrayList<>();
        postulaciones.add(postulacion);
    }

    public void completarServicio() {
        this.estado = EstadoServicio.COMPLETADO;
        this.fechaFinalizacion = LocalDateTime.now();
    }
}

package com.plataforma.model;

import java.time.LocalDateTime;

public class Postulacion {
    private int id;
    private double precioPropuesto;
    private String mensaje;
    private EstadoPostulacion estado;
    private LocalDateTime fechaPostulacion;
    private Trabajador trabajador;
    private Servicio servicio;

    public Postulacion() {
        this.fechaPostulacion = LocalDateTime.now();
        this.estado = EstadoPostulacion.PENDIENTE;
    }

    public Postulacion(double precioPropuesto, String mensaje, Trabajador trabajador, Servicio servicio) {
        this();
        this.precioPropuesto = precioPropuesto;
        this.mensaje = mensaje;
        this.trabajador = trabajador;
        this.servicio = servicio;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getPrecioPropuesto() { return precioPropuesto; }
    public void setPrecioPropuesto(double precioPropuesto) { this.precioPropuesto = precioPropuesto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public EstadoPostulacion getEstado() { return estado; }
    public void setEstado(EstadoPostulacion estado) { this.estado = estado; }

    public LocalDateTime getFechaPostulacion() { return fechaPostulacion; }
    public void setFechaPostulacion(LocalDateTime fechaPostulacion) { this.fechaPostulacion = fechaPostulacion; }

    public Trabajador getTrabajador() { return trabajador; }
    public void setTrabajador(Trabajador trabajador) { this.trabajador = trabajador; }

    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }
}

package com.plataforma.model;

import java.time.LocalDateTime;

public class Calificacion {
    private int id;
    private int puntuacion;
    private String comentario;
    private LocalDateTime fechaCalificacion;
    private String tipo;
    private Servicio servicio;
    private Usuario evaluador;
    private Usuario evaluado;

    public Calificacion() {
        this.fechaCalificacion = LocalDateTime.now();
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) {
        if (puntuacion < 1 || puntuacion > 5) {
            throw new IllegalArgumentException("La puntuación debe estar entre 1 y 5");
        }
        this.puntuacion = puntuacion;
    }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public LocalDateTime getFechaCalificacion() { return fechaCalificacion; }
    public void setFechaCalificacion(LocalDateTime fechaCalificacion) { this.fechaCalificacion = fechaCalificacion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }

    public Usuario getEvaluador() { return evaluador; }
    public void setEvaluador(Usuario evaluador) { this.evaluador = evaluador; }

    public Usuario getEvaluado() { return evaluado; }
    public void setEvaluado(Usuario evaluado) { this.evaluado = evaluado; }
}

package com.plataforma.model;

import java.time.LocalDateTime;

public class Pago {
    private int id;
    private double monto;
    private MetodoPago metodoPago;
    private EstadoPago estado;
    private LocalDateTime fechaPago;
    private String referencia;
    private Servicio servicio;

    public Pago() {
        this.estado = EstadoPago.PENDIENTE;
        this.fechaPago = LocalDateTime.now();
    }

    public Pago(double monto, MetodoPago metodoPago, Servicio servicio) {
        this();
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.servicio = servicio;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public EstadoPago getEstado() { return estado; }
    public void setEstado(EstadoPago estado) { this.estado = estado; }

    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }
}