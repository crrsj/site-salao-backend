package br.com.salao.entidade;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeContato;
    private String emailContato;
    private String assunto;
    @Column(columnDefinition = "TEXT")
    private String mensagem;
}
