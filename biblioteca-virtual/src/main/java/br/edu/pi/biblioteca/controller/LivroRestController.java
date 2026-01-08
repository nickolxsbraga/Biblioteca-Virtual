package br.edu.pi.biblioteca.controller;

import br.edu.pi.biblioteca.model.Livro;
import br.edu.pi.biblioteca.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livros")
public class LivroRestController {

    private final LivroRepository livroRepository;

    public LivroRestController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Livro salvar(@RequestBody Livro livro) {
        livro.setDisponivel(true);
        return livroRepository.save(livro);
    }
}