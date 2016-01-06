package br.com.jsbse.gspm.mvc.repositories;

import java.util.List;

import br.com.jsbse.arquitetura.integracao.Repositorio;
import br.com.jsbse.gspm.mvc.model.Administrador;
import br.com.jsbse.gspm.mvc.model.Demolay;
import br.com.jsbse.gspm.mvc.model.FilhaDeJo;
import br.com.jsbse.gspm.mvc.model.Macom;
import br.com.jsbse.gspm.mvc.model.Usuario;

public interface RepositoryUsuario extends Repositorio {

	public List<Usuario> getUsuarios();

	public Usuario getUsuarioPeloLoginESenha(Usuario usuario);

	public Usuario getUsuarioPorEmail(String email);

	public Usuario getUsuarioPorLogin(String login);

	public List<Usuario> getUsuariosPorEmail(String email);

	public List<Usuario> getUsuariosPorLogin(String login);

	public Demolay getDemolayPeloUsuario(Usuario usuario);

	public Macom getMacomPeloUsuario(Usuario usuario);

	public FilhaDeJo getFilhaDeJoPeloUsuario(Usuario usuario);

	public Administrador getAdministradorPeloUsuario(Usuario usuario);
}
