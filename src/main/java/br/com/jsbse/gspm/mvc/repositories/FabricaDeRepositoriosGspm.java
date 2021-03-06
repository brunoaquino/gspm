package br.com.jsbse.gspm.mvc.repositories;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import br.com.jsbse.arquitetura.integracao.FabricaDeRepositorios;
import br.com.jsbse.arquitetura.integracao.Repositorio;

@Component("fabricaDeRepositorios")
public class FabricaDeRepositoriosGspm extends FabricaDeRepositorios {

	@Resource(name = "repositoryUsuario")
	public RepositoryUsuario usuarioRepository;

	@Override
	protected void doPopulaDefinicoesDeRepositorio(Map<Class<? extends Repositorio>, Repositorio> definicoesDosRepositorios) {
		definicoesDosRepositorios.put(RepositoryUsuario.class, usuarioRepository);
	}

}
