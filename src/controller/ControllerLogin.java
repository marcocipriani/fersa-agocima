package controller;

import javax.servlet.http.HttpSession;

import dao.UsrDAO;
import model.ActualUsr;

public class ControllerLogin {

	try {
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
            response.sendRedirect("profileView.html"); // area riservata agli utenti registrati
            return true;
        } 

    } catch (Throwable e) { System.out.println(e);}
}
