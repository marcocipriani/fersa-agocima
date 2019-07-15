package laptop;

import java.io.IOException;
import java.util.Vector;

import dao.EvalUsrDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Eval;
import model.EvalUsr;

public class ControllerOwnEval {
	
	@FXML
	private TableView<EvalUsr> tabella;
    @FXML
    private TableColumn<EvalUsr, String> targetColumn;
    @FXML
    private TableColumn<EvalUsr, String> starsColumn;
    @FXML
    private TableColumn<EvalUsr, Void> evalAzioni;
    @FXML
    private TableColumn<EvalUsr, String> evaltestoColumn;
    @FXML
    private Button perUtente;
    @FXML
    private Button perPersona;
    @FXML
    private Label owner;
    

    @FXML
    void VisuallizaPerUtente(ActionEvent event) {
    	tabella.setEditable(true); 
        
        Vector<EvalUsr> evusr = EvalUsrDAO.findEvalMadeByYou(owner.getText());
        System.out.println(owner.getText());
        ObservableList<EvalUsr> valutazioni = FXCollections.observableArrayList();
        for(int i=0;i < evusr.size();i++) {
        	valutazioni.add(evusr.get(i));
        }

       targetColumn.setCellValueFactory( new PropertyValueFactory("nickname") );
       evaltestoColumn.setCellValueFactory( new PropertyValueFactory("text") );

       starsColumn.setCellValueFactory( new PropertyValueFactory("stars") );

       evalAzioni.setCellFactory(param -> new TableCell<EvalUsr,Void>() {
            private final Button deleteButton = new Button("Modifica");
            private final Button viewButton = new Button("Visualizza");
            HBox pane = new HBox(deleteButton,viewButton);


            @Override
            protected void updateItem(Void patient, boolean empty) {
                super.updateItem(patient, empty);

                if (empty) {
                    //System.out.println("null");
                    setGraphic(null);
                    return;
                }
                deleteButton.setOnAction(event -> {
                    EvalUsr valuser= (EvalUsr) getTableView().getItems().get(getIndex());
                    //System.out.println(basicApp.getId().getId());
                    EvalUsrDAO.deleteEval(valuser.getId());
                    tabella.getItems().remove(valuser);
                 });
                 
                 viewButton.setOnAction(event -> {
               	  EvalUsr valuser= (EvalUsr) getTableView().getItems().get(getIndex());
               	  
               	try {
        			
            		FXMLLoader loader=new FXMLLoader(getClass().getResource("OwnUsrRecensioni.fxml"));
            		Parent root=(Parent) loader.load();
            		ControllerOwnUsrRecensioni addcontroller=loader.getController();
            		addcontroller.setVal(valuser);

            		
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

         tabella.setItems(valutazioni);
     	
     }
    
    public void setOwnName(String name) {
    	owner.setText(name);
    }
    
    
}  