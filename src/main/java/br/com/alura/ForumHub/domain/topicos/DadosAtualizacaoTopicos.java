package br.com.alura.ForumHub.domain.topicos;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoTopicos(
        String titulo,
        @NotBlank String mensagem,
        Boolean respostaTopico) {
}