package application.registro.springbootapplication.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UsuarioPostRequestBody {
    @NotEmpty
    private Long idUsuario;
    private String usuarioNome;
    private Long idProfissao;
    private Long idCidade;
}
