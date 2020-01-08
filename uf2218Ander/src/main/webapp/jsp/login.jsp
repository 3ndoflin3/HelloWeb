
<%
	String titulo = "Iniciar sesion";
%>
<%@include file="../includes/Cabecera.jsp"%>


<div class="container">
	<div class="row justify-content-center">

		<div class="col-xl-10 col-lg-12 col-md-9">

			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
					<!-- Nested Row within Card Body -->
					<div class="row justify-content-center">

						<div class="col-lg-6">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">Inicia sesion</h1>
								</div>
								<form class="user" action="login" method="post">
									<div class="form-group">
										<input type="text" name ="nombre" class="form-control form-control-user"
											placeholder="Introduce tu nombre">
									</div><!--END OF FORM GROUP  -->
									<div class="form-group">
										<input type="password" name ="contrasena" class="form-control form-control-user"
											placeholder="Contrasena">
									</div><!--END OF FORM GROUP  -->
									<input type="submit"
										class="btn btn-primary btn-user btn-block" value="Acceder"/>
									<hr>
									${mensaje}
								</form>	<!--END OF FORM-->
							</div> <!-- END OF DIV (FOLDER PARENT) -->
						</div> <!-- END OF COL -->
					</div> <!-- END OF ROW -->
				</div> <!-- END OF CARD BODY  -->
			</div> <!-- END OF CARD  -->
		</div><!-- END OF COL -->
	</div><!-- END OF ROW -->
</div><!-- END OF CONTAINER -->


<jsp:include page="../includes/Pie.jsp" />
