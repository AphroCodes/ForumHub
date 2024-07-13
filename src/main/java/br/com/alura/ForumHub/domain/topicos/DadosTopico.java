package br.com.alura.ForumHub.domain.topicos;

import br.com.alura.ForumHub.domain.autor.DadosAutor;

import java.time.LocalDateTime;
import java.util.List;

public record DadosTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        Boolean respostaTopico,
        DadosAutor autor,
        Cursos curso,
        List<DadosRespostas> respostas) {}