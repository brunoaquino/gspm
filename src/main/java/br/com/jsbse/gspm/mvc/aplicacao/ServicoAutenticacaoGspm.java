package br.com.jsbse.gspm.mvc.aplicacao;

import org.springframework.stereotype.Service;

import br.com.jsbse.arquitetura.excecao.ExcecaoInfraestrutura;
import br.com.jsbse.jsbse.aplicacao.ServicoAutenticacao;
import br.com.jsbse.jsbse.aplicacao.UsuarioBase;

@Service("servicoAutenticacao")
public class ServicoAutenticacaoGspm implements ServicoAutenticacao {

	@Override
	public UsuarioBase getUsuarioBasePeloLogin(String login) throws ExcecaoInfraestrutura {
		return null;
	}

}
