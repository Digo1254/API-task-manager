package com.example.store.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.store.dto.TaskDTO;
import com.example.store.model.Task;
import com.example.store.model.Usuario;
import com.example.store.repository.TaskRepository;
import com.example.store.repository.UserRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public List<Task> listarTodosUsuario(String email){
        Usuario usuario = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Usuario não encontrado"));

        return repository.findByUsuario(usuario);
    }

    public Task criar(TaskDTO dto,String email){
        Usuario usuario = userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Task task = new Task();
        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setUsuario(usuario);
        return repository.save(task);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Task alterar(TaskDTO dto,Long id){
        Task task = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());

        return repository.save(task);
    }

    public Task concluir(Long id){
        Task task = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        task.setConcluida(true);

        return repository.save(task);
    }

    public List<Task> listarPorStatus(Boolean concluida) {
    return repository.findByConcluida(concluida);
    }

    public Task buscaPorId(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Tarefa não encontrada"));
    }

}
