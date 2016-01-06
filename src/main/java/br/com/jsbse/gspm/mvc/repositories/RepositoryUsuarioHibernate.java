package br.com.jsbse.gspm.mvc.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.jsbse.gspm.mvc.model.Administrador;
import br.com.jsbse.gspm.mvc.model.Demolay;
import br.com.jsbse.gspm.mvc.model.FilhaDeJo;
import br.com.jsbse.gspm.mvc.model.Macom;
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

	@Override
	public Demolay getDemolayPeloUsuario(Usuario usuario) {
		Session sessao = getSession();
		Criteria criteria = sessao.createCriteria(Demolay.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return (Demolay) criteria.uniqueResult();
	}

	@Override
	public Macom getMacomPeloUsuario(Usuario usuario) {
		Session sessao = getSession();
		Criteria criteria = sessao.createCriteria(Macom.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return (Macom) criteria.uniqueResult();
	}

	@Override
	public FilhaDeJo getFilhaDeJoPeloUsuario(Usuario usuario) {
		Session sessao = getSession();
		Criteria criteria = sessao.createCriteria(FilhaDeJo.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return (FilhaDeJo) criteria.uniqueResult();
	}

	@Override
	public Administrador getAdministradorPeloUsuario(Usuario usuario) {
		Session sessao = getSession();
		Criteria criteria = sessao.createCriteria(Administrador.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return (Administrador) criteria.uniqueResult();
	}
}
