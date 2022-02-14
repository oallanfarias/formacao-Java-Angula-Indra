<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import = "com.indracompany.treinamento.model.entity.*" %>
<%@ page import = "java.util.*" %>


<html lang="en">
<head>

<title>Clientes</title>
</head>
<body>

	<div>
		<h1>Cliente</h1>
		<h2>Cadastrar</h2>
	</div>

	<form name="frmCadastrarCliente" method="POST" action="cadastrarBanco"
	<div>	

        <table  width="600" border="0" cellspacing="1" cellpadding="1">
			<tr class="tdPadrao">
	            <td width="150" align="left" valign="middle">&nbsp;-Nome:</td>
	            <td align="left" valign="middle">
	              <input type="text"  name="edtNome" size="20"  maxlength="14">*
	             </td>  
          	</tr>
          	<tr class="tdPadrao">
	            <td width="150" align="left" valign="middle">&nbsp;-Sobrenome:</td>
	            <td align="left" valign="middle">
	              <input type="text"  name="edtSobrenome" size="20"  maxlength="14">*
	             </td>  
          	</tr>
          	<tr class="tdPadrao">
	            <td width="150" align="left" valign="middle">&nbsp;-CPF:</td>
	            <td align="left" valign="middle">
	              <input type="text"  name="edtCPF" size="20"  maxlength="14">*
	             </td>  
          	</tr>
          	<tr class="tdPadrao">
	            <td width="150" align="left" valign="middle">&nbsp;-E-mail:</td>
	            <td align="left" valign="middle">
	              <input type="text"  name="edtEmail" size="20"  maxlength="14">*
	             </td>  
          	</tr>
          	
          	<tr class="tdCabecalho">
	            <td colspan="2" valign="middle" align="center" height="30">
	              <input type="submit"  value="Cadastrar" name="btnSubmeter">
	            </td>
          	</tr>
		</table>
	</div>
  </form>
</body>

</html>