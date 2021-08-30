package br.com.dio.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Pessoa {
	
	@Id
	private String cpf;
	
	@Column(nullable = false)
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "endereco")
	private String endereco; 

	@Column(name = "numero")
	private String numero;
	
	@Column(name = "complemento")
	private String complemento;

	@Column(name = "cidade")
	private String cidade;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;
	
	@CreationTimestamp
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;


}
