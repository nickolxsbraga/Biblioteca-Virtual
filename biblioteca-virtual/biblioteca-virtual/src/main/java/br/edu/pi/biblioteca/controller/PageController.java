package br.edu.pi.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro-livro")
    public String cadastroLivro() {
        return "cadastro-livro";
    }

    @GetMapping("/cadastro-leitor")
    public String cadastroLeitor() {
        return "cadastro-leitor";
    }

    @GetMapping("/reserva")
    public String reserva() {
        return "reserva";
    }
}