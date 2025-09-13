package br.com.salao.entidade;

import com.fasterxml.jackson.annotation.JsonFormat;
import enums.Profissional;
import enums.Servico;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Servico servico;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private Profissional profissional;
    private LocalTime horario;
}
