package com.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.repositorys.UsuariosRepository;
import com.api.models.Usuarios;
import java.util.List;
import java.util.UUID;

@Service
public class UsuariosServices {

    // Inyección de dependencias
    @Autowired
    private UsuariosRepository usuariosRepository;

    // Método para obtener todos los usuarios
    public List<Usuarios> getAll() {
        return usuariosRepository.findAll();
    }   

    // Método para obtener un usuario por su id
    public Usuarios getUserById(UUID id) {
        return usuariosRepository.findById(id).get();
    }

    // Método para guardar un usuario
    public Usuarios saveUser(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    // Método para eliminar un usuario
    public void deleteUser(UUID id) {
        usuariosRepository.deleteById(id);
    }

    // Método para actualizar un usuario
    public Usuarios updateUser(UUID id, Usuarios usuarioActualizado){
        return usuariosRepository.findById(id).map(usuario -> {
            usuario.setNombreUsuario(usuario.getNombreUsuario());
            usuario.setCorreoElectronico(usuario.getCorreoElectronico());
            usuario.setClaveUsuario(usuario.getClaveUsuario());
            usuario.setTelefonoUsuario(usuario.getTelefonoUsuario());
            usuario.setDuiUsuario(usuario.getDuiUsuario());
            usuario.setFechaNacimientoUsuario(usuario.getFechaNacimientoUsuario());
            usuario.setEstadoUsuario(usuario.getEstadoUsuario());
            usuario.setDireccionUsuario(usuario.getDireccionUsuario());
            usuario.setRoles(usuario.getRoles());
            return usuariosRepository.save(usuario);
        }).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }
}
