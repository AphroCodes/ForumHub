package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.domain.usuarios.*;
import br.com.alura.ForumHub.repository.RepositorioUsuarios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    private ResponseEntity<?> buscarUsuario(@PathVariable Long id) {
        var user = repositorioUsuarios.findById(id);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity novoUsuario(@RequestBody @Valid DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        repositorioUsuarios.save(usuario);
        return ResponseEntity.ok().build();
    }
}

