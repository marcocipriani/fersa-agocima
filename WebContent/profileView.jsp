<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html lang="it" dir="ltr">
  <jsp:include page="header.jsp"/>

    <!-- inizio DATI -->
    <div class="" style="background-color: #bdbbd18c;">
      <div class="container">
        <div class="row mb-5 p-2">
        <form action="../model/ActualUsr.java">              <!-- preleva i dati NICKNAME e ROLE ActualUser.java -->
        	<div class="col">
            <h5>Nick: <span id="nickname" name="nickname">Mimmo</span></h5>
          </div>
          <div class="col">
            <h5>Ruolo: <span id="role" name="role"></span> locatore</h5>
          </div>
        </form>
        </div>
      </div>
    </div>

    <div class="container">
      <p class="lead">Contratti</p>
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Appartamento</th>
            <th scope="col">Status</th>
            <th scope="col">Valutazione</th>
            <th scope="col">Azioni permesse</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row" id="idContratto">1</th>
            <td id="nomeAppartamento">Casale Bianco</td>
            <td id="expired">in corso</td>
            <th id="faseValutazione">---</th>
            <th>
            
            <!-- BOTTONE CREATE -->
            <button type="button" class="btn btn-primary my-1" data-toggle="modal" data-target="#createModal">Crea</button>
            <!-- inizio Modal CREATE -->
		    <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="createModalTitle" aria-hidden="true">
		    	<div class="modal-dialog" role="document">
		        	<div class="modal-content">
		          		<div class="modal-header">
		                	<h5 class="modal-title" id="exampleModalLongTitle" style="text-transform: uppercase;">Creazione Recensione</h5>
		                	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		                  		<span aria-hidden="true">&times;</span>
		                	</button>
		              	</div>
		              	<div class="modal-body"><!-- inizio CORPO COMPILAZIONE MODULO -->
		                	<jsp:include page="modalCreate.jsp"/><!-- richiama la pagina modalCreate -->
		              	</div><!-- fine CORPO COMPILAZIONE MODULO -->
		              	<div class="modal-footer">
		                	<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
		              	</div>
		            </div>
		        </div>
		     </div>
		     <!-- fine Modal CREATE -->
		     
		     
		    <!-- BOTTONE DELETE -->
            <button type="button" class="btn btn-warning my-1" data-toggle="modal" data-target="#deleteModal">Elimina</button>
            <!-- inizio Modal DELETE -->
		    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalTitle" aria-hidden="true">
		    	<div class="modal-dialog" role="document">
		        	<div class="modal-content">
		          		<div class="modal-header">
		                	<h5 class="modal-title" id="exampleModalLongTitle" style="text-transform: uppercase;">Cancellazione recensione</h5>
		                	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		                  		<span aria-hidden="true">&times;</span>
		                	</button>
		              	</div>
		              	<div class="modal-body"><!-- inizio CORPO COMPILAZIONE MODULO -->
		                	<p>La tua recensione è stata eliminata</p>
		              	</div><!-- fine CORPO COMPILAZIONE MODULO -->
		              	<div class="modal-footer">
		                	<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
		              	</div>
		            </div>
		        </div>
		     </div>
		     <!-- fine Modal DELETE -->
		        
		        
              
        
        	<!-- BOTTONE VIEW REC APT -->
            <button type="button" class="btn btn-primary my-1" data-toggle="modal" data-target="#viewEvalModal">View recensione</button>
	        <!-- inizio Modal VIEW REC APT -->
			<div class="modal fade" id="viewEvalModal" tabindex="-1" role="dialog" aria-labelledby="viewAptModalTitle" aria-hidden="true">
			    <div class="modal-dialog" role="document">
			        <div class="modal-content">
			          	<div class="modal-header">
			                <h5 class="modal-title" id="exampleModalLongTitle" style="text-transform: uppercase;">View rec. Appartamento</h5>
			                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			                  	<span aria-hidden="true">&times;</span>
			                </button>
			              </div>
			              <div class="modal-body"><!-- inizio CORPO COMPILAZIONE MODULO -->
			                <jsp:include page="modalViewEval.jsp"/><!-- richiama la pagina modalCreate -->
			              </div><!-- fine CORPO COMPILAZIONE MODULO -->
			              <div class="modal-footer">
			                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
			              </div>
			           </div>
			       </div>
			 </div>
			 <!-- fine Modal VIEW REC APT -->
			     
             
            </th>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Casetta in Canada</td>
            <td>in corso</td>
            <!-- <th>---</th> -->
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Villetta Borghese</td>
            <td>da recensire</td>
            <!-- <th><a href="createEval.html">da compilare</a></th> -->
          </tr>
          <tr>
            <th scope="row">4</th>
            <td>Stazione Spaziale</td>
            <td>da recensire</td>
            <th>recensito</th>
          </tr>
          <tr>
            <th scope="row">5</th>
            <td>Casa Beggins</td>
            <td>recensito</td>
            <!-- <th><a href="viewEval.html">pubblicata</a></th> -->
          </tr>
        </tbody>
      </table>

    </div>

    <!-- fine DATI -->

    <jsp:include page="footer.jsp"/>

  </body>
</html>