package application.registro.springbootapplication.repository;

import application.registro.springbootapplication.domain.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {

}
