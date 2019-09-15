<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ page import="model.Eval" %>
<%@ page import="bean.SearchBean" %>
<%@ page import="controller.SearchController" %>
<%@ page import="java.util.Vector" %>

<jsp:useBean id="searchBean" scope="session" type="bean.SearchBean"/>

<%
    System.out.println("@SearchView.jsp - Chiave di ricerca: " + searchBean.getSearchKeyword());
    System.out.println("@SearchView.jsp - Selezione apt[false]/usr[true]: " + searchBean.isChoice());
	Vector<Eval> resultList = SearchController.searchList(searchBean.isChoice(), searchBean.getSearchKeyword());
%>

<html>
<head>
    <title>SearchView.jsp</title>

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container text-center">

<%
    if (!searchBean.isChoice()) {
%>
        <h1>Ricerca di appartamenti</h1>
<%
    } else {
%>
        <h1>Ricerca di utenti</h1>
<%
    }
%>

        <p>Hai cercato "<%= searchBean.getSearchKeyword() %>"</p>
        <p>
<%
            if(resultList.size() == 0) {
%>
            Nessun risultato. <a href="HomePage.jsp">Riprova</a>
<%
            } else if (resultList.size() == 1) {
%>
            1 risultato
<%
            } else {
%>
            <%= resultList.size() %> risultati
<%
            }
%>
        </p>
        <hr>

<%
            for (int i = 0; i < resultList.size(); i++) {
%>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Stelle</th>
                        <th scope="col">Testo</th>
                        <th scope="col">Autore della valutazione</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%= resultList.elementAt(i).getId() %></th>
                        <td><%= resultList.elementAt(i).getStars() %></th>
                        <td><%= resultList.elementAt(i).getText() %></th>
                        <td><%= resultList.elementAt(i).getEvalusr() %></th>
                    </tr>
                </tbody>
            </table>

<%
            }
%>

    </div>
</body>
</html>