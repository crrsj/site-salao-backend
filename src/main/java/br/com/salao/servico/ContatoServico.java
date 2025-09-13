package br.com.salao.servico;


import br.com.salao.conversaoDto.ConversorDto;
import br.com.salao.dto.ContatoDTO;
import br.com.salao.repositorio.ContatoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoServico {

    private final ContatoRepositorio contatoRepositorio;
    private final ConversorDto conversorDto;

    public ContatoDTO salvarContato(ContatoDTO contatoDTO){
     var contato = conversorDto.dtoParaEntidade(contatoDTO);
     var contatoSalvo = contatoRepositorio.save(contato);
     return conversorDto.entidadeParaDto(contatoSalvo);
    }

    public List<ContatoDTO>listarContatos(){
        return contatoRepositorio.findAll()
                .stream().map(conversorDto::entidadeParaDto)
                .toList();
    }

    public void excluirContatos(Long id){
        contatoRepositorio.deleteById(id);
    }
}
