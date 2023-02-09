package application.registro.springbootapplication.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UsuarioDTO {
    private Long idUsuario;
    private String nomeCidade;
    private String nomeEsatdo;
    private String nomeProfissao;
    private BigDecimal salario;
}
