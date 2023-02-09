package application.registro.springbootapplication.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CidadePostRequestBody {
    @NotEmpty
    private Long idCidade;
    private String cidadeNome;
    private Long idEstado;
}
