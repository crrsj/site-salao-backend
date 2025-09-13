package br.com.salao.controle;

import br.com.salao.dto.ContatoDTO;
import br.com.salao.servico.ContatoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.structured.GraylogExtendedLogFormatProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/contato")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContatoControle {

    private final ContatoServico contatoServico;

    @PostMapping
    public ResponseEntity<ContatoDTO>criarContatos(@RequestBody ContatoDTO contatoDTO){
        var contato = contatoServico.salvarContato(contatoDTO);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(contato.id()).toUri();
        return ResponseEntity.created(uri).body(contato);
    }

    @GetMapping
    public ResponseEntity<List<ContatoDTO>>listarTodos(){
        return ResponseEntity.ok().body(contatoServico.listarContatos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>excluirContato(@PathVariable Long id){
        contatoServico.excluirContatos(id);
        return ResponseEntity.noContent().build();
    }
}
