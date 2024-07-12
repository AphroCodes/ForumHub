package br.com.alura.ForumHub.domain.usuarios;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(
        @NotNull
        Long id,
        String nome) {
}
