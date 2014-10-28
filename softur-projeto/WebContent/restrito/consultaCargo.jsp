<%@page import="softur.repository.infra.CargosHibernate"%>
<%@page import="softur.util.JpaUtil"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="softur.entities.Cargo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="softur.repository.Cargos"%>
<%@page import="java.util.List"%>
<%@page import="softur.util.Repositorios"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consulta Cargo</title>
<script src="../resources/js/jquery.js"></script>
<script src="../resources/js/jquery.dataTables.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#tabela').dataTable();
	});
</script>
</head>
<body>
	<table id="tabela">
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Cargo</th>
			</tr>
		</thead>
		<tbody>

			<%
			EntityManager manager = JpaUtil.createEntityManager();
		      
			try{
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