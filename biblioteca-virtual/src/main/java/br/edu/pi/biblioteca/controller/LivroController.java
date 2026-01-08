package br.edu.pi.biblioteca.controller;

import br.edu.pi.biblioteca.model.Livro;
import br.edu.pi.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping("/cadastro-livro")
    public String salvarLivro(Livro livro) {

        livro.setDisponivel(true);
        livroRepository.save(livro);

        return "redirect:/livros";
    }
}