package br.com.jsbse.gspm.mvc.model;

import java.util.Date;

public class FiltroOrdemDeServico {
	private Date dataDeAgendamentoInicial;
	private Date dataDeAgendamentoFim;

	public Date getDataDeAgendamentoInicial() {
		return dataDeAgendamentoInicial;
	}

	public void setDataDeAgendamentoInicial(Date dataDeAgendamentoInicial) {
		this.dataDeAgendamentoInicial = dataDeAgendamentoInicial;
	}

	public Date getDataDeAgendamentoFim() {
		return dataDeAgendamentoFim;
	}

	public void setDataDeAgendamentoFim(Date dataDeAgendamentoFim) {
		this.dataDeAgendamentoFim = dataDeAgendamentoFim;
	}

}
