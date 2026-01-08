package br.edu.pi.biblioteca.controller;

import br.edu.pi.biblioteca.model.Livro;
import br.edu.pi.biblioteca.repository.LivroRepository;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        livro.setDisponivel(true);
        return livroRepository.save(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return livroRepository.findAll();
    }
}
