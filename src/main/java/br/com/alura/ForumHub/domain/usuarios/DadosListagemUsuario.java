package br.com.alura.ForumHub.domain.usuarios;

public record DadosListagemUsuario(Long id, String nome, String email, String senha, String perfis) {

    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfis());
    }
}