package application.registro.springbootapplication.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProfissaoPostRequestBody {
    @NotEmpty
    private Long idProfissao;
    private String profissaoNome;
    private BigDecimal salario;
}
