package br.edu.pi.biblioteca.repository;

import br.edu.pi.biblioteca.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}