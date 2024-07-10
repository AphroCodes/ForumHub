package br.com.alura.ForumHub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(@NotBlank String titulo,
                                  @NotBlank String mensagem,
                                  @NotBlank String autor,
                                  @NotNull Cursos curso) {

}
