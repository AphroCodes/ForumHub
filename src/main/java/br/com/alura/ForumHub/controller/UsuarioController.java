package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.domain.usuarios.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    @PostMapping
    @Transactional
    public void novoUsuario(@RequestBody @Valid DadosCadastroUsuario dados) {
        repositorioUsuarios.save(new Usuario(dados));
    }

    @GetMapping
    public Page<DadosListagemUsuario> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable) {
        return repositorioUsuarios.findAllByAtivoTrue(pageable).map(DadosListagemUsuario::new);
    }

    @PutMapping
    @Transactional
    public void atualizarUsuario(@RequestBody @Valid DadosAtualizarUsuario dados) {
        var usuario = repositorioUsuarios.getReferenceById(dados.id());
        usuario.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirUsuario(@PathVariable Long id) {
        var usuario = repositorioUsuarios.getReferenceById(id);
        usuario.excluir();
    }
}

