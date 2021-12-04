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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        
        System.out.println("get" + this.variables);
        nameCln.setCellValueFactory(new PropertyValueFactory<Op, String>("name"));
        OperationsCln.setCellValueFactory(new PropertyValueFactory<Op, String>("udOp"));
        //OperationsCln.setCellFactory((TextFieldTableCell.forTableColumn()));
        tableView.setItems(variables);
        
        tableView.setEditable(true);
        nameCln.setEditable(true);
        OperationsCln.setEditable(true);
    }    

    @FXML
    private void removeClick(ActionEvent event) {
        
    }

    public void setVariables(HashMap<String, UDOperation> variables) {
        for(String s: variables.keySet()){
            this.variables.add(new Op(s, variables.get(s)));
        }
        System.out.println("set" + this.variables);
    }

    @FXML
    private void modifyCommitName(TableColumn.CellEditEvent<Op, String> event) {
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
