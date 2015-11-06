package br.com.jsbse.gspm.mvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "servico")
public class Servico {

	private int id;
	private double preco;
	private String nome;
	private String descricao;

	private Set<OrdemDeServico> ordensDeServico = new HashSet<OrdemDeServico>(0);

	// private Set<Funcionario> servicos = new HashSet<Funcionario>(0);

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "servico_id", nullable = false)
	@GeneratedValue(generator = "generator")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "doub_preco")
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Column(name = "text_nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "text_descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "servicos")
	public Set<OrdemDeServico> getOrdensDeServico() {
		return ordensDeServico;
	}

	public void setOrdensDeServico(Set<OrdemDeServico> ordensDeServico) {
		this.ordensDeServico = ordensDeServico;
	}

	// @ManyToMany(fetch = FetchType.LAZY, mappedBy = "servico")
	// public Set<Funcionario> getServicos() {
	// return servicos;
	// }
	//
	// public void setServicos(Set<Funcionario> servicos) {
	// this.servicos = servicos;
	// }

}
