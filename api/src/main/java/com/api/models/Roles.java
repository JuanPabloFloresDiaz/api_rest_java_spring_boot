package com.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_roles")
@Data
public class Roles {

    // Estructura de la tabla tb_roles
    // Se define la llave primaria de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_rol", updatable = false, nullable = false, length = 36)
    private UUID id;

    // Se definen los campos de la tabla
    // Campo nombre_rol: {tipo: String, longitud: 50, no nulo, único}
    @Column(name = "nombre_rol", nullable = false, unique = true, length = 50)
    private String nombreRol;

    // Campo descripcion_rol: {tipo: String, longitud: 200, no nulo}
    @Column(name = "descripcion_rol", nullable = false, length = 200)
    private String descripcionRol;

    // Campo estado_rol: {tipo: Boolean, no nulo, valor por defecto: 1}
    @Column(name = "estado_rol", columnDefinition = "BOOLEAN DEFAULT 1")
    private Boolean estadoRol;

    // Relación inversa: Un rol puede tener varios usuarios
    // Se define la relación con la tabla tb_usuarios
    // mappedBy: Hace referencia al campo de la tabla tb_usuarios
    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuarios> usuarios;

    // Getter y Setter {Getter: Obtiene el valor de un campo, Setter: Establece el valor de un campo}
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public Boolean getEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(Boolean estadoRol) {
        this.estadoRol = estadoRol;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
}
