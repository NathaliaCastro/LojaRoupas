package com.nathaliacastro.nathsstore.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nathaliacastro.nathsstore.business.bean.PecaBean;

/**
 * Servlet implementation class CarrinhoController
 */
@WebServlet("/carrinho")
public class CarrinhoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CarrinhoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Restaura o HTTPSession
		HttpSession session = request.getSession();
		
		// Verifica se ja existe um carrinho
		if (session.getAttribute("carrinho") == null) {
			
			// Cria lista de compra caso nao tenha
			List<PecaBean> carrinho = new ArrayList<>();
			session.setAttribute("carrinho", carrinho);
		}
		
		//Restaura a lista de compras
		List<PecaBean> carrinho = (List<PecaBean>) session.getAttribute("carrinho");
		
		// Envia o carrinho para o front
		request.setAttribute("carrinho", carrinho);
		
		// Descobre o valor total e enviar para o JSP
		Float total = 0f;
		for (PecaBean peca : carrinho) {
			total += peca.getPreco();
		}
		request.setAttribute("total", total);
		
		// Envia o JSP na solicitacao
		request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Usuario clicou em excluir
		String indexString = request.getParameter("excluir");
		int index = Integer.parseInt(indexString) - 1; // Count e 1-based
		
		// Restaura o carrinho
		HttpSession session = request.getSession();
		List<PecaBean> carrinho = (List<PecaBean>) session.getAttribute("carrinho");
		
		// Exclui a roupa do carrinho atraves do indice
		carrinho.remove(index);
		
		doGet(request, response);
	}
}
