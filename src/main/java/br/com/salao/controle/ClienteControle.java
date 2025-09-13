package br.com.salao.controle;

import br.com.salao.dto.ClienteDTO;
import br.com.salao.servico.ClienteServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/clientes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClienteControle {

    private final ClienteServico clienteServico;

    @PostMapping
    public ResponseEntity<ClienteDTO>salvarCliente(@RequestBody ClienteDTO clienteDTO){
       var cliente =  clienteServico.salvarCliente(clienteDTO);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(cliente.id()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>>listarClientes(){
        return ResponseEntity.ok().body(clienteServico.listarClientes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>excluirCliente(@PathVariable Long id){
        clienteServico.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }
}
