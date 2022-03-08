<%-- 
    Document   : PantallaAlta
    Created on : 8 mar. 2022, 13:58:27
    Author     : Lisandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista De Gastos</h1>
        <div>
            <table border="1">
                <tr><th>Id</th> <th>Motivo</th> <th>IdCategoria</th> <th>Importe</th> </tr>

                <c:forEach var="t" items="${listaGastos}">

                    <tr> <td> ${t.idGasto} </td> <td> ${t.categoria.nombre} </td> <td>${t.categoria.idCategoria}</td> <td>${t.importe} </td> </tr>

                </c:forEach>
            </table>

        </div>
        
        <form method="POST" action="/EjercicioFinal/PantallaAlta" > 			
            <div>                        
                <label for="cboCategoria">Categoria</label>
                <select name="cboCategoria" >
                    
                    <c:forEach var="t" items="${listaCategorias}">
                        <option value="${t.idCategoria}">${t.nombre}</option>
                    </c:forEach>
                        
                </select>
            </div> 
            <div >
                <label for="txtImporte">Importe</label>
                <input type="number" name="txtImporte"/>
            </div> 
            <input type="submit" value="Enviar" />
        </form>




    </body>
</html>
