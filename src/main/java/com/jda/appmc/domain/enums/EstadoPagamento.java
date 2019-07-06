package com.jda.appmc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE (1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"cANCELADO");
	
	private Integer cod;
	private String descrcicao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descrcicao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescrcicao() {
		return descrcicao;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
			throw new IllegalArgumentException("Id inválido" + cod);
	}	

}
