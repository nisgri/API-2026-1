package br.com.serratec.exerciciosaula6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.exerciciosaula6.model.Setor;
import br.com.serratec.exerciciosaula6.repository.SetorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/setores")
public class SetorController {
    @Autowired
    private SetorRepository repository;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Setor inserir(@Valid @RequestBody Setor setor) {
        return repository.save(setor);
    }

    @PutMapping("{id}")
    public ResponseEntity<Setor> alterar(@Valid @RequestBody Setor setor, @PathVariable Long id) {
        if(repository.existsById(id)) {
            setor.setId(id);
            return ResponseEntity.ok(repository.save(setor));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Setor> listar() {
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
