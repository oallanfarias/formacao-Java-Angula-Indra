<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import = "com.indracompany.treinamento.model.entity.*" %>
<%@ page import = "java.util.*" %>


<%



List<Cliente> lista = (List) session.getAttribute("lista");

%>
<html lang="en">
<head>

<title>Clientes</title>
</head>
<body>

	<div>
		<h1>Cliente</h1>
		<h2>Listar</h2>
	</div>


	<div>	

        <table  width="600" border="1" cellspacing="1" cellpadding="1">
          <tr >
            <td colspan="4" align="center" valign="middle">Lista dos Cliente</td>
          </tr>
          <tr align="center">
            <td valign="middle"><b>Nome</b></td>
            <td valign="middle"><b>Sobremone</b></td>
            <td valign="middle"><b>CPF</b></td>
            <td valign="middle"><b>E-mail</b></td>
          </tr>	
				<%
				
				for (Cliente cliente: lista){
				
				%>
				 
					<tr align="center">
	            		<td valign="middle"><%=cliente.getNome() %></td>
	            		<td valign="middle"><%=cliente.getSobrenome() %></td>
	            		<td valign="middle"><%=cliente.getCpf() %></td>
	            		<td valign="middle"><%=cliente.getEmail() %></td>
          			</tr>
          			
				<%
				}
				%>
		</table>
</div>
</body>

</html>