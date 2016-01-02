package br.com.jsbse.gspm.mvc.service.crud;

import br.com.jsbse.arquitetura.excecao.ExcecaoInfraestrutura;
import br.com.jsbse.arquitetura.mensagem.Mensagens;
import br.com.jsbse.arquitetura.servico.ObjetoCrud;
import br.com.jsbse.arquitetura.servico.ServicoBase;
import br.com.jsbse.arquitetura.tipo.AcaoCrud;
import br.com.jsbse.gspm.mvc.dto.UsuarioDto;
import br.com.jsbse.gspm.mvc.model.Usuario;

public class CrudUsuario extends ObjetoCrud<Usuario, String, UsuarioDto> {

	public CrudUsuario(ServicoBase servico) {
		super(servico);
	}

	@Override
	protected void doValidaDados(UsuarioDto dto, AcaoCrud acao, Mensagens mensagens) {
	}

	@Override
	protected void doValidaRelacionamentos(Usuario entidade, UsuarioDto dto, AcaoCrud acao, Mensagens mensagens) {
	}

	@Override
	protected void doValidaExclusao(Usuario entidade, Mensagens mensagens) {
	}

	@Override
	protected void doExcluiRelacionados(Usuario entidade) throws ExcecaoInfraestrutura {
	}
}
