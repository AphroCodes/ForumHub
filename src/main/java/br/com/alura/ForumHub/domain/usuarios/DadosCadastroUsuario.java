package br.com.alura.ForumHub.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DadosCadastroUsuario (

        @NotBlank String login,
        @NotBlank @Email String email,
        @NotBlank String senha){
}