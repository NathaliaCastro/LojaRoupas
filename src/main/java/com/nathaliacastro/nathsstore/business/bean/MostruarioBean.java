package com.nathaliacastro.nathsstore.business.bean;

import java.util.ArrayList;
import java.util.List;

import com.nathaliacastro.nathsstore.business.enums.TipoEnum;

public class MostruarioBean {
	private List<PecaBean> pecas;

	public MostruarioBean() {
		
		// Criar lista de roupas
		pecas = new ArrayList<>();
		pecas.add(novaPeca("Camisetas", TipoEnum.ROUPA_MASCULINA, 49.9f, "camisa.jpg"));
		pecas.add(novaPeca("Jeans", TipoEnum.ROUPA_UNISSEX, 80f, "calca.jpg"));
		pecas.add(novaPeca("Moleton", TipoEnum.ROUPA_UNISSEX, 15f, "regata.jpg"));
		pecas.add(novaPeca("Vestido", TipoEnum.ROUPA_FEMININA, 120f, "vestido.jpg"));
		pecas.add(novaPeca("Saias", TipoEnum.ROUPA_FEMININA, 70.99f, "macacao.jpg"));
		pecas.add(novaPeca("Blusas", TipoEnum.ROUPA_FEMININA, 80f, "roupa-de-gravida.jpg"));
		pecas.add(novaPeca("Toalhas", TipoEnum.ROUPA_BANHO, 45.99f, "roupa-de-verao.jpg"));
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