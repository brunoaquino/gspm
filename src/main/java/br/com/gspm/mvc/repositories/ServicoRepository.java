package br.com.gspm.mvc.repositories;

import java.util.List;

import br.com.gspm.mvc.model.Servico;

public interface ServicoRepository extends Repositorio{

	public List<Servico> getServicos();

	public void salva(Servico servico);

	public void atualiza(Servico servico);

	public void exclui(Servico servico);
}
