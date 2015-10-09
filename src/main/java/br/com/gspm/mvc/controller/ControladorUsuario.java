package br.com.gspm.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gspm.mvc.model.Usuario;
import br.com.gspm.mvc.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuario")
public class ControladorUsuario extends ControladorBase {

	@Autowired
	UsuarioService service;

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	@Transactional
	public Usuario salva(Usuario usuario) {
		service.salva(usuario);
		return usuario;
	}

	@RequestMapping(value = "/atualiza", method = RequestMethod.POST)
	@Transactional
	public Usuario atualiza(Usuario usuario) {
		service.atualiza(usuario);
		return usuario;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional
	public Usuario delete(Usuario usuario) {
		service.delete(usuario);
		return usuario;
	}

	@RequestMapping(value = "/getUsuarios", method = RequestMethod.POST)
	@Transactional
	public List<Usuario> getUsuarios() {
		return service.getUsuarios();
	}
}
