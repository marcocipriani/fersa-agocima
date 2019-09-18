<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="model.EvalUsr" %>
<%@ page import="controller.ViewController" %>
<%@ page import="model.Eval" %>


<%
	int evalId = Integer.parseInt(request.getParameter("id"));
    Eval eval = ViewController.getEval(evalId, true);
%>

<html>
<head>
    <title>EvalAptUsr.jsp</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container text-center">

    <h1>Dettaglio della valutazione</h1>

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
