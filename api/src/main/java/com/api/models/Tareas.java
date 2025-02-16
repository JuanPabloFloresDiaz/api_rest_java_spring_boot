package com.api.models;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_tareas")
@Data
public class Tareas {

    // Estructura de la tabla tb_tareas
    // Se define la llave primaria de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_tarea", updatable = false, nullable = false, length = 36)
    private UUID id;

    // Se definen los campos de la tabla
    // Campo nombre_tarea: {tipo: String, longitud: 100, no nulo}
    @Column(name = "nombre_tarea", nullable = false, length = 100)
    private String nombreTarea;

    // Campo descripcion_tarea: {tipo: String, longitud: 200, no nulo}
    @Column(name = "descripcion_tarea", nullable = false, length = 200)
    private String descripcionTarea;

    // Campo fecha_inicio_tarea: {tipo: Date, no nulo}
    @Column(name = "fecha_inicio_tarea", nullable = false)
    private java.sql.Date fechaInicioTarea;

    // Campo fecha_fin_tarea: {tipo: Date, no nulo}
    @Column(name = "fecha_fin_tarea", nullable = false)
    private java.sql.Date fechaFinTarea;

    // Campo estado_tarea: {tipo: Boolean, no nulo, valor por defecto: 1}
    @Column(name = "estado_tarea", columnDefinition = "BOOLEAN DEFAULT 1")
    private Boolean estadoTarea;

    // Agregando campo de relación con usuarios
    // Relación: Muchas tareas pueden tener un usuario
    // Se define la relación con la tabla tb_usuarios
    // JoinColumn: Hace referencia al campo de la tabla tb_usuarios
    // ManyToOne: Muchas tareas pueden tener un usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuarios;

    // Getter y Setter {Getter: Obtiene el valor de un campo, Setter: Establece el valor de un campo}
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public java.sql.Date getFechaInicioTarea() {
        return fechaInicioTarea;
    }

    public void setFechaInicioTarea(java.sql.Date fechaInicioTarea) {
        this.fechaInicioTarea = fechaInicioTarea;
    }

    public java.sql.Date getFechaFinTarea() {
        return fechaFinTarea;
    }

    public void setFechaFinTarea(java.sql.Date fechaFinTarea) {
        this.fechaFinTarea = fechaFinTarea;
    }

    public Boolean getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(Boolean estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
