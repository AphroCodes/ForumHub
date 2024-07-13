package br.com.alura.ForumHub.domain.topicos;

import br.com.alura.ForumHub.domain.autor.Autor;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime data;
    private Boolean respostaTopico;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Enumerated(EnumType.STRING)
    private Cursos curso;

    @OneToMany(mappedBy = "topicos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respostas> respostas;

    public Topicos(DadosCadastroTopico dados, Autor autor) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = LocalDateTime.now();
        this.respostaTopico = true;
        this.autor = autor;
        this.curso = dados.curso();
    }

    public void atualizarTopico(DadosAtualizacaoTopicos dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.respostaTopico() != null) {
            this.respostaTopico = dados.respostaTopico();
        }
    }
}
