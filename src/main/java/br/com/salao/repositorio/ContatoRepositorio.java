package br.com.salao.repositorio;

import br.com.salao.entidade.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepositorio extends JpaRepository<Contato,Long> {
}
