package br.com.jsbse.gspm.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.jsbse.arquitetura.excecao.ExcecaoInfraestrutura;
import br.com.jsbse.arquitetura.excecao.ExcecaoUsuarioNaoAutenticado;
import br.com.jsbse.gspm.mvc.model.Erro;

public class ControladorBase {

	@Autowired
	protected HttpServletRequest request;

	@ExceptionHandler(value = { ExcecaoUsuarioNaoAutenticado.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody Erro capturaExcecaoUsuarioNaoAutenticado(ExcecaoUsuarioNaoAutenticado ex, HttpServletRequest request) {
		ex.printStackTrace();

		Erro erro = new Erro();
		erro.setId(2);
		erro.setMensagemDeErro(ex.getMessage());
		return erro;
	}

	@ExceptionHandler(value = { ExcecaoInfraestrutura.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody Erro capturaExcecaoInfraestrutura(ExcecaoInfraestrutura ex, HttpServletRequest request) {
		ex.printStackTrace();

		Erro erro = new Erro();
		erro.setId(1);
		erro.setMensagemDeErro(ex.getMessage());
		return erro;
	}

//	@ExceptionHandler(value = { MensagemDeErroExeption.class })
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	public @ResponseBody Erro capturaExcecao(MensagemDeErroExeption ex, HttpServletRequest request) {
//		ex.printStackTrace();
//
//		Erro erro = new Erro();
//		erro.setId(1);
//		erro.setMensagemDeErro(ex.getMessage());
//		return erro;
//	}
	
	@ExceptionHandler(value = { RuntimeException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody Erro capturaExcecaoRunTime(RuntimeException ex, HttpServletRequest request) {
		ex.printStackTrace();
		
		Erro erro = new Erro();
		erro.setId(1);
		erro.setMensagemDeErro(ex.getMessage());
		return erro;
	}
	
	protected String getBaseUri() {
		return String.format("%s://%s:%d%s", request.getScheme(), request.getServerName(), request.getServerPort(), request.getContextPath());
	}

}
