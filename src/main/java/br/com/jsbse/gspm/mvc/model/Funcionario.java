package br.com.jsbse.gspm.mvc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private String telefone;
	private String celular;
	private String endereco;
	private String cep;
	private String estado;
	private String bairro;
	private String email;
	private String observacoes;
	private Date dataDeCadastro;
	private Date dataDeAlteracao;
	private Date dataDeNascimento;
	private Set<OrdemDeServico> ordensDeServico;

	// private Set<Servico> servicos = new HashSet<Servico>();

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "funcionario_id", nullable = false)
	@GeneratedValue(generator = "generator")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "text_nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "text_cpf")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "text_rg")
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Column(name = "text_endereco")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "text_cep")
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "text_estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "text_bairro")
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "text_email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "text_observacoes")
	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Column(name = "text_telefone")
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "text_celular")
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Column(name = "dataDeCadastro")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Column(name = "dataDeAlteracao")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(Date dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

	@Column(name = "dataDeNascimento")
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
	public Set<OrdemDeServico> getOrdensDeServico() {
		if (ordensDeServico == null) {
			ordensDeServico = new HashSet<OrdemDeServico>();
		}
		return ordensDeServico;
	}

	public void setOrdensDeServico(Set<OrdemDeServico> ordensDeServico) {
		this.ordensDeServico = ordensDeServico;
	}

	// @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
	// CascadeType.MERGE })
	// @JoinTable(name = "funcionario_servico", joinColumns = @JoinColumn(name =
	// "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
	// public Set<Servico> getServicos() {
	// if (servicos == null) {
	// servicos = new HashSet<Servico>();
	// }
	// return servicos;
	// }
	//
	// public void setServicos(Set<Servico> servicos) {
	// this.servicos = servicos;
	// }
}
