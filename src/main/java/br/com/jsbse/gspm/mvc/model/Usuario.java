package br.com.jsbse.gspm.mvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import br.com.jsbse.arquitetura.entidade.Entidade;
import br.com.jsbse.gspm.mvc.tipos.TipoUsuario;

@Entity
@Table(name = "usuario")
public class Usuario extends Entidade<String> {

	private String email;
	private String login;
	private String senha;
	private boolean ativo;
	private boolean admin;
	private Date dataDeCadastro;
	private Date dataDeAlteracao;
	private TipoUsuario tipo;

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "base.util.UUIDGenerator")
	@Column(name = "idusuario", length = 32)
	@Override
	public String getId() {
		return super.getId();
	}

	@Column(name = "login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "senha")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ativo")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "admin")
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Column(name = "datadecadastro")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Column(name = "datadealteracao")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(Date dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

	@Column(name = "tipo")
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public br.com.jsbse.gspm.mvc.model.interfaces.UsuarioTipo getTipoDoUsuario() {
		if (getTipo() == TipoUsuario.DEMOLAY) {

		}
		if (getTipo() == TipoUsuario.FILHA_DE_JO) {

		}
		if (getTipo() == TipoUsuario.MACOM) {

		}
		return new Demolay();
	}

}
