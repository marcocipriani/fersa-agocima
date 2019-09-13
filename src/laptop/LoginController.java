package laptop;

import java.io.IOException;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import laptop.ControllerViewRenter;


public class LoginController {
	
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField pwd;
    
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
    	String user =username.getText();
    	String password=pwd.getText();
    	ActualUsr d;
    	d = UsrDAO.findByUsername(user, password, false); 
    	if (isTenant.isSelected()==false) {
    		System.out.println(password);
    		System.out.println(d.getPwd());
    		if (password.equals(d.getPwd())) {
		    	try {
		    		FXMLLoader loader=new FXMLLoader(getClass().getResource("profileViewRenter.fxml"));
		        	Parent root=(Parent) loader.load();
		        	
		        	ControllerViewRenter addcontroller=loader.getController();
		        	addcontroller.setRentername(d.getName());
		        	addcontroller.getRentername(d.getName());
		        	
		       		Stage stage=new Stage();
		       		stage.setScene(new Scene(root));
		        	stage.show();
		    		}
		    	catch(IOException e) {
		    		e.printStackTrace();
		    	}
    		}
		    else {
		    	System.out.println("Nessuna corrispondenza neva trovata");
		    }
    		}
    	else {
    		if(pwd.getText()==d.getPwd()) {
    			System.out.println("fai vista locatario");
    		}
    		else {
		    	System.out.println("Nessuna corrispondenza mai trovata");
		    }
    	}
    }

}
