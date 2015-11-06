package br.com.jsbse.gspm.mvc.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "empresa")
public class Empresa {

	private int id;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private String email;
	private String endereco;
	private boolean ativo;
	private String cep;
	private String observacoes;
	private Date dataDeCadastro;
	private Date dataDeAlteracao;
	private Set<Usuario> usuarios;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "empresa_id", nullable = false)
	@GeneratedValue(generator = "generator")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "text_nomeFantasia")
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Column(name = "text_razaoSocial")
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(name = "text_cnpj")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "text_telefone")
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "text_email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "text_endereco")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "bool_ativo")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "text_cep")
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "text_observacoes")
	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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

	@OneToMany(mappedBy = "empresa", targetEntity = Usuario.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
