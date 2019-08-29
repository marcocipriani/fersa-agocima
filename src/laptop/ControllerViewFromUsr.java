package laptop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.EvalUsr;

public class ControllerViewFromUsr {
	
	@FXML
    private Label evalfromusr;
	@FXML
    private Label stars;
	@FXML
    private Label evaltextfromusr;
	@FXML
	private Button backbutton;
	@FXML
	void GoBack(ActionEvent event) {
		Stage stage = (Stage) backbutton.getScene().getWindow();
		stage.close();
	}
	

	public void viewEval(EvalUsr valutazione) {
		evalfromusr.setText(valutazione.getEvalusr());
    	stars.setText(Integer.toString(valutazione.getStars()));
    	evaltextfromusr.setText(valutazione.getText());
		
	}

}
