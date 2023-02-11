package application.registro.springbootapplication.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioPorCidadeDTO {
    private Long idUsuario;
    private String nomeUsuario;
    private String nomeCidade;
}
