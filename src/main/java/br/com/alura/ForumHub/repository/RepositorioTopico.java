package br.com.alura.ForumHub.repository;

import br.com.alura.ForumHub.domain.topicos.Topicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTopico extends JpaRepository<Topicos, Long> {
}
