package br.edu.pi.biblioteca.controller;

import br.edu.pi.biblioteca.model.Livro;
import br.edu.pi.biblioteca.model.Transacao;
import br.edu.pi.biblioteca.repository.LivroRepository;
import br.edu.pi.biblioteca.repository.TransacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/api/transacoes")
@Controller
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;
    private final LivroRepository livroRepository;

    public TransacaoController(TransacaoRepository transacaoRepository,
                               LivroRepository livroRepository) {
        this.transacaoRepository = transacaoRepository;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public Transacao reservar(@RequestBody Transacao transacao) {

        Livro livro = livroRepository.findById(transacao.getLivro().getId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (!livro.getDisponivel()) {
            throw new RuntimeException("Livro já está reservado");
        }

        livro.setDisponivel(false);
        livroRepository.save(livro);

        transacao.setDataReserva(LocalDate.now());
        transacao.setStatus("RESERVADO");

        return transacaoRepository.save(transacao);
    }
}
