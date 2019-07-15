package laptop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.EvalUsr;

public class ControllerOwnUsrRecensioni {
	@FXML
    private Label evaltarget;
	@FXML
    private Label yourvoto;
	@FXML
    private Label evalyourtext;
	@FXML
	private Button backbutton;

	
	@FXML
	void GoBack(ActionEvent event) {
		Stage stage = (Stage) backbutton.getScene().getWindow();
		stage.close();
	}
	

	public void setVal(EvalUsr valuser) {
		// TODO Auto-generated method stub
		evaltarget.setText(valuser.getEvalusr());
    	yourvoto.setText(Integer.toString(valuser.getStars()));
    	evalyourtext.setText(valuser.getText());
		
	}

}
