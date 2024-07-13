package br.com.alura.ForumHub.domain.service;

import br.com.alura.ForumHub.domain.autor.Autor;
import br.com.alura.ForumHub.domain.autor.DadosAutor;
import br.com.alura.ForumHub.domain.topicos.DadosAtualizacaoTopicos;
import br.com.alura.ForumHub.domain.topicos.DadosCadastroTopico;
import br.com.alura.ForumHub.domain.topicos.DadosDetalhamentoTopicos;
import br.com.alura.ForumHub.infra.excessoes.ValidacaoException;
import br.com.alura.ForumHub.repository.RepositorioAutor;
import br.com.alura.ForumHub.repository.RepositorioTopico;
import br.com.alura.ForumHub.domain.topicos.Topicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private RepositorioTopico repositorioTopico;

    @Autowired
    private RepositorioAutor repositorioAutor;

    public DadosDetalhamentoTopicos criarTopico(DadosCadastroTopico dados){

        Autor autor = repositorioAutor.getReferenceById(dados.idAutor());
        var topico = new Topicos(dados, autor);
        repositorioTopico.save(topico);

        System.out.println(dados);
        System.out.println(autor);

        return null;
    }

    public DadosDetalhamentoTopicos atualizarTopico(Long id, DadosAtualizacaoTopicos dados){
        findTopicoById(id);
        var topico = repositorioTopico.getReferenceById(id);
        topico.atualizarTopico(dados);

        return new DadosDetalhamentoTopicos(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getRespostaTopico(), new DadosAutor(topico.getAutor()), topico.getCurso());
    }

    public Topicos findTopicoById(Long id){
        return repositorioTopico.findById(id)
                .orElseThrow(() -> new ValidacaoException("Tópico com ID " + id + " não encontrado"));
    }

    public DadosDetalhamentoTopicos detalharTopico(Long id){
        findTopicoById(id);
        var topico = repositorioTopico.getReferenceById(id);
        return new DadosDetalhamentoTopicos(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getRespostaTopico(), new  DadosAutor(topico.getAutor()), topico.getCurso());
    }

    public Long deletarTopico(Long id){
        findTopicoById(id);
        repositorioTopico.deleteById(id);
        return id;
    }
}
