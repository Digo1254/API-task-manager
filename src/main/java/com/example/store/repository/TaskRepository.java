package com.example.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Task;
import com.example.store.model.Usuario;

public interface TaskRepository extends JpaRepository<Task,Long>{
    List<Task> findByConcluida(Boolean concluida);

    List<Task> findByUsuario(Usuario usuario);
}
