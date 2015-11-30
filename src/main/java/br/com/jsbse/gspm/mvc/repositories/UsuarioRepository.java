package br.com.jsbse.gspm.mvc.repositories;

import java.util.List;

import br.com.jsbse.arquitetura.integracao.Repositorio;
import br.com.jsbse.gspm.mvc.model.Usuario;

public interface UsuarioRepository extends Repositorio{

	public List<Usuario> getUsuarios();

	public Usuario getUsuarioPeloLoginESenha(Usuario usuario);

	public void salva(Usuario usuario);

	public void atualiza(Usuario usuario);

	public void exclui(Usuario usuario);

	public Usuario getUsuarioPorEmail(String email);

	public Usuario getUsuarioPorLogin(String login);

	public List<Usuario> getUsuariosPorEmail(String email);

	public List<Usuario> getUsuariosPorLogin(String login);
}
