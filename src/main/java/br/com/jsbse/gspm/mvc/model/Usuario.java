package br.com.jsbse.gspm.mvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "usuario")
public class Usuario {

	private Long id;
	private String email;
	private String login;
	private String senha;
	private boolean ativo;
	private boolean admin;
	private Empresa empresa;
	private Date dataDeCadastro;
	private Date dataDeAlteracao;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "usuario_id", nullable = false)
	@GeneratedValue(generator = "generator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "text_email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "text_senha", length = 12)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "bool_ativo")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "text_login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name = "bool_admin")
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
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

}
