package br.com.alura.ForumHub.repository;

import br.com.alura.ForumHub.domain.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String subject);
}
