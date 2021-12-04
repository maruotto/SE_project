/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableListValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author idamaruotto
 */
public class OperationSelectionController implements Initializable {

    private ObservableList<Map> variables;
    @FXML
    private TableView<Map> tableView;
    @FXML
    private TableColumn<Map, String> nameCln;
    @FXML
    private TableColumn<Map, UDOperation> OperationsCln;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCln.setCellValueFactory(new MapValueFactory<String>("name"));
        OperationsCln.setCellValueFactory(new MapValueFactory<UDOperation>("UDOperation"));
        tableView.setItems(variables);
    }    

    @FXML
    private void removeClick(ActionEvent event) {
        
    }

    @FXML
    private void modifyClick(ActionEvent event) {
    }

    public void setVariables(HashMap<String, UDOperation> variables) {
        this.variables = FXCollections.observableArrayList();
        this.variables.addAll(variables);
    }
    
    
    
}
