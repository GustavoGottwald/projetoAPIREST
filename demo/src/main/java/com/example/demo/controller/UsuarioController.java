package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Facade é usado para fornecer uma interface simplificada para um conjunto de classes 
// ou subsistemas complexos, escondendo a complexidade dos detalhes interno
// O padrão Facade pode ser identificado na camada de serviços, 
// principalmente onde os controladores interagem com a lógica de negócios que nesse projeto é aqui

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}