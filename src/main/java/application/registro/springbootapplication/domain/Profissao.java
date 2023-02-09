package application.registro.springbootapplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Profissao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProfissao;
    private String profissaoNome;
    private BigDecimal salario;

}

