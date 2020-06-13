package com.nathaliacastro.nathsstore.business.enums;

public enum TipoEnum {
	
	// Cria objetos ENUM de acordo com o construtor privado
		ROUPA_MASCULINA("Masculina", 0), ROUPA_FEMININA("Feminina", 1),
		ROUPA_UNISSEX("Inverno", 2), ACESSORIO("Acessórios", 3),
		ROUPA_INFANTIL("Infantil", 4);

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
