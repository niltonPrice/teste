package agiot.voll.api.controler;

import agiot.voll.api.domain.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/agiotas")
public class AgiotController {

    @Autowired
    private AgiotaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastro dados, UriComponentsBuilder uriBuilder){
        var agiota =new Agiota(dados);
        repository.save(agiota);
        var uri = uriBuilder.path("/Agiotas/{id}").buildAndExpand(agiota.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemMedicos(agiota));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listar(Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody AtualizacaoCliente dados){
    var teste = repository.getReferenceById(dados.id());
        teste.atualizarInformacoes(dados);
        return ResponseEntity.ok(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var teste = repository.getReferenceById(id);
        teste.excluir();

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity ativarUser(@PathVariable Long id){
        var agiota  = repository.getReferenceById(id);
        agiota.ativarUser();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhamentoCliente(@PathVariable Long id){
        var teste = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosListagemMedicos(teste));
    }
}
