package application.registro.springbootapplication.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UsuarioDTO2 {
    private Long idUsuario;
    private String nomeUsuario;
    private String nomeCidade;
    private String nomeEstado;
}
