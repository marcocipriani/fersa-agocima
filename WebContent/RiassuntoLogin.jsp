<%@ page import="Dao.UsrDAO" %>
<%@ page import="model.ActualUsr" %>
<%@ page import="model.EvalUsr" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Vector" %>
<%@ page import="Dao.EvalUsrDAO" %>
<%@ page import= "java.util.Iterator" %>



<jsp:useBean id="loginBean" scope="session" type="model.LoginBean"/>
<!--  jsp:useBean id="userLogged" scope="session" class="model.ActualUsr"/> -->



<% ActualUsr au = UsrDAO.findByNickname(loginBean.getUsername(), loginBean.getPassword(), false);
	loginBean.setNome(au.getName());

	
	//UsrDAO.findByNickname(loginBean.getUsername(), loginBean.getPassword(), false);
	//String firstName = userLogged.getName();	
	 %>	
	 


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OK</title>
</head>
<body>
 	
 	Welcome <jsp:getProperty property="nome" name="loginBean"/> <jsp:getProperty property="username" name="loginBean"/>
	
	Tabella delle valutazioni fatte da te
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Autore della valutazione</th>
                <th>Soggetto della valutazione</th>
                <th>Stelle</th>
                <th>Testo</th>
            </tr>
        </thead>
        <tbody>
        <%
            Vector evalList = EvalUsrDAO.findEvalMadeByYou(loginBean.getNome()); // firstName = au.something HEREEEEEEEEEEEEEEEE
            Iterator evalListIterator = evalList.iterator();
            EvalUsr eu;
            while (evalListIterator.hasNext()){
                eu = (EvalUsr) evalListIterator.next();
        %>
            <tr> <!--  a row for each result -->
                <td><%= eu.getId() %></td>
                <td><%= eu.getEvalusr() %></td>
                <td><%= eu.getNickname() %></td>
                <td><%= eu.getStars() %></td>
                <td><%= eu.getText() %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

</body>
</html>