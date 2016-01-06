package br.com.jsbse.gspm.mvc.tipos;

import br.com.jsbse.arquitetura.entidade.EnumeradoPersistente;

public enum TipoUsuario implements EnumeradoPersistente {
	DEMOLAY(1, "Demolay"), 
	FILHA_DE_JO(2, "Filha de Jó"), 
	MACOM(3,"Maçom"),
	ADMINISTRADOR(4,"Administrador");

	private Integer id;
	private String descricao;

	private TipoUsuario(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	@Override
	public String getId() {
		return id.toString();
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	public static TipoUsuario get(String id) {
		for (TipoUsuario tipo : TipoUsuario.values()) {
			if (tipo.getId().equals(id)) {
				return tipo;
			}
		}
		return null;
	}

}
