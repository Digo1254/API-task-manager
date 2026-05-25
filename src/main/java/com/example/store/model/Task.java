package com.example.store.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean concluida = false;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;



}
