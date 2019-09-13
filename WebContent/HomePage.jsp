<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>


<!-- Si dichiara la variabile loginBean e istanzia un oggetto LoginBean -->
<jsp:useBean id="loginBean" scope="session" class="bean.LoginBean"/>
<jsp:useBean id="searchBean" scope="session" class="bean.SearchBean" />
             

<!-- Mappa automaticamente tutti gli attributi dell'oggetto loginBean e le proprietà JSP -->
<jsp:setProperty name="loginBean" property="username"/>
<jsp:setProperty name="loginBean" property="password"/>
<jsp:setProperty name="searchBean" property="searchkeyword"/>

<%
    if (request.getParameter("login") != null) {
    	if (loginBean.validate()) {
            %>
            <!-- Passa il controllo alla nuova pagina -->
            <jsp:forward page="ProfileView.jsp"/>
            <%
        } else {
            %>
            <p style="text-color:red; text-align: center;">Dati errati</p>
            <%
        }
    } else {
        %>
        <p class="text-info" style="text-align: right;">Accesso non effettuato</p>
        <%
    }

	if (request.getParameter("search") != null) {
		System.out.println(searchBean.getSearchkeyword());
	  	  %><jsp:forward page="SearchView.jsp"/><% 	
	} else {}
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
    <div class="container text-center login">

            <h2>Accesso all'area riservata</h2>
            <form action="HomePage.jsp" name="loginForm" method="POST">

                <div class="row">
                    <div class="col-lg-4 form-group">
                        <label for="username">Username</label>
                        <input id="username" name="username" type="text" placeholder="utente">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 form-group">
                        <label for="password">Password</label>
                        <input id="password" name="password" type="password" placeholder="password">
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
        <form action="SearchView.jsp" name="searchForm" method="POST">
            <div class="row">
                <input id="searchkeyword" name="searchkeyword" type="text"  style="width: 250px" placeholder="Digitare indirizzo o username">
            </div>
            <div class="row">
                <input id="userRadio" name="searchUser" type="radio">
                <input id="aptRadio" name="searchApt" type="radio">
            </div>

<%--            IF TRUE APT, FALSE USR--%>
            <div class="row">
                <input name="searchButton" type="submit" id="search" value="Cerca" class="btn btn-info">
            </div>

        </form>

    </div>
</body>
</html>