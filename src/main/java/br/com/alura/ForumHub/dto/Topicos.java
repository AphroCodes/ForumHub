package br.com.alura.ForumHub.dto;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String autor;

    @Enumerated(EnumType.STRING)
    private Cursos curso;

    private Boolean ativo;

    public Topicos(DadosCadastroTopico dados) {
        this.ativo = true;
        this.autor = dados.autor();
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();
    }

    public void atualizarTopico(DadosAtualizacaoTopicos dados) {
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
    }

    public void deletarTopico() {
        this.ativo = false;
    }
}
