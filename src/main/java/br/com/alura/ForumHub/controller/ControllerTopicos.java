package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.domain.service.TopicoService;
import br.com.alura.ForumHub.domain.topicos.*;
import br.com.alura.ForumHub.repository.RepositorioTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class ControllerTopicos {

    @Autowired
    private RepositorioTopico repositorioTopico;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody @Valid DadosCadastroTopico dados) {

        var topico = topicoService.criarTopico(dados);

        return ResponseEntity.ok(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoTopicos>> listarTopicos (@PageableDefault(size = 5, sort = {"autor"}) Pageable pageable){
        var page = repositorioTopico.findAll(pageable).map(DadosDetalhamentoTopicos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhesTopico(@PathVariable Long id){
        var topico = repositorioTopico.findById(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopicos dados) {
        var topico = topicoService.atualizarTopico(id, dados);
        return ResponseEntity.ok(topico);
    }
}
