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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    private String nomeRenter;
    
    @FXML
    void EffVisualizza(ActionEvent event) {
    	table.setEditable(true); 
        
        

        Vector<EvalUsr> evusr = EvalUsrDAO.findYourEvals(nomeRenter);
    	//ArrayList<BasicAppartament> a=d.read(idpro.getText());
        ObservableList<EvalUsr> valutazioni = FXCollections.observableArrayList();
        for(int i=0;i < evusr.size();i++) {
        	valutazioni.add(evusr.get(i));
        	System.out.println(valutazioni);
        }

       fattadaColumn.setCellValueFactory( new PropertyValueFactory("evalusr") );
       evaltextColumn.setCellValueFactory( new PropertyValueFactory("text") );

       votoColumn.setCellValueFactory( new PropertyValueFactory("stars") );

        /*buttonsColumn.setCellFactory(param -> new TableCell<BasicAppartament, Void>() {
            private final Button editButton = new Button("Modifica");
            private final Button deleteButton = new Button("Rimuovi");
            private final Button viewButton = new Button("Visualizza");
            HBox pane = new HBox(deleteButton, editButton,viewButton);


            @Override
            protected void updateItem(Void patient, boolean empty) {
                super.updateItem(patient, empty);

                if (empty) {
                    //System.out.println("null");
                    setGraphic(null);
                    return;
                }

                deleteButton.setOnAction(event -> {
                   BasicAppartament basicApp= getTableView().getItems().get(getIndex());
                   //System.out.println(basicApp.getId().getId());
                   new BasicAppartament().RemoveAppartament(basicApp);
                   table.getItems().remove(basicApp);
                });
                
                viewButton.setOnAction(event -> {
              	  BasicAppartament basicApp= getTableView().getItems().get(getIndex());
                    
              	  try {
            			
                		FXMLLoader loader=new FXMLLoader(getClass().getResource("View.fxml"));
                		Parent root=(Parent) loader.load();
                		
              
                		ControllerView addcontroller=loader.getController();
                	
                		
                		addcontroller.idowner(idpro.getText());
                		addcontroller.instace(basicApp);
                		
                		Stage stage=new Stage();
                		stage.setScene(new Scene(root));
                		stage.show();
            		}catch(IOException e) {
            			e.printStackTrace();
            		}
                });

                editButton.setOnAction(event -> {
                    BasicAppartament basicApp= getTableView().getItems().get(getIndex());
                    
              	  try {
            			
                		FXMLLoader loader=new FXMLLoader(getClass().getResource("Edit.fxml"));
                		Parent root=(Parent) loader.load();
                		
              
                		ControllerEdit addcontroller=loader.getController();
                	
                		
                		addcontroller.idowner(idpro.getText());
                		addcontroller.idappartament(basicApp.getId().getId());
                		addcontroller.ShortD(basicApp.getDes().getShortDescription());
                		addcontroller.FullD(basicApp.getDes().getFullDescription());
                		addcontroller.surface(Double.toString(basicApp.getSurface()));
                		addcontroller.address(basicApp.getAddress().getIndrizzo());
                		addcontroller.floor(basicApp.getAddress().getPiano());
                		addcontroller.scale(basicApp.getAddress().getScala());
                		addcontroller.interno(basicApp.getAddress().getInterno());
                		addcontroller.Lat(basicApp.getCs().getLatitudine());
                		addcontroller.Log(basicApp.getCs().getLongitudine());
                		addcontroller.pathImage(basicApp.getImg().getPathImage());
                		addcontroller.pathPlant(basicApp.getPlant().getPathImage());
                		
                		
            
                		
                		Stage stage=new Stage();
                		stage.setScene(new Scene(root));
                		stage.show();
            		}catch(IOException e) {
            			e.printStackTrace();
            		}
                });

                setGraphic(pane);//<<<---------------add button 1

            }
        });*/

        table.setItems(valutazioni);
    	
    }
    
    
    
    
    
    public String getRentername(String name) {
    	return nomeRenter = name;
    }
    
    
    
    public void setRentername(String name) {
    	nicknameRenter.setText(name);
    }
    
}
    
    
    
    
    