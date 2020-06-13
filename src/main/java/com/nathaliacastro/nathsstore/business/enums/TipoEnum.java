package com.nathaliacastro.nathsstore.business.enums;

public enum TipoEnum {
	
	// Cria objetos ENUM de acordo com o construtor privado
		ROUPA_MASCULINA("Roupa Masculina", 0), ROUPA_FEMININA("Roupa Feminina", 1),
		ROUPA_UNISSEX("Roupa Unissex", 2), ROUPA_BANHO("Banho", 3);

		private String nome;
		private Integer codigo;

		// Construtor do ENUM
		private TipoEnum(String nome, Integer codigo) {
			this.nome = nome;
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public Integer getCodigo() {
			return codigo;
		}
}
