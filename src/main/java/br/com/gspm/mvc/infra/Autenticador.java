package br.com.gspm.mvc.infra;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gspm.mvc.model.Usuario;

@Component
public class Autenticador {
	
	@Autowired
	protected HttpServletRequest request;
	
	private static final String USUARIO_LOGADO = "UsuarioLogado";
	
	public void autenticaUsuarioNaSessao(Usuario usuario) {
		request.getSession().setAttribute(USUARIO_LOGADO, usuario);
	}
	
	public void getUsuarioNaSessao() {
		request.getSession().getAttribute(USUARIO_LOGADO);
	}
	
	public void removeUsuarioNaSessao() {
		request.getSession().removeAttribute(USUARIO_LOGADO);
	}

}
