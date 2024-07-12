package br.com.alura.ForumHub.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopicos(@NotNull Long id,
                                      @NotBlank String mensagem) {
}
