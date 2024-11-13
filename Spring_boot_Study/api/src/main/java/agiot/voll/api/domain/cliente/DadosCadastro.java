package agiot.voll.api.domain.cliente;
import agiot.voll.api.domain.divida.DadosDivida;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


public record DadosCadastro(
        @NotBlank
        String nome,
        @NotBlank
        String idade,
        @NotBlank
        String genero,
        @NotBlank
        @Valid
        DadosDivida divida ) {


}

