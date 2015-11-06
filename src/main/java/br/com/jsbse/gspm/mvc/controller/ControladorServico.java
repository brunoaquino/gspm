package br.com.jsbse.gspm.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsbse.gspm.mvc.model.Servico;
import br.com.jsbse.gspm.mvc.service.ServicoService;

@RestController
@RequestMapping("/rest/servico")
public class ControladorServico extends ControladorBase {

	@Autowired
	ServicoService service;

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	@Transactional
	public Servico salva(Servico servico) {
		service.salva(servico);
		return servico;
	}

	@RequestMapping(value = "/atualiza", method = RequestMethod.POST)
	@Transactional
	public Servico atualiza(Servico servico) {
		service.atualiza(servico);
		return servico;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional
	public Servico delete(Servico servico) {
		service.delete(servico);
		return servico;
	}

	@RequestMapping(value = "/getServicos", method = RequestMethod.POST)
	@Transactional
	public List<Servico> getServicos() {
		return service.getServicos();
	}
}
