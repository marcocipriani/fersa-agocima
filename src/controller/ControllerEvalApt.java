package controller;


import java.util.ArrayList;

import model.EvalApt;
import dao.EvalAptDAO;

public class ControllerEvalApt {
	
	private ArrayList<EvalApt> eval;
	private static ControllerEvalApt instance;
	public static ControllerEvalApt getInstance() {
		if (instance == null) {  instance = new ControllerEvalApt();  }
	        return instance;
	    }
	 
	 public ArrayList<EvalApt> addEval() {
		
	 }
	 
	 public boolean sendToDataBase(String textEval, Integer stars, String status, String aptId, String owner, String evalUsr) {
		 
		 /*identificatori*/
		 int usrId=Integer.parseInt(viewBean.nickname);
		 int aptId=Integer.parseInt(aptId);
		 }
	 
	 return eval;
		
	}


