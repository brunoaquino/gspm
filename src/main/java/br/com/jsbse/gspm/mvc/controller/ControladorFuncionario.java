package br.com.jsbse.gspm.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsbse.gspm.mvc.model.Funcionario;
import br.com.jsbse.gspm.mvc.service.FuncionarioService;

@RestController
@RequestMapping("/rest/funcionario")
public class ControladorFuncionario extends ControladorBase {

	@Autowired
	FuncionarioService service;

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	@Transactional
	public Funcionario salva(Funcionario funcionario) {
		service.salva(funcionario);
		return funcionario;
	}

	@RequestMapping(value = "/atualiza", method = RequestMethod.POST)
	@Transactional
	public Funcionario atualiza(Funcionario funcionario) {
		service.atualiza(funcionario);
		return funcionario;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional
	public Funcionario delete(Funcionario funcionario) {
		service.delete(funcionario);
		return funcionario;
	}

	@RequestMapping(value = "/getFuncionarios", method = RequestMethod.POST)
	@Transactional
	public List<Funcionario> getFuncionarios() {
		return service.getFuncionarios();
	}
}
