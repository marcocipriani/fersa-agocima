package controller;

import java.sql.SQLException;

import dao.EvalAptDAO;
import dao.EvalUsrDAO;
import model.Eval;

public class EditController {
    public static void setEval(int evalId, String text, int stars, boolean isForUsr) throws SQLException {
        if (!isForUsr){ EvalAptDAO.updateEval(text, stars, evalId); }
        else { EvalUsrDAO.updateEval(text, stars, evalId); }
    }
    
    public static Eval getEval(int evalId, boolean isForUsr){
        if (!isForUsr){ return (EvalAptDAO.findById(evalId)); }
        else { return EvalUsrDAO.findById(evalId);}
    }

    public static void deleteEval(int evalId, boolean isForUsr){
        if (!isForUsr){ EvalAptDAO.deleteEval(evalId); }
        else { EvalUsrDAO.deleteEval(evalId); }
    }
}

