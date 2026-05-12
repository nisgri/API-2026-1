package br.com.serratec.exerciciosaula2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.exerciciosaula2.entity.Fornecedor;
import br.com.serratec.exerciciosaula2.repository.FornecedorRepository;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor inserir(@RequestBody Fornecedor fornecedor) {
        return repository.save(fornecedor);
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
