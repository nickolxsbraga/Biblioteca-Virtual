package br.edu.pi.biblioteca.controller;

import br.edu.pi.biblioteca.model.Leitor;
import br.edu.pi.biblioteca.repository.LeitorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/api/leitores")
@Controller
public class LeitorController {

    private final LeitorRepository leitorRepository;

    public LeitorController(LeitorRepository leitorRepository) {
        this.leitorRepository = leitorRepository;
    }

    @PostMapping
    public Leitor salvar(@RequestBody Leitor leitor) {
        return leitorRepository.save(leitor);
    }

    @GetMapping
    public List<Leitor> listar() {
        return leitorRepository.findAll();
    }
}
