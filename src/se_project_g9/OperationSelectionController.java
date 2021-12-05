/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author idamaruotto
 */
public class OperationSelectionController implements Initializable {

    private ObservableList<Map.Entry<String,UDOperation>> variables = null;
    @FXML
    private TableView<Map.Entry<String,UDOperation>> tableView;
    @FXML
    private TableColumn<Map.Entry<String,UDOperation>, String> nameCln;
    @FXML
    private TableColumn<Map.Entry<String,UDOperation>, String> OperationsCln;
    
    private HashMap<String,UDOperation> vars;
    @FXML
    private MenuItem removeBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        removeBtn.disableProperty().bind(Bindings.isEmpty(tableView.selectionModelProperty().get().getSelectedItems()));
    }    

    @FXML
    private void removeClick(ActionEvent event) {
        vars.remove(tableView.getSelectionModel().getSelectedItem().getKey());
        variables.remove(tableView.getSelectionModel().getFocusedIndex());
        
    }

    public void setVariables(HashMap<String, UDOperation> variables) {
        
        this.variables = FXCollections.observableArrayList(variables.entrySet());
        this.vars = variables;
        
        nameCln.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getKey());
        });
        OperationsCln.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getValue().toString());
        });
        
        tableView.setEditable(true);
        nameCln.setEditable(true);
        OperationsCln.setEditable(true);
        
        nameCln.setCellFactory((TextFieldTableCell.forTableColumn()));
        OperationsCln.setCellFactory((TextFieldTableCell.forTableColumn()));
        
        tableView.setItems(this.variables);
    }

    @FXML
    private void menu(ActionEvent event) {
    }

    @FXML
    private void modifyCommitName(TableColumn.CellEditEvent<Map.Entry<String,UDOperation>, String> event) {
        
    }

    @FXML
    private void modifyCommitOperation(TableColumn.CellEditEvent<Map.Entry<String,UDOperation>, UDOperation> event) {
    }

    
        
        
    
    
}
