package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.dto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class ControllerTopicos {

    @Autowired
    private RepositorioTopico repositorioTopico;

    @PostMapping
    @Transactional
    public void novoTopico(@RequestBody @Valid DadosCadastroTopico dados) {
        repositorioTopico.save(new Topicos(dados));
    }

    @GetMapping
    public Page<DadosListagemTopicos> listarTopicos (@PageableDefault(size = 10, sort = {"autor"}) Pageable paginacao){
        return repositorioTopico.findAllByAtivoTrue(paginacao).map(DadosListagemTopicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMensagem(@RequestBody @Valid DadosAtualizacaoTopicos dados){
        var topico = repositorioTopico.getReferenceById(dados.id());
        topico.atualizarTopico(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var topico = repositorioTopico.getReferenceById(id);
        topico.deletarTopico();
    }
}
