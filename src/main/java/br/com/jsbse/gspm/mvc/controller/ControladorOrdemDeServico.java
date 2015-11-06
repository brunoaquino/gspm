package br.com.jsbse.gspm.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsbse.gspm.mvc.model.FiltroOrdemDeServico;
import br.com.jsbse.gspm.mvc.model.OrdemDeServico;
import br.com.jsbse.gspm.mvc.service.OrdemDeServicoService;

@RestController
@RequestMapping("/rest/ordemDeServico")
public class ControladorOrdemDeServico extends ControladorBase {

	@Autowired
	OrdemDeServicoService service;

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	@Transactional
	public OrdemDeServico salva(OrdemDeServico os) {
		service.salva(os);
		return os;
	}

	@RequestMapping(value = "/atualiza", method = RequestMethod.POST)
	@Transactional
	public OrdemDeServico atualiza(OrdemDeServico os) {
		service.atualiza(os);
		return os;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional
	public OrdemDeServico delete(OrdemDeServico os) {
		service.delete(os);
		return os;
	}

	@RequestMapping(value = "/getOrdensDeServico", method = RequestMethod.POST)
	@Transactional
	public List<OrdemDeServico> getOrdemDeServicos() {
		return service.getOrdensDeServico();
	}

	@RequestMapping(value = "/getOrdensDeServicoPorFiltro", method = RequestMethod.POST)
	@Transactional
	public List<OrdemDeServico> getOrdensDeServicoPorFiltro(FiltroOrdemDeServico filtro) {
		return service.getOrdensDeServicoPorFiltro(filtro);
	}
}
