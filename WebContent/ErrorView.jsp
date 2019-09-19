<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isErrorPage = "true" %>

<html>
<head>
    <title>ErrorView.jsp</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container text-center">
        <h2>Qualcosa è andato storto</h2>
        <p>Problema causato da: <%= exception.getCause() %></p>
        <a href="HomePage.jsp">Ritorna alla homepage</a>
    </div>

</body>
</html>
