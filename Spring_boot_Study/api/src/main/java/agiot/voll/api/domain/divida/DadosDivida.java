package agiot.voll.api.domain.divida;

import jakarta.validation.constraints.NotBlank;

public record DadosDivida(
        @NotBlank
        String valor,
        @NotBlank
        String taxa) {

}
