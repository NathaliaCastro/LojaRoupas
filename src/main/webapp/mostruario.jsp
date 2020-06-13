<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<c:import url="/common/header.jsp" />

<body>
	<div class="container-fluid">

		<c:import url="/common/titulo.jsp" />

		<div class="row">
			<c:import url="/common/side-bar.jsp" />

			<div class="col-9">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<h3>Mostruário</h3>
						</div>
					</div>

					<div class="row">
						<div class="col-6">
							<c:forEach items="${ pecas }" var="peca">
								<form method="post">
									<div class="card">
										<div class="card-header">
											<h5>${ peca.nome }</h5>
										</div>

										<div class="card-body">

											<img class="card-img"
												src="assets/img/mostruario/${ peca.nomeImagem }">

											<div class="card-title text-center mt-4">
												<div class="badge badge-dark badge-pill">
													<h5>
														<fmt:formatNumber value="${ peca.preco }" type="currency"
															currencySymbol="R$" />
													</h5>
												</div>
											</div>

										</div>

										<div class="card-footer text-center">
											<div class="btn-group">
												<button type="submit" name="adicionar"
													value="${ peca.codigo }" class="btn btn-primary">Adicionar</button>
												<a class="btn btn-info" href="#">Veja mais</a>
											</div>
										</div>

									</div>
								</form>
							</c:forEach>
						</div>


						<div class="col-6 text-right">
							<h5>Filtros</h5>

							<form method="get">
								<div class="form-group">
									<label for="tipos">Tipos</label> <select multiple
										name="tipo" class="form-control" id="tipos">
										<c:forEach items="${ tipos }" var="tipo">
											<option value="${ tipo.codigo }">${ tipo.nome }</option>
										</c:forEach>
									</select>
								</div>

								<div class="btn-group">
									<button class="btn btn-warning" type="reset">Limpar</button>
									<button class="btn btn-primary">Filtrar</button>
								</div>

							</form>

						</div>

					</div>

				</div>
			</div>

		</div>

	</div>

	<c:import url="/common/footer.jsp" />

</body>
</html>
