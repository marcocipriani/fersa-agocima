package controller;

import dao.EvalAptDAO;
import dao.EvalUsrDAO;
import model.Eval;
import model.EvalApt;

public class ViewController {

    public static Eval getEval(int evalId, boolean isEvalAboutUsr){
        if (!isEvalAboutUsr){ return (EvalAptDAO.findById(evalId));
        } else { return EvalUsrDAO.findById(evalId); }
    }
}
