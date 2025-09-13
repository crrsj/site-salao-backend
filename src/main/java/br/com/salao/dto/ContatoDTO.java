package br.com.salao.dto;

import br.com.salao.entidade.Contato;
import jakarta.validation.constraints.Email;

public record ContatoDTO(
        Long id,
        String nomeContato,
        @Email
        String emailContato,
        String assunto,
        String mensagem) {
    public ContatoDTO(Contato contato) {
        this(
                contato.getId(),
                contato.getNomeContato(),
                contato.getEmailContato(),
                contato.getAssunto(),
                contato.getMensagem());
    }
}
