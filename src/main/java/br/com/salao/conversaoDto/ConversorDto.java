package br.com.salao.conversaoDto;

import br.com.salao.dto.ClienteDTO;
import br.com.salao.dto.ContatoDTO;
import br.com.salao.entidade.Cliente;
import br.com.salao.entidade.Contato;
import org.springframework.stereotype.Component;

@Component
public class ConversorDto {

    public Cliente dtoParaEntidade(ClienteDTO clienteDTO){
        var cliente = new Cliente();
        cliente.setId(clienteDTO.id());
        cliente.setNome(clienteDTO.nome());
        cliente.setTelefone(clienteDTO.telefone());
        cliente.setServico(clienteDTO.servico());
        cliente.setProfissional(clienteDTO.profissional());
        cliente.setData(clienteDTO.data());
        cliente.setHorario(clienteDTO.horario());
        return cliente;
    }

    public ClienteDTO entidadeParaDto(Cliente cliente){
        return new ClienteDTO(cliente);
    }

    public Contato dtoParaEntidade(ContatoDTO contatoDTO){
        var contato = new Contato();
        contato.setId(contatoDTO.id());
        contato.setNomeContato(contatoDTO.nomeContato());
        contato.setEmailContato(contatoDTO.emailContato());
        contato.setAssunto(contatoDTO.assunto());
        contato.setMensagem(contatoDTO.mensagem());
        return contato;
    }

    public ContatoDTO entidadeParaDto(Contato contatoSalvo){
        return new ContatoDTO(contatoSalvo);
    }
}
