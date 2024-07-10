package br.com.alura.ForumHub.dto;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface RepositorioTopico extends JpaRepository<DadosCadastroTopico, Long> {
    Page <Topicos> findAllByAtivoTrue(Pageable paginacao);
}
