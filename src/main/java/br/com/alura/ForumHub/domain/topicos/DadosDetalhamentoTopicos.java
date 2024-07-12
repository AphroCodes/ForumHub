package br.com.alura.ForumHub.domain.topicos;

public record DadosDetalhamentoTopicos(Long id, String titulo, String mensagem, String dataCriacao, String autor, Cursos cursos) {

    public DadosDetalhamentoTopicos(Topicos topicos) {
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), topicos.getDataCriacao(), topicos.getAutor(), topicos.getCurso());
    }
}