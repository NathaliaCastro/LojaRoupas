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

import com.nathaliacastro.nathsstore.business.bean.MostruarioBean;
import com.nathaliacastro.nathsstore.business.bean.PecaBean;
import com.nathaliacastro.nathsstore.business.enums.TipoEnum;

/**
 * Servlet implementation class MostruarioController
 */
@WebServlet("/mostruario")
public class MostruarioController {
	private static final long serialVersionUID = 1L;

	private MostruarioBean mostruarioBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostruarioController() {
		super();

		// Inicia o mostruario com as pecas exemplares
		mostruarioBean = new MostruarioBean();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Restaura os valores do select do front
		String[] codigosTipo = request.getParameterValues("tipo");

		// Despacha as pecas do mostruario para o front
		request.setAttribute("pecas", mostruarioBean.getPecasFiltradas(codigosTipo));
		request.setAttribute("tipos", TipoEnum.values());
		
		// Usuario clica no botao adicionar
		if (request.getParameter("adicionar") != null) {
			
			HttpSession session = request.getSession();
	
			// Analisa se ja existe um carrinho, se nao existir, um carrinho eh criado
			if (session.getAttribute("carrinho") == null) {
				
				// Caso nao exista a lista de compras, eh criado uma
				List<PecaBean> carrinho = new ArrayList<>();
				session.setAttribute("carrinho", carrinho);
			}
			
			//Restaura a lista de compras
			List<PecaBean> carrinho = (List<PecaBean>) session.getAttribute("carrinho");
			
			// Detecta o codigo da roupa que o usuario selecionou
			String codigoString = request.getParameter("adicionar");
			Integer codigo = Integer.parseInt(codigoString);
			
			// Passa por todas as roupas e busca aquela com codigo correspondente
			List<PecaBean> todasAsPecas = mostruarioBean.getPecas();
			for (PecaBean peca : todasAsPecas) {
				if (peca.getCodigo().equals(codigo)) {
					carrinho.add(peca);
				}
			}
			
		}

		// Envia o JSP na solicitacao
		request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
