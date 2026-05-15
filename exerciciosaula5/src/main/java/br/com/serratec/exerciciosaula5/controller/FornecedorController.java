package br.com.serratec.exerciciosaula5.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.serratec.exerciciosaula5.entity.Fornecedor;
import br.com.serratec.exerciciosaula5.repository.FornecedorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor inserir(@Valid @RequestBody Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    @PostMapping("/listas")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Fornecedor> inserir(@Valid @RequestBody List<Fornecedor> fornecedores) {
        return repository.saveAll(fornecedores);
    }

    @PutMapping("{id}")
    public ResponseEntity<Fornecedor> atualizar(@Valid @RequestBody Fornecedor fornecedor, @PathVariable Long id) {
        Optional<Fornecedor> produtoOptional= repository.findById(id);
        if(produtoOptional.isPresent()) {
            fornecedor.setId(id);
            return ResponseEntity.ok(repository.save(fornecedor));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Fornecedor> apagar(@PathVariable Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Fornecedor> listar() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> buscar(@PathVariable Long id) {
        Optional<Fornecedor> fornecedor= repository.findById(id);
        if(fornecedor.isPresent()) {
            return ResponseEntity.ok(fornecedor.get());
        }
        return ResponseEntity.notFound().build();
    }
}
