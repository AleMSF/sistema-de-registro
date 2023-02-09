package application.registro.springbootapplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCidade;
    private String cidadeNome;
    private Long idEstado;
}

