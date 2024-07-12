package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.domain.topicos.*;
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

    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topicos(dados);

        repositorioTopico.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopicos(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listarTopicos (@PageableDefault(size = 5, sort = {"autor"}) Pageable paginacao){
        var page = repositorioTopico.findAllByAtivoTrue(paginacao).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid DadosAtualizacaoTopicos dados){
        var topico = repositorioTopico.getReferenceById(dados.id());
        topico.atualizarTopico(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopicos(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@PathVariable Long id) {
        var topico = repositorioTopico.getReferenceById(id);
        topico.deletarTopico();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id) {
        var topico = repositorioTopico.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTopicos(topico));
    }
}
