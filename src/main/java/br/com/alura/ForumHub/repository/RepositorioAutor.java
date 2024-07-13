package br.com.alura.ForumHub.repository;

import br.com.alura.ForumHub.domain.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAutor extends JpaRepository<Autor, Long> {
}
