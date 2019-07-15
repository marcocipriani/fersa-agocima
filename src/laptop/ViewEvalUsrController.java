package laptop;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.EvalUsr;
import javafx.scene.control.Button;


public class ViewEvalUsrController {
	
	@FXML
    private Label evalfrom;
	@FXML
    private Label voto;
	@FXML
    private Label evaltext;
	@FXML
	private Button backbutton;

	
	@FXML
	void GoBack(ActionEvent event) {
		Stage stage = (Stage) backbutton.getScene().getWindow();
		stage.close();
	}
	
	
	public void setEval(EvalUsr valutazione) {
    	evalfrom.setText(valutazione.getEvalusr());
    	voto.setText(Integer.toString(valutazione.getStars()));
    	evaltext.setText(valutazione.getText());
    	}
	

}
