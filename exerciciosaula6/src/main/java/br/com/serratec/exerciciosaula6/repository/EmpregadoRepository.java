package br.com.serratec.exerciciosaula6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.exerciciosaula6.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{

}
