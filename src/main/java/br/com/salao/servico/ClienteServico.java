package br.com.salao.servico;

import br.com.salao.conversaoDto.ConversorDto;
import br.com.salao.dto.ClienteDTO;
import br.com.salao.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServico {

    private final ConversorDto conversorDto;

    private final ClienteRepositorio clienteRepositorio;

    public ClienteDTO salvarCliente(ClienteDTO clienteDTO){
    var cliente = conversorDto.dtoParaEntidade(clienteDTO);
    var clienteSalvo = clienteRepositorio.save(cliente);
    return conversorDto.entidadeParaDto(clienteSalvo);
    }

    public List<ClienteDTO>listarClientes(){
        return clienteRepositorio.findAll().stream().map(conversorDto::entidadeParaDto).toList();
    }

    public void excluirCliente(Long id){
        clienteRepositorio.deleteById(id);
    }
}
