package br.com.gspm.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gspm.mvc.model.Cliente;
import br.com.gspm.mvc.service.ClienteService;

@RestController
@RequestMapping("/rest/cliente")
public class ControladorCliente extends ControladorBase {

	@Autowired
	ClienteService service;

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	@Transactional
	public Cliente salva(Cliente cliente) {
		service.salva(cliente);
		return cliente;
	}

	@RequestMapping(value = "/atualiza", method = RequestMethod.POST)
	@Transactional
	public Cliente atualiza(Cliente cliente) {
		service.atualiza(cliente);
		return cliente;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional
	public Cliente delete(Cliente cliente) {
		service.delete(cliente);
		return cliente;
	}

	@RequestMapping(value = "/getClientes", method = RequestMethod.POST)
	@Transactional
	public List<Cliente> getClientes() {
		return service.getClientes();
	}
}
