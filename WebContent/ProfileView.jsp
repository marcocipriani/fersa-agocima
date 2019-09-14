<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ page import="model.ActualUsr" %>
<%@ page import="model.Eval" %>
<%@ page import="dao.UsrDAO" %>
<%@ page import="java.util.Vector" %>

<%@ page import="controller.ProfileController" %>

<jsp:useBean id="loginBean" scope="session" type="bean.LoginBean"/>

<% ActualUsr au = UsrDAO.findByUsername(loginBean.getUsername(), loginBean.getPassword(), false);
	loginBean.setNome(au.getName());

    Vector<Eval> evalAboutYouList = ProfileController.getList(loginBean.getNome());
%>

<!DOCTYPE html>
<html>
<head>
    <title>ProfileView.jsp</title>


    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container text-center">

        <h2>Bentornato <jsp:getProperty property="nome" name="loginBean"/></h2>
        <p>Ti sei loggato come
<%
        if(!au.isActualRole()) {
%>
                tenant (pezzente)
<%
        } else {
%>
            renter (proprietario)
<%
        }
%>
        </p>

    <hr>

    <p>Valutazioni su di te</p>
    <table class="table">
        <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Stelle</th>
                <th scope="col">Testo</th>
                <th scope="col">Autore della valutazione</th>
            </tr>
        </thead>
        <tbody>
<%
            for (int i = 0; i < evalAboutYouList.size(); i++) {
%>
        <!--  a row for each result -->
            <tr>
                <td><%= evalAboutYouList.elementAt(i).getId() %></td>
                <td><%= evalAboutYouList.elementAt(i).getStars() %></td>
                <td><%= evalAboutYouList.elementAt(i).getText() %></td>
                <td><%= evalAboutYouList.elementAt(i).getEvalusr() %></td>
            </tr>
<%
            }
%>
        </tbody>
    </table>

    </div>

</body>
</html>