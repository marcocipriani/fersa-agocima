<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>


<!-- Si dichiara la variabile loginBean e istanzia un oggetto LoginBean -->
<jsp:useBean id="loginBean" scope="session"
             class="bean.LoginBean"/>
             

<!-- Mappa automaticamente tutti gli attributi dell'oggetto loginBean e le proprietà JSP -->
<jsp:setProperty name="loginBean" property="*"/>

<%
    if (request.getParameter("login") != null) {
    	System.out.println("inizio validate");
    	if (loginBean.validate()) {
            %>
            <!-- Passa il controllo alla nuova pagina -->
            <jsp:forward page="ProfileView.jsp"/>
            <%
        } else {
            %>
            <p style="text-color:red;">Dati errati</p>
            <%
        }
    } else {
        %>
        <p class="text-info">Accesso non effettuato</p>
        <%
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Homepage.jsp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="libs/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body class="homepage">
    <div class="container login">

            <h2>Accesso all'area riservata</h2>
            <form action="HomePage.jsp" name="loginForm" method="POST">

                <div class="row">
                    <div class="col-lg-4 form-group">
                        <label for="username">Username</label>
                        <input id="username" name="username" type="text">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 form-group">
                        <label for="password">Password</label>
                        <input id="password" name="password" type="password">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 text-center">
                        <input name="login" type="submit" id="login" value="Accedi" class="btn btn-info">
                        <input name="reset" type="reset" id="reset" class="btn btn-warning">
                    </div>
                </div>
            </form>

    </div>
    <div class="container text-center search">

        <h2>Ricerca di appartamenti o utenti</h2>
        <form action="SearchView.jsp" name="searchForm" method="get">
            <div class="row">
                <input id="searchKeyword" name="searchKeyWord" type="text">
                <input id="" name="search" type="radio">
            </div>
            <div class="row">
                <input name="searchButton" type="submit" id="search" value="Cerca">
            </div>

        </form>

    </div>
</body>
</html>