<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page errorPage = "ErrorView.jsp" %>

<%@ page import="controller.ViewController" %>
<%@ page import="model.Eval" %>

<%
	int evalId = Integer.parseInt(request.getParameter("id"));
	boolean kind = Boolean.parseBoolean(request.getParameter("kind"));
    Eval eval = ViewController.getEval(evalId, kind);
%>

<html>
<head>
    <title>EvalView.jsp</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body <%if(!kind){%>id="eval-apt-view-page"<%}%> class="eval-view-page">
    <div class="container text-center">

        <h1>Dettaglio della valutazione <%if(kind){%>utente<%} else {%>appartamento<%}%></h1>
        <p> ID Valutazione: <%= evalId %></p>

        <hr>

        <div class="eval-detail">
            <p><b>Stelle:</b> <%= eval.getStars() %></p>
            <hr>
            <p><b>Testo della valutazione:</b> <%= eval.getText() %></p>
            <hr>
            <p><b>Autore della valutazione:</b> <%= eval.getEvalusr() %></p>
        </div>

    </div>
</body>
</html>
