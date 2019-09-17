<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="model.EvalApt" %>
<%@ page import="controller.ViewController" %>
<%@ page import="model.Eval" %>


<%
    System.out.println(request.getParameter("id"));
    System.out.println(request.getParameter("aux"));
    int evalId = Integer.parseInt(request.getParameter("id"));
    System.out.println(evalId);
    Eval eval = ViewController.getEval(evalId, false);
%>

<html>
<head>
    <title>EvalAptView.jsp</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container text-center">

        <h1>Dettaglio della valutazione</h1>
<%--        <p>Apppartamento in via <%= viewBean.getAux() %></p>--%>
<%
    //TODO visualizzare
%>
        <hr>
        <p>Stelle: <%= eval.getStars() %></p>
        Testo della valutazione:
        <p>
            <%= eval.getText() %>
        </p>
        <p>Autore della valutazione: <%= eval.getEvalusr() %></p>
    </div>

</body>
</html>
