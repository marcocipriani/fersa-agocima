<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"   %>
    
<%@ page import="dao.UsrDAO" %>
<%@ page import="model.ActualUsr" %>

<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

   <!-- Si dichiara la variabile viewBean2 e istanzia un oggetto viewBean -->
   <jsp:useBean id="homeBean2" scope="request" class="controller.homeBean"/> 
   
	<!-- Mappa tutti gli elementi dell'oggetto viewBean2 e le proprietà JSP -->
	  <jsp:setProperty name="homeBean2" property="nickname" />
	  <jsp:setProperty name="homeBean2" property="username" />
	  <jsp:setProperty name="homeBean2" property="password" />
	  
	  
	<%
    if (request.getParameter("login") != null) {
        if (homeBean2.ConvalidaLogin().equals("Locatore")|| homeBean2.ConvalidaLogin().equals("Locatario") ) {
            %>
            <!-- Passa il controllo alla nuova pagina -->
            <jsp:forward page="profileView.jsp"/>
            <%
        } else {
            %>
            <p style="text-color:red;">Dati errati</p>
            <%
        }
      
    }

  %>
    
    

<html lang="it">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Agostini, Cipriani, Magnani">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <title>FERSA - login</title>

  </head>

  <body>
  
	  <script type="text/javascript">
		  public void findUsr()
			{
			  String user = request.getParameter("nickname");
			  String password= request.getParameter("password");
			  ActualUsr d;
			  d = UsrDAO.findByNickname(user, password, false); 
			  
			  if (request.getParameter("checkTenant")=="tenant") {
				  out.println("login come locatario!");
			  }
			  else{out.println("login come locatore!");}
			}
	  </script>

    <!-- inizio NAV TOP -->
    <div class="container">
      <div class="row">
        <div class="col-auto">
          <h1>FERSA</h1>
        </div>
        <div class="col mt-auto">
          <p class="mb-0 lead pb-2">Filter Evaluation Renting System Application</p>
        </div>
      </div>
    </div>
    <!-- fine NAV TOP -->

    <div class="jumbotron" style="background: url(img/testata.jpg); -webkit-background-size: cover; background-position: center; border-radius: 0rem;">
      <div class="container">
        <div class="row">
          <div class="col-6 mt-auto text-center">
            <p class="lead text-center" style="font-weight: 400;">Vuoi vedere le recensioni come guest?</p>
            <button id="buttonSearch" class="btn btn-lg btn-primary" type="submit" onclick="window.location.href='searchView.html'">Cerca</button>
          </div>
          
          <div class="col-6">
            <form class="form-signin" action="homepageTEST.jsp">
              <h1 class="display-4 mb-3 font-weight-normal text-center">Login</h1>
              
              <label for="nickname" class="sr-only">Nickname</label>
              <input type="text" id="nickname" name="nickname" class="form-control" placeholder="nickname" required autofocus>
              
              <label for="password" class="sr-only">Password</label>
              <input type="text" id="password" name="password" class="form-control" placeholder="password" required>
              
              <div class="form-check form-check-inline my-3">
                <input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="checkTenant" value="tenant">
                <label class="form-check-label" for="inlineCheckbox1">Login come locatore</label>
              </div>
              <% out.println("Ciao Mondo!"); %>
              
              <%
              	/*ActualUsr au = UsrDAO.findByNickname("gcantone", "fersa", true);
        		System.out.println(au);*/
        		 %>
        		 
        		 <!--  <input class="btn btn-lg btn-block btn-primary" name="login" type="submit" id="login" value="login" class="btn btn-info">-->
        		 
              <!--  --><button class="btn btn-lg btn-block btn-primary" type="submit" value="submit" id="login" value="login" onclick="findUsr()">Entra</button>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!-- inizio 3 CARD -->
    <div class="card-group container">
      <div class="card">
        <div class="card-img-top" style="background: url(img/card-1.jpg);-webkit-background-size: cover;"></div>
        <div class="card-body">
          <h5 class="card-title">Termina il contratto</h5>
          <p class="card-text">Prima di scrivere una valutazione, aspetta che la piattaforma convalidi la chiusura del contratto.</p>
        </div>
      </div>
      <div class="card">
        <div class="card-img-top" style="background: url(img/card-2.jpg);-webkit-background-size: cover;"></div>
        <div class="card-body">
          <h5 class="card-title">Scrivi una valutazione</h5>
          <p class="card-text">Valuta la tua esperienza sottoscritta dal contratto, il sistema abiliterà un modulo apposito che tu sia un locatore o un locatario.</p>
        </div>
      </div>
      <div class="card">
        <div class="card-img-top" style="background: url(img/card-3.jpg);-webkit-background-size: cover;"></div>
        <div class="card-body">
          <h5 class="card-title">Visualizza le valutazioni</h5>
          <p class="card-text">Fatti un'idea dell'offerta della piattaforma scorrendo le recensioni sulle strutture ed i loro locatori.</p>
        </div>
      </div>
    </div>
    <!-- fine 3 CARD -->

    <!-- inizio FOOTER -->
    <footer class="footer mt-5 py-3 bg-light" style=" height: 50px;">
      <div class="container">
        <p class="text-black-50" style="float: right;">Designed by Agostini Cipriani Magnani</p>
      </div>
    </footer>
    <!-- fine FOOTER -->

    <!-- SCRIPT -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript"src="js/bootstrap.bundle.js"></script>
    <script type="text/javascript"src="js/scripts.js"></script>

  </body>
</html>