package com.nathaliacastro.nathsstore.business.bean;

import java.util.ArrayList;
import java.util.List;

import com.nathaliacastro.nathsstore.business.enums.TipoEnum;

public class MostruarioBean {
	private List<PecaBean> pecas;

	public MostruarioBean() {
		
		// Criar lista de roupas
		pecas = new ArrayList<>();
		
		pecas.add(novaPeca("Camiseta", TipoEnum.ROUPA_MASCULINA, 39.9f, "camiseta.jpg"));
		pecas.add(novaPeca("Jeans", TipoEnum.ROUPA_UNISSEX, 60f, "calca.jpg"));
		pecas.add(novaPeca("Moleton", TipoEnum.ROUPA_UNISSEX, 72.9f, "moletom.jpg"));
		pecas.add(novaPeca("Vestido", TipoEnum.ROUPA_FEMININA, 100f, "vestido.jpg"));
		pecas.add(novaPeca("Terno", TipoEnum.ROUPA_MASCULINA, 150f, "terno.jpg"));
		pecas.add(novaPeca("Relogio", TipoEnum.ROUPA_MASCULINA, 95f, "relogio.jpg"));
		pecas.add(novaPeca("Short", TipoEnum.ROUPA_FEMININA, 39.9f, "short.jpg"));
	}

	// Inserir novas roupas
	private PecaBean novaPeca(String nome, TipoEnum tipoEnum, Float preco, String nomeImagem) {

	// Tamanho da lista de roupas
	Integer codigo = pecas.size();

		PecaBean pecasBean = new PecaBean();
		pecasBean.setCodigo(codigo);
		pecasBean.setNome(nome);
		pecasBean.setCodigoTipo(tipoEnum.getCodigo());
		pecasBean.setTipo(tipoEnum.getNome());
		pecasBean.setPreco(preco);
		pecasBean.setNomeImagem(nomeImagem);

		return pecasBean;
	}

	public List<PecaBean> getPecas() {
		return pecas;
	}

	public void setPeca(List<PecaBean> pecas) {
		this.pecas = pecas;
	}

	// Exibe todas as pecas filtradas
	public List<PecaBean> getPecasFiltradas(String[] codigosTipo) {

		// Sem filtro
		if (codigosTipo == null) {
			return pecas;
		}

		List<PecaBean> pecasFiltradas = new ArrayList<>();

		// Criar lista vazia
		List<Integer> codigos = new ArrayList<>();

		// Passa pelos codigos que o usuario pesquisa, converte em inteiro e adiciona na lista
		for (String codigoTipo : codigosTipo) {
			codigos.add(Integer.parseInt(codigoTipo));
		}

		// Confere se o codigo da peca eh o mesmo que o codigo que da solicitacao
		for (PecaBean peca : pecas) {
			if (codigos.contains(peca.getCodigoTipo())) {
				pecasFiltradas.add(peca);
			}
		}

		return pecasFiltradas;

	}
}
