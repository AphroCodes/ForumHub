package br.com.alura.ForumHub.domain.topicos;

import br.com.alura.ForumHub.domain.autor.DadosAutor;

import java.time.LocalDateTime;

public record DadosRespostas
    (Long id,
    String mensagem,
    LocalDateTime data,
    DadosAutor autor) {}