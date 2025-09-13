package br.com.salao.dto;

import br.com.salao.entidade.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import enums.Profissional;
import enums.Servico;

import java.time.LocalDate;
import java.time.LocalTime;

public record ClienteDTO(
                         Long id,
                         String nome,
                         String telefone,
                         Servico servico,
                         LocalDate data,
                         Profissional profissional,
                         @JsonFormat(pattern = "HH:mm")
                         LocalTime horario) {
 public ClienteDTO(Cliente cliente){
     this(
             cliente.getId(),
             cliente.getNome(),
             cliente.getTelefone(),
             cliente.getServico(),
             cliente.getData(),
             cliente.getProfissional(),
             cliente.getHorario());
 }

}
