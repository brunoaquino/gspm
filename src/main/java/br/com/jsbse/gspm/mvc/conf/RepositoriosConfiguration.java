package br.com.jsbse.gspm.mvc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jsbse.gspm.mvc.repositories.RepositoryUsuario;
import br.com.jsbse.gspm.mvc.repositories.RepositoryUsuarioHibernate;

@Configuration
public class RepositoriosConfiguration {

	@Bean(name = "repositoryUsuario")
	public RepositoryUsuario getUsuarioRepository() {
		return new RepositoryUsuarioHibernate();
	}

}
