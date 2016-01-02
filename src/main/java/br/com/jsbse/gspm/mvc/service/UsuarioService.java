package br.com.jsbse.gspm.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jsbse.arquitetura.servico.ServicoBase;
import br.com.jsbse.gspm.mvc.infra.Autenticador;
import br.com.jsbse.gspm.mvc.model.Usuario;
import br.com.jsbse.gspm.mvc.repositories.UsuarioRepository;
import br.com.jsbse.jsbse.aplicacao.Aplicacao;

@Service
public class UsuarioService extends ServicoBase {
	@Autowired
	Autenticador autenticador;
	
	private UsuarioRepository getRepositorioUsuario() {
		 return Aplicacao.get().getRepositorio(UsuarioRepository.class);
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

	public void salva(Usuario usuario) {
		validaUsuarioSalvar(usuario);

		if (usuario.getId() == null) {
			usuario.setAtivo(true);
		}
		getRepositorioUsuario().salva(usuario);
	}

	public void atualiza(Usuario usuario) {
		validaUsuarioAtualiza(usuario);

		getRepositorioUsuario().atualiza(usuario);
	}

	public List<Usuario> getUsuarios() {
		return getRepositorioUsuario().getUsuarios();
	}

	private void validaUsuarioSalvar(Usuario usuario) {
		Usuario usuarioEncontrado;

		usuarioEncontrado = getRepositorioUsuario().getUsuarioPorEmail(usuario
				.getEmail());

		if (usuarioEncontrado != null) {
//			throw new MensagemDeErroExeption("Usuário com o email: '"
//					+ usuario.getEmail() + "' já foi cadastrado");
		}

		usuarioEncontrado = getRepositorioUsuario().getUsuarioPorLogin(usuario
				.getLogin());

		if (usuarioEncontrado != null) {
//			throw new MensagemDeErroExeption("Usuário com o login: '"
//					+ usuario.getLogin() + "' já foi cadastrado");
		}
	}

	private void validaUsuarioAtualiza(Usuario usuario) {
		List<Usuario> usuariosEncontrados;

		usuariosEncontrados = getRepositorioUsuario().getUsuariosPorEmail(usuario
				.getEmail());

		if (usuariosEncontrados.size() > 1) {
//			throw new MensagemDeErroExeption("Usuário com o email: '"
//					+ usuario.getEmail() + "' já foi cadastrado");
		}

		usuariosEncontrados = getRepositorioUsuario().getUsuariosPorLogin(usuario
				.getLogin());

		if (usuariosEncontrados.size() > 1) {
//			throw new MensagemDeErroExeption("Usuário com o login: '"
//					+ usuario.getLogin() + "' já foi cadastrado");
		}
	}

	public void delete(Usuario usuario) {
		getRepositorioUsuario().exclui(usuario);
	}

}
