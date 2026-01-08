package br.edu.pi.biblioteca.controller;

import br.edu.pi.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LivroMVCController {

    private final LivroRepository livroRepository;

    public LivroMVCController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/livros-mvc")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        return "livros";
    }
}