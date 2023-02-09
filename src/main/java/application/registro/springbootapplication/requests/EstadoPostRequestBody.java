package application.registro.springbootapplication.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EstadoPostRequestBody {
    @NotEmpty
    private Long idEstado;
    private String estadoNome;
}
