package br.com.alura.ForumHub.domain.topicos;

import br.com.alura.ForumHub.domain.autor.DadosAutor;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopicos(
        Long id,

        String titulo,
        String mensagem,
        LocalDateTime data,
        Boolean respostaTopico,
        DadosAutor autor,
        Cursos cursos
) {
    public DadosDetalhamentoTopicos(Topicos topicos) {
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), topicos.getData(), topicos.getRespostaTopico(), new DadosAutor(topicos.getAutor()), topicos.getCurso());
    }
}