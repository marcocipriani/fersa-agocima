package controller;

import model.EvalApt;
import model.EvalUsr;
import model.Eval;

import java.util.ArrayList;



public class ControllerView {
	
	private static ControllerView instance;
	public static ControllerView getInstance() {
		if (instance == null) instance = new ControllerView();
	    return instance;
	}
	
	
	/*
	 * nell'esempio di Fabio hanno nella dao RecensioneAppartamenti -->  public static ArrayList<RecensioneAppartamento> tabella() {..}
	 * che ritorna una lista, mentre noi abbiamo una ricerca solo tramite nickname
	 * */
	//restituisce  la lista dei Appartamenti recensiti !!RecensioneApt!! andrebbe definita nella dao
	public ArrayList<EvalApt> RicercaApt() {
		ArrayList<EvalApt> rc;
		rc= AptDAO.findByID(); //restituisce Apt
		for(int i=0;i<rc.size();i++) {
		  	int idApp=rc.get(i).getIdApt();//Prelevo valore dall'arrayList e richiamo il Getter della RecensioneApt
		   	double Media=rc.get(i).getMedia();
		   	}
		return rc;
	}
								
								
	//restituisce  la lista dei Locatari recensiti !!RecensioneUsr!! andrebbe definita nella dao		
	public ArrayList<EvalUsr> RicercaUsr() {
		ArrayList<EvalUsr> rc;
		rc= RecensioneLocatarioDao.tabellaLocatario();
		for(int i=0;i<rc.size();i++) {
		  	int idApp=rc.get(i).getIdUsr();//Prelevo valore dall'arrayList e richiamo il Getter della RecensioneUsr
		   	double Media=rc.get(i).getMedia();
		   	}
		return rc;
	}
	
	//restituisce  la lista dei Appartamenti recensiti 
	public ArrayList<AptDAO> findByID() {
		ArrayList<EvalApt> rc;
		rc= RecensioniAppartamentoDao.tabella();
		for(int i=0;i<rc.size();i++) {
		  	int idApp=rc.get(i).getIdApt();//Prelevo valore dall'arrayList e richiamo il Getter della RecensioneApt
		   	double Media=rc.get(i).getMedia();
		   	}
		return rc;
	}

}
