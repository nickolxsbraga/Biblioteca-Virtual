package br.edu.pi.biblioteca.controller;

import br.edu.pi.biblioteca.model.Autor;
import br.edu.pi.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public Autor cadastrar(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @GetMapping
    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Autor buscarPorId(@PathVariable Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Autor atualizar(@PathVariable Long id, @RequestBody Autor autorAtualizado) {
        return autorRepository.findById(id).map(autor -> {
            autor.setNome(autorAtualizado.getNome());
            autor.setBiografia(autorAtualizado.getBiografia());
            return autorRepository.save(autor);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        autorRepository.deleteById(id);
    }
}