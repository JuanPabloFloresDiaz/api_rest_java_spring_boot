package com.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.models.Tareas;

import java.util.UUID;

@Repository
public interface TareasRepository extends JpaRepository<Tareas, UUID> {

}
