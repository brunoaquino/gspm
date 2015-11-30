package br.com.jsbse.gspm.mvc.repositories;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import br.com.jsbse.arquitetura.integracao.FabricaDeRepositorios;
import br.com.jsbse.arquitetura.integracao.Repositorio;

@Component("fabricaDeRepositorios")
public class FabricaDeRepositoriosGspm extends FabricaDeRepositorios {

	@Resource(name = "usuarioRepository")
	public UsuarioRepository usuarioRepository;

	@Resource(name = "funcionarioRepository")
	public FuncionarioRepository funcionarioRepository;

	@Resource(name = "clienteRepository")
	public ClienteRepository clienteRepository;

	@Resource(name = "servicoRepository")
	public ServicoRepository servicoRepository;

	@Override
	protected void doPopulaDefinicoesDeRepositorio(Map<Class<? extends Repositorio>, Repositorio> definicoesDosRepositorios) {
		definicoesDosRepositorios.put(UsuarioRepository.class, usuarioRepository);
		definicoesDosRepositorios.put(FuncionarioRepository.class, funcionarioRepository);
		definicoesDosRepositorios.put(ClienteRepository.class, clienteRepository);
		definicoesDosRepositorios.put(ServicoRepository.class, servicoRepository);
	}

}
