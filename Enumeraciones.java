package com.plataforma.model;

public enum EstadoServicio {
    ABIERTO, EN_NEGOCIACION, ASIGNADO, EN_PROGRESO, COMPLETADO, CANCELADO;

    public String getDescripcion() {
        switch (this) {
            case ABIERTO: return "Abierto para postulaciones";
            case EN_NEGOCIACION: return "En proceso de negociación";
            case ASIGNADO: return "Trabajador asignado";
            case EN_PROGRESO: return "Servicio en progreso";
            case COMPLETADO: return "Servicio completado";
            case CANCELADO: return "Servicio cancelado";
            default: return "";
        }
    }
}

package com.plataforma.model;

public enum EstadoPostulacion {
    PENDIENTE, ACEPTADA, RECHAZADA, RETIRADA;

    public String getDescripcion() {
        switch (this) {
            case PENDIENTE: return "Pendiente de revisión";
            case ACEPTADA: return "Postulación aceptada";
            case RECHAZADA: return "Postulación rechazada";
            case RETIRADA: return "Postulación retirada";
            default: return "";
        }
    }
}

package com.plataforma.model;

public enum EstadoPago {
    PENDIENTE, PROCESANDO, COMPLETADO, RECHAZADO, REEMBOLSADO;

    public String getDescripcion() {
        switch (this) {
            case PENDIENTE: return "Pago pendiente";
            case PROCESANDO: return "Procesando pago";
            case COMPLETADO: return "Pago completado";
            case RECHAZADO: return "Pago rechazado";
            case REEMBOLSADO: return "Pago reembolsado";
            default: return "";
        }
    }
}

package com.plataforma.model;

public enum MetodoPago {
    EFECTIVO, TARJETA_CREDITO, TARJETA_DEBITO, NEQUI, DAVIPLATA, BANCO;

    public String getNombre() {
        switch (this) {
            case EFECTIVO: return "Efectivo";
            case TARJETA_CREDITO: return "Tarjeta de Crédito";
            case TARJETA_DEBITO: return "Tarjeta de Débito";
            case NEQUI: return "Nequi";
            case DAVIPLATA: return "DaviPlata";
            case BANCO: return "Transferencia Bancaria";
            default: return "";
        }
    }
}