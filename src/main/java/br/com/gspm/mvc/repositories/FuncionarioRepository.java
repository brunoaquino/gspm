package br.com.gspm.mvc.repositories;

import java.util.List;

import br.com.gspm.mvc.model.Funcionario;

public interface FuncionarioRepository extends Repositorio {

	public List<Funcionario> getFuncionarios();

	public void salva(Funcionario funcionario);

	public void atualiza(Funcionario funcionario);

	public void exclui(Funcionario funcionario);
	
	public Funcionario get(int id);
}
