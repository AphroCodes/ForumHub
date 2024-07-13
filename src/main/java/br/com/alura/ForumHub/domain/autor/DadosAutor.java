package br.com.alura.ForumHub.domain.autor;

public record DadosAutor (
        Long id,
        String nome){

    public DadosAutor(Autor autor) {
        this(autor.getId(), autor.getNome());
    }
}
