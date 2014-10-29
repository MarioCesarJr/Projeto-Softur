<%@page import="softur.repository.infra.CargosHibernate"%>
<%@page import="softur.util.JpaUtil"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="softur.entities.Cargo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consulta Cargo</title>
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/jquery.dataTables.css">
<script src="../resources/js/jquery.js"></script>
<script src="../resources/js/jquery.dataTables.js"></script>
<script src="../resources/js/dataTables.bootstrap.js"></script>

<style type="text/css">

body {
  margin: 0;
  line-height: 1.5;
  color: #222;
  background: #e5e5e5;
  background: -moz-linear-gradient(top,  #e5e5e5 0%, #ffffff 100%);
  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#e5e5e5), color-stop(100%,#ffffff));
  background: -webkit-linear-gradient(top,  #e5e5e5 0%,#ffffff 100%);
  background: -o-linear-gradient(top,  #e5e5e5 0%,#ffffff 100%);
  background: -ms-linear-gradient(top,  #e5e5e5 0%,#ffffff 100%);
  background: linear-gradient(to bottom,  #e5e5e5 0%,#ffffff 100%);
  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e5e5e5', endColorstr='#ffffff',GradientType=0 );
}


</style>

<script type="text/javascript">
	$(document).ready(function() {
		$('#tabela').dataTable({
			"language" : {
				"lengthMenu" : "Exibindo _MENU_ registros por página",
				"zeroRecords" : "Nada encontrado !",
				"info" : "Mostrando página _PAGE_ de _PAGES_",
				"infoEmpty" : "Há registros disponíveis",
				"infoFiltered" : "(filtrou-se o total de _MAX_ registros)",
				"sSearch" : "Buscar:",
				"oPaginate" : {
					"sFirst" : "Primeiro",
					"sPrevious" : "Anterior",
					"sNext" : "Seguinte",
					"sLast" : "Último"
				}
			}
		});

	});
</script>
</head>
<body>

	<div class="container"><br/>
	<a href="admin.xhtml" class="btn btn-primary btn-lg active">Voltar</a><br/><br/>
		<table id="tabela" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Cargo</th>
				</tr>
			</thead>
			<tbody>

				<%
					EntityManager manager = JpaUtil.createEntityManager();

					try {
						CargosHibernate cargosHibernate = new CargosHibernate(manager);
						List<Cargo> cargosList = cargosHibernate.listarTodos();
				%>

				<%
					for (Cargo cargo : cargosList) {
				%>

				<tr>
					<td><%=cargo.getId()%></td>
					<td><%=cargo.getNomeCargo()%></td>
				</tr>
				</div>
				<%
					}
				%>

				<%
					} finally {
						manager.close();
					}
				%>
			</tbody>

		</table>
</body>
</html>