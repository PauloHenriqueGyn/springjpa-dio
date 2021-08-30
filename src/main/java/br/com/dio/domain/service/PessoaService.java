package br.com.dio.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.dio.domain.exception.EntidadeEmUsoException;
import br.com.dio.domain.exception.EntidadeNaoEncontradaException;
import br.com.dio.domain.model.Pessoa;
import br.com.dio.domain.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void excluir(String pessoaId) {
		try {
			pessoaRepository.deleteById(pessoaId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de pessoa com código %d", pessoaId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Pessoa de código %d não pode ser removido, pois está em uso", pessoaId));
		}
	}
}
