<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page errorPage = "ErrorView.jsp" %>

<%@ page import="controller.SearchController" %>
<%@ page import="java.util.Vector" %>
<%@ page import="model.EvalUsr" %>

<jsp:useBean id="searchBean" scope="request" type="bean.SearchBean"/>

<%
    boolean usrHit = SearchController.isRealUsr(searchBean.getSearchKeyword());
    double sum = 0.0, average = 0.0;
    Vector<EvalUsr> resultList = SearchController.searchEvalUsrList(searchBean.getSearchKeyword());
    if(usrHit) {
        for(int i=0; i < resultList.size(); i++){
            sum = sum + resultList.elementAt(i).getStars();
        }
        average = sum / (resultList.size());
    }
%>

<html>
<head>
    <title>SearchUsrView.jsp</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body id="search-usr-page" class="search-page">
    <div class="container text-center">

        <h1>Ricerca di utenti</h1>
        <p>Hai cercato "<%= searchBean.getSearchKeyword() %>"</p>

<%
        if(!usrHit){
%>
            <p>Nessun utente trovato. <a href="HomePage.jsp">Riprova</a></p>
<%
        } else {
%>
            <p>Trovato utente corrispondente. <a href="HomePage.jsp">Esegui una nuova ricerca</a></p>
<%
        }
%>
<%
        if (average != 0.0){
%>

        <p class="text-<% if (average >= 4) {%>success<%} else if(average > 2){%>warning<%} else {%>danger<%}%>">
            Media valutazioni dell'utente: <%= average %></p>
<%
        }
%>
        <hr>

        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID valutazione</th>
                    <th scope="col">Stelle</th>
                    <th scope="col">Testo</th>
                    <th scope="col">Autore della valutazione</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
<%
            for (int j = 0; j < resultList.size(); j++){
%>
                <tr>
                    <td><%= resultList.elementAt(j).getId() %></th>
                    <td><%= resultList.elementAt(j).getStars() %></th>
                    <td><%= resultList.elementAt(j).getText() %></th>
                    <td><%= resultList.elementAt(j).getEvalusr() %></th>
                    <td>
                        <form action="EvalView.jsp" name="viewForm">
                            <input name="view" type="submit" placeholder="" value="Dettaglio" class="form-control">
                            <input name="id" type="hidden" value="<%= resultList.elementAt(j).getId() %>">
                            <input name="kind" type="hidden" value="true"><%-- true for evalApt --%>
                        </form>
                    </td>
                </tr>
<%
            }
%>
            </tbody>
        </table>
    </div>
</body>
</html>