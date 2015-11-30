package br.com.jsbse.gspm.mvc.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.jsbse.arquitetura.servico.ServicoBase;
import br.com.jsbse.gspm.mvc.model.Cliente;
import br.com.jsbse.gspm.mvc.repositories.ClienteRepository;

@Service
public class ClienteService extends ServicoBase {

	@Resource(name = "clienteRepository")
	public ClienteRepository clienteRepository;

	public void salva(Cliente cliente) {
		validaCliente(cliente);
		cliente.setDataDeCadastro(new Date());
		cliente.setDataDeAlteracao(new Date());
		clienteRepository.salva(cliente);
	}

	private void validaCliente(Cliente cliente) {
		if (cliente.getNome() == null) {
//			throw new MensagemDeErroExeption("Nome é Obrigatório");
		}
		if (cliente.getCpfCnpj() == null) {
//			throw new MensagemDeErroExeption("CPF é Obrigatório");
		}
	}

	public void atualiza(Cliente cliente) {
		validaCliente(cliente);
		cliente.setDataDeAlteracao(new Date());
		clienteRepository.atualiza(cliente);
	}

	public List<Cliente> getClientes() {
		return clienteRepository.getClientes();
	}

	public void delete(Cliente cliente) {
		clienteRepository.exclui(cliente);
	}

}
