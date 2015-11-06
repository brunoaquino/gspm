package br.com.jsbse.gspm.mvc.service;

import org.springframework.stereotype.Service;

import br.com.jsbse.gspm.mvc.aplicacao.Aplicacao;
import br.com.jsbse.gspm.mvc.repositories.Repositorio;

@Service
public class ServicoBase {
	
	protected <T extends Repositorio> T getRepositorio( Class<T> interfaceDoRepositorio) {
		return Aplicacao.get().getRepositorio(interfaceDoRepositorio);
	}
}
