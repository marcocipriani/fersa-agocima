/*package web;*/

import java.io.*,java.util.*"
import javax.activation.*"
import javax.servlet.http.*,javax.servlet.*"
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsrDAO;
import model.ActualUsr;
import model.Usr;

import java.io.IOException;

@WebServlet(name = "ControllerLogin")
public class ControllerLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}