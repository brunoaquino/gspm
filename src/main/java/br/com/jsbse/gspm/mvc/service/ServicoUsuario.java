package br.com.jsbse.gspm.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsbse.arquitetura.servico.ServicoBase;
import br.com.jsbse.gspm.mvc.infra.Autenticador;
import br.com.jsbse.gspm.mvc.model.Usuario;
import br.com.jsbse.gspm.mvc.repositories.RepositoryUsuario;
import br.com.jsbse.jsbse.aplicacao.Aplicacao;

@Service
public class ServicoUsuario extends ServicoBase {
	@Autowired
	Autenticador autenticador;

	private RepositoryUsuario getRepositorioUsuario() {
		return Aplicacao.get().getRepositorio(RepositoryUsuario.class);
	}

	public Usuario autenticaUsuario(Usuario usuario) {
		Usuario usuarioAutenticado = getRepositorioUsuario().getUsuarioPeloLoginESenha(usuario);
		if (usuarioAutenticado == null) {
			acrescentaMensagemDeErro("Login ou Senha inválido");
		}
		levantaExcecaoSeTemErro();

		autenticador.autenticaUsuarioNaSessao(usuarioAutenticado);

		return usuarioAutenticado;
	}

	public void logout() {
		autenticador.removeUsuarioNaSessao();
	}
}
