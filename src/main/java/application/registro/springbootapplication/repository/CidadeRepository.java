package application.registro.springbootapplication.repository;

import application.registro.springbootapplication.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
