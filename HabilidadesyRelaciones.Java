package com.plataforma.model;

public class Habilidad {
    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private boolean activa;

    public Habilidad() {
        this.activa = true;
    }

    public Habilidad(String nombre, String descripcion, String categoria) {
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
}

package com.plataforma.model;

public class TrabajadorHabilidad {
    private int id;
    private Trabajador trabajador;
    private Habilidad habilidad;
    private String nivel;
    private int anosExperiencia;

    public TrabajadorHabilidad() {}

    public TrabajadorHabilidad(Trabajador trabajador, Habilidad habilidad, String nivel, int anosExperiencia) {
        this.trabajador = trabajador;
        this.habilidad = habilidad;
        this.nivel = nivel;
        this.anosExperiencia = anosExperiencia;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Trabajador getTrabajador() { return trabajador; }
    public void setTrabajador(Trabajador trabajador) { this.trabajador = trabajador; }

    public Habilidad getHabilidad() { return habilidad; }
    public void setHabilidad(Habilidad habilidad) { this.habilidad = habilidad; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public int getAnosExperiencia() { return anosExperiencia; }
    public void setAnosExperiencia(int anosExperiencia) { this.anosExperiencia = anosExperiencia; }
}