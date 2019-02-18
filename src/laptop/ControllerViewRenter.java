package laptop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Contract;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class ControllerViewRenter {
	
	@FXML
	private TableView<Contract> table;
    @FXML
    private TableColumn<Contract, String> renterColumn;
    @FXML
    private TableColumn<Contract, String> tenantColumn;
    @FXML
    private TableColumn<Contract, String> appColumn;
    @FXML
    private TableColumn<Contract, Void> actionContract;
    @FXML
    private Label nicknameRenter;
    @FXML
    private Button viewEval;
    @FXML
    private Button showContract;
    
    
    public void idowner(String s) {
    	nicknameRenter.setText(s);
    }
}
    
    
    
    
    