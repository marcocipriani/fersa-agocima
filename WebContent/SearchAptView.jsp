<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page errorPage = "ErrorView.jsp" %>

<%@ page import="controller.SearchController" %>
<%@ page import="java.util.Vector" %>
<%@ page import="model.Apt" %>
<%@ page import="model.EvalApt" %>

<jsp:useBean id="searchBean" scope="request" type="bean.SearchBean"/>

<%
    Vector<Apt> aptList = SearchController.getAptList(searchBean.getSearchKeyword());
    double sum = 0.0, average = 0.0;
%>

<html>
<head>
    <title>SearchView.jsp</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body id="search-apt-page" class="search-page">
    <div class="container text-center">

        <h1>Ricerca di appartamenti</h1>
        <p>Hai cercato "<%= searchBean.getSearchKeyword() %>"</p>

<%
        if(aptList.size() == 0){
%>
            <p>Nessun appartamento trovato in questa via. <a href="HomePage.jsp">Riprova</a></p>
<%
        } else if(aptList.size() == 1)  {
%>
            <p>Trovato un appartamento in questa via. <a href="HomePage.jsp">Esegui una nuova ricerca</a></p>
<%
        } else {
%>
            <p>Trovati <%= aptList.size() %> appartamenti in questa via. <a href="HomePage.jsp">Esegui una nuova ricerca</a></p>
<%
        }
%>

        <hr>

<%
        for(int i=0; i < aptList.size(); i++){
            int aptid = aptList.elementAt(i).getId();
%>
            <div class="eval-apt">
            <h3>Appartamento #<%= aptid %>
            in <%= aptList.elementAt(i).getAddress() %>, <%= aptList.elementAt(i).getNumber() %>
            <%-- hidden for security reason di proprietà di <%= aptList.elementAt(i).getOwner() %>--%>
            </h3>

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
                    Vector<EvalApt> resultList = SearchController.searchEvalAptList(aptid);
                    sum = 0.0; // resetting every apt
                    for(int j=0; j < resultList.size(); j++){
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
                                <input name="kind" type="hidden" value="false"><%-- false for evalApt --%>
                            </form>
                        </td>
                    </tr>
<%
                        sum = sum + resultList.elementAt(j).getStars();
                    }
%>
                </tbody>
            </table>
<%
            if(sum != 0.0){
                average = sum / (resultList.size());
%>
                <p class="text-<% if (average >= 4) {%>success<%} else if(average > 2){%>warning<%} else {%>danger<%}%>">
                    Media valutazioni dell'appartamento: <%= average %></p>
<%
            } else {
%>
                <p class="text-secondary">Ancora nessuna valutazione</p>
<%
            }
%>
            </div>
<%
        }
%>
    </div>
</body>
</html>