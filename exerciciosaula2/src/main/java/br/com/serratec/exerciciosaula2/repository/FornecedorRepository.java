package br.com.serratec.exerciciosaula2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.exerciciosaula2.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
