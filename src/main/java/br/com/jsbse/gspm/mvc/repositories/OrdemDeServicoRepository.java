package br.com.jsbse.gspm.mvc.repositories;

import java.util.List;

import br.com.jsbse.arquitetura.integracao.Repositorio;
import br.com.jsbse.gspm.mvc.model.FiltroOrdemDeServico;
import br.com.jsbse.gspm.mvc.model.OrdemDeServico;

public interface OrdemDeServicoRepository extends Repositorio {

	public List<OrdemDeServico> getOrdensDeServico();

	public void salva(OrdemDeServico os);

	public void atualiza(OrdemDeServico os);

	public void exclui(OrdemDeServico os);

	public OrdemDeServico get(int os);

	public List<OrdemDeServico> getOrdensDeServicoPorFiltro(FiltroOrdemDeServico filtro);
}
