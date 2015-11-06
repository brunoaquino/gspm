package br.com.jsbse.gspm.mvc.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jsbse.gspm.mvc.model.Cliente;

@Repository
public class ClienteRepositoryHibernate extends RepositoryBase implements
		ClienteRepository {

	@Override
	public List<Cliente> getClientes() {
		return this.hibernateTemplate.loadAll(Cliente.class);
	}

	@Override
	public void salva(Cliente cliente) {
		this.hibernateTemplate.save(cliente);
	}

	@Override
	public void atualiza(Cliente cliente) {
		this.hibernateTemplate.update(cliente);
	}

	@Override
	public void exclui(Cliente cliente) {
		this.hibernateTemplate.delete(cliente);
	}

	@Override
	public Cliente get(int id) {
		return this.hibernateTemplate.get(Cliente.class, id);
	}
}
