package com.example.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Task;
import com.example.store.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario,Long>{

    Optional<Usuario> findByEmail(String email);


}
