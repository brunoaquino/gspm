package br.com.jsbse.gspm.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.jsbse.arquitetura.entidade.Entidade;
import br.com.jsbse.gspm.mvc.model.interfaces.UsuarioTipo;

@Entity
@Table(name = "demolay")
public class Demolay extends Entidade<String> implements UsuarioTipo {

	private int idDm;
	private Pessoa pessoa;
	private Usuario usuario;

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "base.util.UUIDGenerator")
	@Column(name = "iddemolay", length = 32)
	@Override
	public String getId() {
		return super.getId();
	}

	@OneToOne
	@JoinColumn(name = "idpessoa")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@OneToOne
	@JoinColumn(name = "idusuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "iddm")
	public int getIdDm() {
		return idDm;
	}

	public void setIdDm(int idDm) {
		this.idDm = idDm;
	}

}
