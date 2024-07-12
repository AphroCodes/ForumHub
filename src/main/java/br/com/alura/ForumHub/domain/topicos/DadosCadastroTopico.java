package br.com.alura.ForumHub.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(@NotBlank(message = "Insira um título") String titulo,
                                  @NotBlank(message = "Insira sua dúvida ou idéia") String mensagem,
                                  String dataCriacao,
                                  @NotBlank String autor,
                                  @NotNull Cursos curso,
                                  @NotBlank String respostas) {
}
