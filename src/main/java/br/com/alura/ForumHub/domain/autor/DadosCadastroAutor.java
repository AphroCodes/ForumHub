package br.com.alura.ForumHub.domain.autor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAutor(
    @NotBlank
    String nome){
}
