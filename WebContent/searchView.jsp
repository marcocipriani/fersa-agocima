<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"   %>
<%@page import="java.util.ArrayList"%>
 
<%@ page import="model.EvalApt"%>
<%@ page import="model.EvalUsr"%>
<%@ page import="model.Eval"%>

   <!-- Si dichiara la variabile viewBean2 e istanzia un oggetto viewBean -->
   <jsp:useBean id="viewBean2" scope="request" class="controller.viewBean"/> 
   
   <!-- Mappa automaticamente tutti gli attributi dell'oggetto viewBean2 e le proprietà JSP -->
  	<jsp:setProperty name="viewBean2" property="searchID" />

<!DOCTYPE html>
<html lang="it" dir="ltr">
	<jsp:include page="header.jsp"/>
  


    <!-- inizio DATI -->
    <div class="container">
      <p class="lead mt-5">Utilizza la barra di ricerca per trovare recensioni su utenti ed appartamenti</p>
      <div class="row">
        <div class="col-auto">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="searchRec" id="searchRec1" value="searchUser" checked>
                <label class="form-check-label" for="searchRadios1">Locatori/Locatari</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="searchRec" id="searchRec2" value="searchAppartment">
                <label class="form-check-label" for="searchRadios2">Appartamenti</label>
            </div>
        </div>
        <div class="col">
          <input id="searchID" class="form-control mr-sm-2" type="search" placeholder="Inserisci" aria-label="Search">
        </div>
        <div class="col">
          <button name="searchID" value="search" class="btn btn-primary my-2 my-sm-0" type="submit" >Cerca</button>
        </div>
      </div>
     
     <%
     
     if(request.getParameter("searchID")!=null){ /*quando il check è diverso da null*/
     
     	if(request.getParameter("searchID").equals("searchUser")){/*quando il check è su "ricerca user"*/
     		%>
     		<!-- inizio STAMPA TABELLA USER -->
		      <h3 class="mt-5">Locatari/locatori</h3>
		      <table class="table table-striped">
		        <thead>
		          <tr>
		            <th scope="col">ID</th>
		            <th scope="col">Utente</th>
		            <th scope="col">Voto</th>
		            <th scope="col">Testo</th>
		            <!-- <th scope="col">Link</th> -->
		          </tr>
		        </thead>
		        <tbody>
		        <% 
		        ArrayList<RecensioneUsr> rc=viewBean2.beanRicercaUsr();
	        	for(int  i=0;i<rc.size();i++) {
	            %>
	            	<!-- RISULTATO DEL CICLO FOR
	            	<tr>
			          <th scope="row" id="idRecUtente"><i class="fas fa-user"></i></th>
			          <td id="nomeUtente">NomeUtente</td>
			          <td id="votoUtente">8</td>
			          <td id="testoUtente">Testo della recensione</td> 
			        </tr>  -->
			        <tr>
		    	       <th scope="row"> <%=rc.get(i).getIdLocatore() %></th>
		    	       <td><%=rc.get(i).getMedia() %></td>
		    	    </tr>
			        <%  
                }%>
                </tbody>
      		</table><!-- fine TABELLA USER -->
      		<%  
             }/*fine di ("searchID")==searchUser*/
     	     
     	
     		if(request.getParameter("searchID").equals("searchAppartment")){/*quando il check è su "ricerca apt"*/
     		
     		%>
     		<!-- inizio STAMPA TABELLA APPARTAMENTI -->
     	      <h3 class="mt-5">Appartamenti</h3>
     	      <table class="table table-striped">
     	        <thead>
     	        <tr>
     	            <th scope="col">ID</th>
     	            <th scope="col">Appartamento</th>
     	            <th scope="col">Voto</th>
     	            <th scope="col">Testo</th>
     	            <!-- <th scope="col">Link</th> -->
     	          </tr>
     	          </thead>
     	        <tbody>
     	        <% 
     	       	ArrayList<RecensioneAppartamento> rc=viewBean2.beanRicercaAppartamento();
            	for(int i=0;i<rc.size();i++) { //Prelevo valore dall'arrayList e richiamo il Getter della RecensioneAppartamento
     	        %>
     	           <!-- RISULTATO DEL CICLO FOR
     	           <tr>
     	            <th scope="row" id="idRecApt"><i class="fas fa-home"></i></th>
     	            <td id="nomeAppartamento">NomeAppartamento</td>
     	            <td id="votoAppartamento">8</td>
     	            <td id="testoAppartamento">Testo della recensione</td>
     	          </tr>  -->
     	          
     	          <tr>
		    	       <th scope="row"> <%=rc.get(i).getIdApt() %></th>
		    	       <td><%=rc.get(i).getMedia() %></td>
		    	  </tr>
     	          
     	          <%  
                }%>
                 </tbody>
     	      </table><!-- fine STAMPA TABELLA APPARTAMENTI -->
     	      
              <%  
              }/*fine di ("searchID")==searchAppartment*/
     } /*fine di ("searchID")!=null*/
     
     %>

      

        

    </div>
    <!-- fine DATI -->

    <jsp:include page="footer.jsp"/>

  </body>
</html>