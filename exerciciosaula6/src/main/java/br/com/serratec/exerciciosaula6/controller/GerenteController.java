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

import br.com.serratec.exerciciosaula6.model.Gerente;
import br.com.serratec.exerciciosaula6.repository.GerenteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {
    @Autowired
    private GerenteRepository repository;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gerente inserir(@Valid @RequestBody Gerente gerente) {
        return repository.save(gerente);
    }

    @PutMapping("{id}")
    public ResponseEntity<Gerente> alterar(@Valid @RequestBody Gerente gerente, @PathVariable Long id) {
        if(repository.existsById(id)) {
            gerente.setId(id);
            return ResponseEntity.ok(repository.save(gerente));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Gerente> listar() {
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
