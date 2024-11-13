package agiot.voll.api.domain.divida;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Divida {
    private String valor;
    private String taxa;

    public Divida(DadosDivida divida) {
        this.valor = divida.valor();
        this.taxa = divida.taxa();
    }
}
