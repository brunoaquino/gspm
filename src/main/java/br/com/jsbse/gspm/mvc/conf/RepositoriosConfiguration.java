package br.com.jsbse.gspm.mvc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jsbse.gspm.mvc.repositories.ClienteRepository;
import br.com.jsbse.gspm.mvc.repositories.ClienteRepositoryHibernate;
import br.com.jsbse.gspm.mvc.repositories.FuncionarioRepository;
import br.com.jsbse.gspm.mvc.repositories.FuncionarioRepositoryHibernate;
import br.com.jsbse.gspm.mvc.repositories.OrdemDeServicoRepository;
import br.com.jsbse.gspm.mvc.repositories.OrdemDeServicoRepositoryHibernate;
import br.com.jsbse.gspm.mvc.repositories.ServicoRepository;
import br.com.jsbse.gspm.mvc.repositories.ServicoRepositoryHibernate;
import br.com.jsbse.gspm.mvc.repositories.UsuarioRepository;
import br.com.jsbse.gspm.mvc.repositories.UsuarioRepositoryHibernate;

@Configuration
public class RepositoriosConfiguration {

	@Bean(name = "usuarioRepository")
	public UsuarioRepository getUsuarioRepository() {
		return new UsuarioRepositoryHibernate();
	}

//	@Bean(name = "fabricaDeRepositoriosFactory")
//	public FabricaDeRepositorios getFabricaDeRepositorios() {
//		return new FabricaDeRepositoriosFactory();
//	}

	@Bean(name = "servicoRepository")
	public ServicoRepository getServicoRepository() {
		return new ServicoRepositoryHibernate();
	}

	@Bean(name = "funcionarioRepository")
	public FuncionarioRepository getFuncionarioRepository() {
		return new FuncionarioRepositoryHibernate();
	}

	@Bean(name = "clienteRepository")
	public ClienteRepository getClienteRepository() {
		return new ClienteRepositoryHibernate();
	}

	@Bean(name = "ordemDeServicoRepository")
	public OrdemDeServicoRepository getOrdemDeServicoRepository() {
		return new OrdemDeServicoRepositoryHibernate();
	}

}