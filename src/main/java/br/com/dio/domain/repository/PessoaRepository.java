package br.com.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dio.domain.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

}
