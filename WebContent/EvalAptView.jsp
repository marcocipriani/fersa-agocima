<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="ea" scope="page" class="model.EvalApt">
<jsp:useBean id="apt" scope="session" class="model.Apt">

<html>
<head>
    <title>EvalAptView.jsp</title>
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
