package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.dto.TaskDTO;
import com.example.store.model.Task;
import com.example.store.service.JwtService;
import com.example.store.service.TaskService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public Task criar(@RequestBody TaskDTO dto){
        String email = SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getName();
        return service.criar(dto,email);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Task putMethodName(@PathVariable Long id, @RequestBody TaskDTO dto) {
        return service.alterar(dto, id);
    }

    @PatchMapping("/{id}/complete")
    public Task concluir(@PathVariable Long id){

        return service.concluir(id);
    }

    @GetMapping
    public List<Task> listar(@RequestParam(required = false) Boolean concluida) {
        if(concluida != null){
           return service.listarPorStatus(concluida);
        }

        String email = SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getName();

        return service.listarTodosUsuario(email);
    }

    @GetMapping("/{id}")
    public Task getMethodName(@PathVariable Long id) {
        return service.buscaPorId(id);
    }
    
    

}
