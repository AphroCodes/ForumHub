package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.domain.autor.Autor;
import br.com.alura.ForumHub.domain.autor.DadosAutor;
import br.com.alura.ForumHub.domain.autor.DadosCadastroAutor;
import br.com.alura.ForumHub.repository.RepositorioAutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("autores")
public class AutorController {
    @Autowired
    private RepositorioAutor repositorioAutor;

    @PostMapping
    @Transactional
    public ResponseEntity novoAutor(@RequestBody @Valid DadosCadastroAutor dados, UriComponentsBuilder uriBuilder) {
        var autor = new Autor(dados);
        repositorioAutor.save(autor);
        var uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosAutor(autor));
    }
}