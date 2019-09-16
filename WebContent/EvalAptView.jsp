<%@ page import="model.EvalApt" %>
<%@ page import="dao.EvalAptDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="viewBean" scope="page" type="bean.ViewBean"/>

<%
    EvalApt ea = EvalAptDAO

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
    <div class="container">

        <h1>Dettaglio della valutazione</h1>

        <hr>

        Apppartamento in via <%= apt.getAddress() %>
        <br>
        Voto: <%= ea.getStars() %>
        <br>
        Testo della valutazione:
        <p>
            <%= ea.getText() %>
        </p>
<%--        Autore della valutazione: <%= ea.getEvalusr() %>--%>

    </div>

</body>
</html>
