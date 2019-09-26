package controller;

import model.Eval;
import dao.EvalAptDAO;
import dao.EvalUsrDAO;

public class ViewController {

    public static Eval getEval(int evalId, boolean isEvalAboutUsr){
        if (!isEvalAboutUsr){ return (EvalAptDAO.findById(evalId));
        } else { return EvalUsrDAO.findById(evalId);}
    }
}