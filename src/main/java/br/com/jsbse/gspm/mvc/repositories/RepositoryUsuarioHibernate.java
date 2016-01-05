package br.com.jsbse.gspm.mvc.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.jsbse.gspm.mvc.model.Usuario;

@Repository
public class RepositoryUsuarioHibernate extends RepositoryBase implements RepositoryUsuario {

	@Override
	public List<Usuario> getUsuarios() {
		return this.hibernateTemplate.loadAll(Usuario.class);
	}

	@Override
	public Usuario getUsuarioPeloLoginESenha(Usuario usuario) {
		Session sessao = getSession();

		Criteria criteria = sessao.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", usuario.getLogin()));
		criteria.add(Restrictions.eq("senha", usuario.getSenha()));

		Usuario usuarioAutenticado = (Usuario) criteria.uniqueResult();
		sessao.close();

		return usuarioAutenticado;
	}

	@Override
	public Usuario getUsuarioPorEmail(String email) {
		Session sessao = getSession();

		Criteria criteria = sessao.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", email));

		Usuario usuarioAutenticado = (Usuario) criteria.uniqueResult();
		sessao.close();

		return usuarioAutenticado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuariosPorEmail(String email) {
		Session sessao = getSession();

		Criteria criteria = sessao.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", email));

		List<Usuario> listaDeUsuarios = (List<Usuario>) criteria.list();
		sessao.close();

		return listaDeUsuarios;
	}

	@Override
	public Usuario getUsuarioPorLogin(String login) {
		Session sessao = getSession();

		Criteria criteria = sessao.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", login));

		Usuario usuarioAutenticado = (Usuario) criteria.uniqueResult();
		sessao.close();

		return usuarioAutenticado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuariosPorLogin(String login) {
		Session sessao = getSession();

		Criteria criteria = sessao.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", login));

		List<Usuario> listaDeUsuarios = (List<Usuario>) criteria.list();
		sessao.close();

		return listaDeUsuarios;
	}
}
