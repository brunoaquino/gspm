package br.com.jsbse.gspm.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.jsbse.arquitetura.entidade.Entidade;

@Entity
@Table(name = "pessoa")
public class Pessoa extends Entidade<String> {

	private String nome;
	private int idade;

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "base.util.UUIDGenerator")
	@Column(name = "idpessoa", length = 32)
	@Override
	public String getId() {
		return super.getId();
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "idade")
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
