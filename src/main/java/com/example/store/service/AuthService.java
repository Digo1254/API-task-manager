package com.example.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.dto.LoginDTO;
import com.example.store.dto.RegisterDTO;
import com.example.store.model.Usuario;
import com.example.store.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtService jwtService;

    public Usuario registrar(RegisterDTO dto){

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());

        return repository.save(usuario);

    }

    public String login(LoginDTO dto){
        Usuario usuario = repository.findByEmail(dto.getEmail())
        .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        if(!dto.getSenha().equals(usuario.getSenha())){
            throw new RuntimeException("Senha inválida");
        }

        return jwtService.gerarToken(usuario.getEmail());
    }

}
