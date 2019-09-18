<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ page import="model.Eval" %>
<%@ page import="controller.SearchController" %>
<%@ page import="java.util.Vector" %>
<%@ page import="model.Apt" %>
<%@ page import="model.EvalApt" %>
<%@ page import="model.Usr" %>

<jsp:useBean id="searchBean" scope="request" type="bean.SearchBean"/>

<%
    System.out.println("@SearchView.jsp - Chiave di ricerca: " + searchBean.getSearchKeyword());
    System.out.println("@SearchView.jsp - Selezione apt[false]/usr[true]: " + searchBean.isChoice());

    if(searchBean.isChoice()){
        boolean usrHit = SearchController.isRealUsr(searchBean.getSearchKeyword());
    }
	//Vector<Eval> resultList = SearchController.searchEvalList(searchBean.isChoice(), searchBean.getSearchKeyword());
	Double average = 0.0, sum = 0.0;
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
<body id="searchPage">
    <div class="container text-center">

<%
    if (searchBean.isChoice()) {
%>
        <h1>Ricerca di utenti</h1>
        <p>Hai cercato "<%= searchBean.getSearchKeyword() %>"</p>

<%
        boolean usrHit = SearchController.isRealUsr(searchBean.getSearchKeyword());
        if(!usrHit){
%>
            Nessun utente trovato. <a href="HomePage.jsp">Riprova</a>
<%
        } else {
%>
            Trovato un utente.
<%
        }
    } else {
%>
        <h1>Ricerca di appartamenti</h1>
        <p>Hai cercato "<%= searchBean.getSearchKeyword() %>"</p>
        <p>
<%
        Vector<Apt> aptList = SearchController.getAptList(searchBean.getSearchKeyword());
        if(aptList.size() == 0) {
%>
            Nessun appartamento. <a href="HomePage.jsp">Riprova</a>
<%
        } else if (aptList.size() == 1) {
%>
            1 appartamento
<%
        } else {
%>
            <%= aptList.size() %> appartamenti
<%
        }
%>
        </p>
<%
    }
%>

        <p> Media valutazioni: <%= average %></p>
        <hr>

<%
        if(!searchBean.isChoice()){
            Vector<Apt> aptList = SearchController.getAptList(searchBean.getSearchKeyword());
            if(aptList.size() == 0){
%>
                <p>Nessun appartamento in <%= searchBean.getSearchKeyword() %> </p>
<%
            } else {
                int aptid = 0;
                for (int i = 0; i < aptList.size(); i++){
                    aptid = aptList.elementAt(i).getId();
%>
                    Appartamento #<%= aptid %>
                    in via #<%= aptList.elementAt(i).getAddress() %>, <%= aptList.elementAt(i).getNumber() %>
                    di proprietà di <%= aptList.elementAt(i).getOwner() %>

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
                        Vector<EvalApt> evalAptList = SearchController.searchEvalAptList(aptid);
                        System.out.println(aptList.size());
                        if(aptList.size() == 0){
%>
                            <p>Nessun valutazione per l'appartamento #<%= aptid %> </p>
<%
                            break;
                        } else {
                            for(int j = 0; j < evalAptList.size(); j++){
%>
                                <tr>
                                    <td><%= evalAptList.elementAt(j).getId() %></th>
                                    <td><%= evalAptList.elementAt(j).getStars() %></th>
                                    <td><%= evalAptList.elementAt(j).getText() %></th>
                                    <td><%= evalAptList.elementAt(j).getEvalusr() %></th>
                                    <td>
                                        <form action="EvalAptView.jsp" name="viewForm">
                                            <input name="view" type="submit" placeholder="" value="Dettaglio" class="form-control">
                                            <input name="id" type="hidden" value="<%= evalAptList.elementAt(j).getId() %>">
                                        </form>
                                    </td>
                                </tr>
<%
                            }
                        }
%>
                        </tbody>
                    </table>
                    <hr>
<%
                }
            }
        }
%>

    </div>
</body>
</html>