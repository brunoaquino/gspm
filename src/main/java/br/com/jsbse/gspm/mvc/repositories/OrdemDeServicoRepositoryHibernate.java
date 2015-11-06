package br.com.jsbse.gspm.mvc.repositories;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.jsbse.gspm.mvc.model.FiltroOrdemDeServico;
import br.com.jsbse.gspm.mvc.model.OrdemDeServico;
import br.com.jsbse.gspm.mvc.util.UtilData;

@Repository
public class OrdemDeServicoRepositoryHibernate extends RepositoryBase implements
		OrdemDeServicoRepository {

	@Override
	public List<OrdemDeServico> getOrdensDeServico() {
		return this.hibernateTemplate.loadAll(OrdemDeServico.class);
	}

	@Override
	public void salva(OrdemDeServico os) {
		this.hibernateTemplate.save(os);
	}

	@Override
	public void atualiza(OrdemDeServico os) {
		this.hibernateTemplate.update(os);
	}

	@Override
	public void exclui(OrdemDeServico os) {
		this.hibernateTemplate.delete(os);
	}

	@Override
	public OrdemDeServico get(int id) {
		return this.hibernateTemplate.get(OrdemDeServico.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdemDeServico> getOrdensDeServicoPorFiltro(FiltroOrdemDeServico filtro) {
		Session sessao = getSession();
		Criteria criteria = sessao.createCriteria(OrdemDeServico.class);
		
		if (filtro.getDataDeAgendamentoInicial() != null && filtro.getDataDeAgendamentoFim()!= null) {
			criteria.add(Restrictions.between("dataDeAgendamento", filtro.getDataDeAgendamentoInicial(), UtilData.getDataAdicionadaEmDias(filtro.getDataDeAgendamentoInicial(), 1)));
		} else if (filtro.getDataDeAgendamentoFim() != null) {
			criteria.add(Restrictions.ge("dataDeAgendamento", filtro.getDataDeAgendamentoFim()));
		} else if (filtro.getDataDeAgendamentoFim() != null) {
			criteria.add(Restrictions.le("dataDeAgendamento", UtilData.getDataAdicionadaEmDias(filtro.getDataDeAgendamentoFim(), 1)));
		}else{
			criteria.add(Restrictions.ge("dataDeAgendamento", new Date()));
		}
		
		criteria.addOrder(Order.desc("dataDeAgendamento"));
		
		return criteria.list();
	}
}
