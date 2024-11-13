package agiot.voll.api.domain.cliente;

public record DadosListagemMedicos(Long id,String nome,String idade,boolean ativo) {
    public DadosListagemMedicos(Agiota agiota){
        this(agiota.getId(), agiota.getNome(), agiota.getIdade(),agiota.isAtivo());
    }
}
