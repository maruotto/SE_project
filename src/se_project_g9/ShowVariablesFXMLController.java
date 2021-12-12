/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author idamaruotto
 */
public class ShowVariablesFXMLController implements Initializable {

    @FXML
    private TableColumn<Map.Entry<Character, ComplexNumber>, String> VariableCln;
    @FXML
    private TableColumn<Map.Entry<Character, ComplexNumber>, String> ValueCln;
    @FXML
    private TableView <Map.Entry<Character, ComplexNumber>> tableView;
    
    private ObservableList<Map.Entry<Character, ComplexNumber>> variables;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    public void setVariables(ApplicationOperation ope) {

        this.variables = FXCollections.observableArrayList(ope.getVariables().getVariablesMap().entrySet());

        VariableCln.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getKey().toString());
        });
        ValueCln.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getValue().toString());
        });

        tableView.setEditable(false);
        
        tableView.setItems(this.variables);
    }
}
