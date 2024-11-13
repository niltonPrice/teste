package agiot.voll.api.domain.cliente;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoCliente(
        @NotNull Long id, String nome, String genero) {

    AtualizacaoCliente(Agiota dados){
        this(dados.getId(), dados.getNome(), dados.getGenero());
    }
}
