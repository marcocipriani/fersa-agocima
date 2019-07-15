package controller;

import java.util.ArrayList;

import model.EvalApt;
import model.EvalUsr;
import dao.EvalUsrDAO;

public class ControllerEvalUsr {
	
	private ArrayList<EvalUsr> eval;
	private static ControllerEvalUsr instance;
	public static ControllerEvalUsr getInstance() {
		if (instance == null) {  instance = new ControllerEvalUsr();  }
	        return instance;
	    }
	 
	 public ArrayList<EvalUsr> addEval() {
		
	 }
	 
	 public boolean sendToDataBase(String textEval, Integer stars, String status, String nickname, String evalUsr) {
		 
		 
		 }
	 
	 return eval;

}
