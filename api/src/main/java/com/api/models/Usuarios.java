package com.api.models;

import java.util.UUID;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_usuarios")
@Data
public class Usuarios {

    // Estrutura de la tabla tb_usuarios
    // Se define la llave primaria de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", updatable = false, nullable = false, length = 36)
    private UUID id;

    // Se definen los campos de la tabla
    // Campo nombre_usuario: {tipo: String, longitud: 100, no nulo, único}
    @Column(name = "nombre_usuario", nullable = false, unique = true, length = 100)
    private String nombreUsuario;

    // Campo correo_electronico_usuario: {tipo: String, longitud: 100, no nulo, único}
    @Column(name = "correo_electronico_usuario", nullable = false, unique = true, length = 100)
    private String correoElectronico;

    // Campo clave_usuario: {tipo: String, longitud: 100, no nulo}
    @Column(name = "clave_usuario", nullable = false, length = 100)
    private String claveUsuario;

    // Campo telefono_usuario: {tipo: String, longitud: 15, no nulo}
    @Column(name = "telefono_usuario", nullable = false, length = 15)
    private String telefonoUsuario;

    // Campo dui_usuario: {tipo: String, longitud: 10, no nulo, único}
    @Column(name = "dui_usuario", nullable = false, unique = true, length = 10)
    private String duiUsuario;

    // Campo fecha_nacimiento_usuario: {tipo: Date, no nulo}
    @Column(name = "fecha_nacimiento_usuario", nullable = false)
    private java.sql.Date fechaNacimientoUsuario;

    // Campo estado_usuario: {tipo: Boolean, no nulo, valor por defecto: 1}
    @Column(name = "estado_usuario", columnDefinition = "BOOLEAN DEFAULT 1")
    private Boolean estadoUsuario;

    // Campo direccion_usuario: {tipo: String, longitud: 200}
    @Column(name = "direccion_usuario", length = 200)
    private String direccionUsuario;

    // Agregando campo de relación con roles
    // Relación: Muchos usuarios pueden tener un rol
    // Se define la relación con la tabla tb_roles
    // JoinColumn: Hace referencia al campo de la tabla tb_roles
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Roles roles;

    // Relación inversa: Un usuario puede tener varias tareas
    // Se define la relación con la tabla tb_tareas
    // mappedBy: Hace referencia al campo de la tabla tb_tareas
    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tareas> tareas;

    // Getter y Setter {Getter: Obtiene el valor de un campo, Setter: Establece el valor de un campo}
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDuiUsuario() {
        return duiUsuario;
    }

    public void setDuiUsuario(String duiUsuario) {
        this.duiUsuario = duiUsuario;
    }

    public java.sql.Date getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(java.sql.Date fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
