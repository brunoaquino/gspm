package br.com.gspm.mvc.repositories;

import java.util.Map;

//@Component("fabricaDeRepositorios")
public class FabricaDeRepositoriosFactory extends FabricaDeRepositorios {

	// @Resource(name = "usuarioRepository")
	public UsuarioRepository usuarioRepository;

	// @Resource(name = "FuncionarioRepository")
	public FuncionarioRepository funcionarioRepository;

	// @Resource(name = "ClienteRepository")
	public ClienteRepository clienteRepository;

	// @Resource(name = "servicoRepository")
	public ServicoRepository servicoRepository;

	@Override
	protected void doPopulaDefinicoesDeRepositorio(
			Map<Class<? extends Repositorio>, Repositorio> definicoesDosRepositorios) {
		// definicoesDosRepositorios.put(UsuarioRepository.class,
		// usuarioRepository);
		// definicoesDosRepositorios.put(ClienteRepository.class,
		// clienteRepository);
		// definicoesDosRepositorios.put(FuncionarioRepository.class,
		// funcionarioRepository);
		// definicoesDosRepositorios.put(OSRepository.class, osRepository);
		// definicoesDosRepositorios.put(ServicoRepository.class,
		// servicoRepository);
	}

}
