package agiot.voll.api.domain.cliente;

import agiot.voll.api.domain.divida.Divida;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "agiota")
@Entity(name = "Agiota")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Agiota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    private String genero;
    private boolean ativo;

    @Embedded
    private Divida divida;


    public Agiota(DadosCadastro dados) {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.genero = dados.genero();
        this.divida = new Divida(dados.divida());
        this.ativo = true;
    }

    public  void atualizarInformacoes(AtualizacaoCliente dados) {
        if(dados.nome()!=null){
        this.nome = dados.nome();

        }
        if(dados.genero()!=null){
            this.genero = dados.genero();
        }
    }

    public void excluir() {
        this.ativo =  false;
    }

    public void ativarUser() {
        this.ativo = true;
    }
}
