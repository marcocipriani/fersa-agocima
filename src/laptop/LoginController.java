package laptop;

import java.io.IOException;
import java.util.ResourceBundle;

import dao.UsrDAO;
import model.ActualUsr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import laptop.ControllerViewRenter;


public class LoginController {
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private TextField nickname;
    
    @FXML
    private TextField pwd;
    
    @FXML
    private Button accedi;
    
    @FXML
    private CheckBox isTenant;
    
    @FXML
    private Button cerca;

    @FXML
    private Label txtStatus;
    
    @FXML
    void EffLogin(ActionEvent event) {
    	String user;
    	String password;
    	user=nickname.getText();
    	password=pwd.getText();
    	ActualUsr d;
    	d = UsrDAO.findByNickname(user, password, false);
    	if( d != null ) {
    		try {
    			
        		FXMLLoader loader=new FXMLLoader(getClass().getResource("profileViewRenter"));
        		Parent root=(Parent) loader.load();
        		
        		ControllerViewRenter addcontroller=loader.getController();
        		addcontroller.idowner(user);
        		
        		Stage stage=new Stage();
        		stage.setScene(new Scene(root));
        		stage.show();
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
    	else {
    		txtStatus.setText("Accesso non avvenuto!");
    	}

    }

	@FXML
    void initialize() {
        assert nickname != null : "fx:id=\"nickname\" was not injected: check your FXML file 'Login.fxml'.";
        assert pwd != null : "fx:id=\"pwd\" was not injected: check your FXML file 'Login.fxml'.";
        assert accedi != null : "fx:id=\"accedi\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtStatus != null : "fx:id=\"txtStatus\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
