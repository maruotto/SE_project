/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableListValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
import javafx.scene.control.cell.TextFieldTableCell;
import static javafx.scene.input.KeyCode.V;
import javafx.util.Callback;
import se_project_g9.commands.Command;

/**
 * FXML Controller class
 *
 * @author idamaruotto
 */
public class OperationSelectionController implements Initializable {

    private ObservableList<Op> variables  = FXCollections.observableArrayList();
    @FXML
    private TableView<Op> tableView;
    @FXML
    private TableColumn<Op, String> nameCln;
    @FXML
    private TableColumn<Op, String> OperationsCln;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.setEditable(true);
        nameCln.setEditable(true);
        OperationsCln.setEditable(true);
        System.out.println(this.variables);
        nameCln.setCellValueFactory(new PropertyValueFactory<Op, String>("name"));
        OperationsCln.setCellValueFactory(new PropertyValueFactory<Op, String>("udOp"));
        OperationsCln.setCellFactory((TextFieldTableCell.forTableColumn()));
        tableView.setItems(variables);
    }    

    @FXML
    private void removeClick(ActionEvent event) {
        
    }

    @FXML
    private void modifyClick(ActionEvent event) {
    }

    public void setVariables(HashMap<String, UDOperation> variables) {
        for(String s: variables.keySet()){
            this.variables.add(new Op(s, variables.get(s)));
        }
    }
    
    private class Op{
        private String name;
        private String udOp;

        public Op(String name, UDOperation<Command> udOp) {
            this.name = name;
            this.udOp = udOp.toString();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUdOp() {
            return udOp;
        }

        public void setUdOp(UDOperation<Command> udOp) {
            this.udOp = udOp.toString();
        }

        @Override
        public String toString() {
            return name + ", udOp=" + udOp;
        }
        
        
        
        
        
    }
    
    
}
