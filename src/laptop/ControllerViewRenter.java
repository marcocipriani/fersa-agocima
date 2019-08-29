package laptop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import model.Contract;
import model.EvalUsr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import dao.EvalUsrDAO;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class ControllerViewRenter {
	
	@FXML
	private TableView<EvalUsr> table;
    @FXML
    private TableColumn<EvalUsr, String> fattadaColumn;
    @FXML
    private TableColumn<EvalUsr, String> votoColumn;
    @FXML
    private TableColumn<EvalUsr, String> evalAction;
    @FXML
    private TableColumn<EvalUsr, String> evaltextColumn;
    @FXML
    private Label nicknameRenter;
    @FXML
    private Button viewEval;
    @FXML
    private Button createeval;
    @FXML
    private Button evaltue;
    
    private String nomeRenter;
    
    @FXML
    void EffVisualizza(ActionEvent event) {
    	table.setEditable(true); 
        
        

        Vector<EvalUsr> evusr = EvalUsrDAO.findYourEvals(nomeRenter);
        ObservableList<EvalUsr> valutazioni = FXCollections.observableArrayList();
        for(int i=0;i < evusr.size();i++) {
        	valutazioni.add(evusr.get(i));
        	System.out.println(valutazioni);
        }

       fattadaColumn.setCellValueFactory( new PropertyValueFactory("evalusr") );
       evaltextColumn.setCellValueFactory( new PropertyValueFactory("text") );

       votoColumn.setCellValueFactory( new PropertyValueFactory("stars") );

       evalAction.setCellFactory(param -> new TableCell<EvalUsr,String>() {
            private final Button deleteButton = new Button("Rimuovi");
            private final Button viewButton = new Button("Visualizza");
            HBox pane = new HBox(deleteButton,viewButton);


            @Override
            protected void updateItem(String patient, boolean empty) {
                super.updateItem(patient, empty);

                if (empty) {
                    //System.out.println("null");
                    setGraphic(null);
                    return;
                }

                deleteButton.setOnAction(event -> {
                   EvalUsr valuser= getTableView().getItems().get(getIndex());
                   //System.out.println(basicApp.getId().getId());
                   EvalUsrDAO.deleteEval(valuser.getId());
                   table.getItems().remove(valuser);
                });
                
                viewButton.setOnAction(event -> {
              	  EvalUsr valuser= getTableView().getItems().get(getIndex());
                    
              	  try {
            			
                		FXMLLoader loader=new FXMLLoader(getClass().getResource("Recensione.fxml"));
                		Parent root=(Parent) loader.load();
                		ViewEvalUsrController addcontroller=loader.getController();
                		addcontroller.setEval(valuser);

                		
                		Stage stage=new Stage();
                		stage.setScene(new Scene(root));
                		stage.show();
            		}catch(IOException e) {
            			e.printStackTrace();
            		}
                });
                

                setGraphic(pane);//<<<---------------add button 1

            }
        });

        table.setItems(valutazioni);
    	
    }
    
    @FXML
    void StoricoEval(ActionEvent event) {
    	try {
			
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("OwnRecensioni.fxml"));
    		Parent root=(Parent) loader.load();
    		ControllerOwnEval addcontroller=loader.getController();
    		addcontroller.setOwnName(nomeRenter);
    		addcontroller.getOwnname(nomeRenter);
    		System.out.println("ezzelo utente"+ nomeRenter);
    		Stage stage=new Stage();
    		stage.setScene(new Scene(root));
    		stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
    	
    }
        
    
    public String getRentername(String name) {
    	return nomeRenter = name;
    }
    
    
    
    public void setRentername(String name) {
    	nicknameRenter.setText(name);
    }
    
}
    
    
    
    
    