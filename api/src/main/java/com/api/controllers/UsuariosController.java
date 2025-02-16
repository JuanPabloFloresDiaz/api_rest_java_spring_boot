package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Usuarios;
import com.api.services.UsuariosServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.UUID;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosServices usuariosServices;

    @GetMapping
    public ResponseEntity<List<Usuarios>> getAll() {
        try {
            return ResponseEntity.ok(usuariosServices.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUserById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(usuariosServices.getUserById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @PostMapping("/")
    public ResponseEntity<Usuarios> saveUser(@RequestBody Usuarios usuario) {
        try {
            return ResponseEntity.ok(usuariosServices.saveUser(usuario));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        try {
            usuariosServices.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateUser(@PathVariable UUID id, @RequestBody Usuarios usuarioActualizado) {
        try {
            Usuarios usuario = usuariosServices.updateUser(id, usuarioActualizado);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
