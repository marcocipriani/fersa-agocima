package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import controller.ControllerLogin;
import dao.UsrDAO;
import model.ActualUsr;

public class ControllerLogin {
	
	
	
	
	
	/*inizio codice alternativo*/
	
	public static boolean ricercaLogin(String username,String password) {
		
		try {
	        System.out.println("Creo utente");
		
	        ActualUsr user = new ActualUsr();
	        user = UsrDAO.findByNickname(username, password, false); //false=locatario
        
	        if (user == null) {
	        	/*response.sendRedirect("homepage.jsp");*/
	        	System.out.println("login errato");
	        	return false;
        		} 
	        else { 
	        	/*HttpSession session = request.getSession(true);
	        	session.setAttribute("currentSessionUser", user);
	        	response.sendRedirect("profileView.html");*/
	        	return true;
	        } 
			} catch (Throwable e) { System.out.println(e);}
		}
	
/*fine codice alternativo*/
	
	
	
	
	
	/*inizio codice Fabio*/
	/*public static String whoAmI = null;
	private static ControllerLogin instance;
	public static ControllerLogin getInstance() {
		if (instance == null) instance = new ControllerLogin();
		return instance;
	    }
	
	
	public String Login(String u,String p) {
		
		ArrayList<UtenteContratto> arrayUtente,arrayUtente2;
		arrayUtente=UtenteContrattoDao.ListaUtenti();
		arrayUtente2=UtenteContrattoDao.ListaUtentiLocatori();
		boolean a=true;
		
		 Object [] riga= new Object[100];*/ //Creo Un oggetto Riga
		 //--------------------------------------------------------------------------------------
		
		    /*if(a==true) {
		    
			for(int i=0;i<arrayUtente.size();i++) {
		    	riga[0]=arrayUtente.get(i).getIdLocatario();*///Prelevo valore dall'arrayList e richiamo il Getter della RecensioneAppartamento
		    	/*riga[1]=arrayUtente.get(i).getPassword();
		    	int idloc=(int)riga[0];
		    	
		    	String pw=(String)riga[1];
		    if(idloc==Integer.parseInt(u)) {*///Ora che abbiamo visto che l'utente � un locatore Controllo se pass inserita � giusta
		    	                               /*if(pw.equals(p))
		    	                               {whoAmI="Locatario";
		    	                               }
		    	                             
		    	                               
		    	                               else {
		    	                            	  System.out.println("Errore Login!");
		    	                               }
		    	                               }
		    else { a=false;}
		    }*/
		    //----------------------------------------------------------------------------------------------
		    /*if(a==false) {
		   for(int j=0;j<arrayUtente2.size();j++) {
		 riga[0]=arrayUtente2.get(j).getIdLocatario();*///Prelevo valore dall'arrayList e richiamo il Getter della RecensioneAppartamento
		 /*riga[1]=arrayUtente2.get(j).getPassword();
		
		 int idloc=(int)riga[0];
		
		String pw=(String)riga[1];
		if(idloc==Integer.parseInt(u)) {*///Ora che abbiamo visto che l'utente � un locatore Controllo se pass inserita � giusta
			    	    	                               /*if(pw.equals(p))
			    	    	                               {whoAmI="Locatore";
			    	    	                              
			    	    	                   	    	   } else { System.out.println("Errore Login!");}
			    	    	                               }}}
	}
		    return whoAmI;
	}*/
	/*Fine codice Fabio*/
	
	
	
	

	
	
	
	
	
	
/*inizio codice vecchio*/
	/*try {
        System.out.println("Creo utente");
        String nick = request.getParameter("nickname");
        String pass = request.getParameter("password");
        boolean checkboxValues;
        if (request.getParameter("checkTenant") == "tenant") {checkboxValues = true;}
        else {checkboxValues = false;}
        
        ActualUsr user = new ActualUsr();
        
        user = UsrDAO.findByNickname(nick, pass, checkboxValues);

        if (user == null) {
        	response.sendRedirect("homepage.jsp");
        	System.out.println("login errato");
        	return false;
        	} 
        else { 
        	HttpSession session = request.getSession(true);
            session.setAttribute("currentSessionUser", user);
            response.sendRedirect("profileView.html");
            return true;
        } 

    } catch (Throwable e) { System.out.println(e);}*/
/*fine codice vecchio*/
	
	
	
}
