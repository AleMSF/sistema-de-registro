package application.registro.springbootapplication.repository;

import application.registro.springbootapplication.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
