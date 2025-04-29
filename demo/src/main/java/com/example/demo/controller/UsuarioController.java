package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Usuario almacenar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = repository.findAll();

        return usuarios.stream().map(usuario ->
            new UsuarioDTO(
                usuario.getCorreo(),
                usuario.getNombre(),
                usuario.getApellido()
           )
        ).collect(Collectors.toList());
    }
}
