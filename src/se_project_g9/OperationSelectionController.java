/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import se_project_g9.commands.Command;

/**
 * FXML Controller class
 *
 * @author idamaruotto
 */
public class OperationSelectionController implements Initializable {

    private final ObservableList<Map.Entry<String,UDOperation<Command>>> variables  = FXCollections.observableArrayList();
    @FXML
    private TableView<Map.Entry<String,UDOperation<Command>>> tableView;
    @FXML
    private TableColumn<Map.Entry<String,UDOperation<Command>>, String> nameCln;
    @FXML
    private TableColumn<Map.Entry<String,UDOperation<Command>>, UDOperation<Command>> OperationsCln;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("get" + this.variables);
        tableView.setEditable(true);
        nameCln.setEditable(true);
        OperationsCln.setEditable(true);
        
        nameCln.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getKey());
        });
        OperationsCln.setCellValueFactory((param) -> {
            return new SimpleObjectProperty(param.getValue().getValue());
        });

        tableView.setItems(variables);
        
        
        
    }    

    @FXML
    private void removeClick(ActionEvent event) {
        
    }

    public void setVariables(HashMap<String, UDOperation> variables) {
        Set s = variables.entrySet();
        this.variables.addAll(s);
        System.out.println("set" + this.variables);
    }

    @FXML
    private void modifyCommitName(TableColumn.CellEditEvent<Map.Entry<String,UDOperation<Command>>, String> event) {
        String oldValue = event.getOldValue();
        String newValue = event.getNewValue();
        
    }
    
    @FXML
    private void modifyCommitOperation(TableColumn.CellEditEvent<Map.Entry<String,UDOperation<Command>>, String> event) {
        String oldValue = event.getOldValue();
        String newValue = event.getNewValue();
        
    }

    
    public class Op{
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

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 37 * hash + Objects.hashCode(this.name);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Op other = (Op) obj;
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            return true;
        }
        
        
        
        
        
        
        
    }
    
    
}
