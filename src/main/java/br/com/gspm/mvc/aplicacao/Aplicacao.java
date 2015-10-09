package br.com.gspm.mvc.aplicacao;

import br.com.gspm.mvc.repositories.FabricaDeRepositorios;
import br.com.gspm.mvc.repositories.Repositorio;

//@Component
public class Aplicacao {

	private static Aplicacao instancia;

	// @Resource(name = "fabricaDeRepositoriosFactory")
	public FabricaDeRepositorios fabricaDeRepositorios;

	public static Aplicacao get() {
		if (instancia == null) {
			instancia = new Aplicacao();
		}

		return instancia;
	}

	@SuppressWarnings("unchecked")
	public <T extends Repositorio> T getRepositorio(
			Class<? extends Repositorio> interfaceDoRepositorio) {
		return (T) fabricaDeRepositorios.getRepositorio(interfaceDoRepositorio);
	}

}
