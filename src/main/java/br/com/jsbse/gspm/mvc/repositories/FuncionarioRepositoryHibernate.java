package br.com.jsbse.gspm.mvc.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jsbse.gspm.mvc.model.Funcionario;

@Repository
public class FuncionarioRepositoryHibernate extends RepositoryBase implements
		FuncionarioRepository {

	@Override
	public List<Funcionario> getFuncionarios() {
		return this.hibernateTemplate.loadAll(Funcionario.class);
	}

	@Override
	public void salva(Funcionario funcionario) {
		this.hibernateTemplate.save(funcionario);
	}

	@Override
	public void atualiza(Funcionario funcionario) {
		this.hibernateTemplate.update(funcionario);
	}

	@Override
	public void exclui(Funcionario funcionario) {
		this.hibernateTemplate.delete(funcionario);
	}

	@Override
	public Funcionario get(int id) {
		return this.hibernateTemplate.get(Funcionario.class, id);
	}
}
