<%@ page import="model.EvalApt" %>
<%@ page import="dao.EvalUsrDAO" %>
<%@ page import="java.util.Vector" %>
<%@ page import="dao.EvalAptDAO" %>
<%@ page import="model.Eval" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="apt" scope="session" type="model.Apt">

<jsp:useBean id="ea" scope="session" class="model.EvalApt">
<jsp:useBean id="apt" scope="session" type="model.Apt">


<%-- if searchBean.coiche == searchApt
        find --%>
<%
    Vector<Eval> evalList;

    if (searchBean.choice){
        evalList = EvalAptDAO.findEvalMadeByYou(loginBean.getNome());
    } else {
        evalList = EvalUsrDAO.findEvalMadeByYou(loginBean.getNome());
    }
%>

<html>
<head>
    <title>SearchView</title>
</head>
<body>

    <h1>Ricerca di appartamenti e utenti</h1>
    <p>Hai cercato ' SEARCH_KEYWORD '</p>
    <p>NUMBER risultati</p>
    <hr>

    <%
        for (int i = 0; i < evalList.size(); i++) {
    %>
    <div>

        Valutazione #: <%= evalList.get(i).getId(); %>
        Voto: <%= evalList.get(i).getStars(); %>
        <p>Testo: <%= evalList.get(i).getText(); %></p>
        Autore: <%= evalList.get(i).getEvalusr(); %>

    </div>

    <%
        }
    %>


</body>
</html>
