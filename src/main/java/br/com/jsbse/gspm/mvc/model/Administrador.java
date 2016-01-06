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
@Table(name = "administrador")
public class Administrador extends Entidade<String> implements UsuarioTipo {

	private Usuario usuario;
	private String nome;

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "base.util.UUIDGenerator")
	@Column(name = "idadministrador", length = 32)
	@Override
	public String getId() {
		return super.getId();
	}

	@OneToOne
	@JoinColumn(name = "idusuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
