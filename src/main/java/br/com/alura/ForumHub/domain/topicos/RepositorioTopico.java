package br.com.alura.ForumHub.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTopico extends JpaRepository<Topicos, Long> {
    Page<Topicos> findAllByAtivoTrue(Pageable pageable);
}
