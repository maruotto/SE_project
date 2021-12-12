/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
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
import se_project_g9.exceptions.CalculatorException;
import se_project_g9.exceptions.InputNumberException;

/**
 * FXML Controller class
 *
 * @author idamaruotto
 */
public class OperationSelectionController implements Initializable {

    private ObservableList<Map.Entry<String, UDOperation>> variables = null;
    private Operation ope;
    @FXML
    private TableView<Map.Entry<String, UDOperation>> tableView;
    @FXML
    private TableColumn<Map.Entry<String, UDOperation>, String> nameCln;
    @FXML
    private TableColumn<Map.Entry<String, UDOperation>, String> OperationsCln;

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
        try {
            ope.removeOperation(tableView.getSelectionModel().getSelectedItem().getKey());
        } catch (CalculatorException ex) {
            CustomPopup.errorPopup("An error has occurred while removing");
        }
        variables.remove(tableView.getSelectionModel().getFocusedIndex());

    }

    /**
     * set the data underlying this GUI
     *
     * @param ope the Operation that will be shown in the popup
     */
    public void setVariables(Operation ope) {

        this.variables = FXCollections.observableArrayList(ope.getOperations().entrySet());
        this.ope = ope;

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
    private void modifyCommitName(TableColumn.CellEditEvent<Map.Entry<String, String>, String> event) {
        try {
            ope.modifyOperationName(event.getOldValue(), event.getNewValue());
        } catch (CalculatorException ex) {
            CustomPopup.errorPopup(ex.getMessage());

        } catch (Exception ex) {
            CustomPopup.errorPopup("It's not possible to modify");
        } finally {
            this.variables = FXCollections.observableArrayList(ope.getOperations().entrySet());
            tableView.setItems(variables);
            tableView.refresh();
        }

    }

    @FXML
    private void modifyCommitOperation(TableColumn.CellEditEvent<Map.Entry<String, String>, String> event) {
        try {
            ope.modifyOperation(event.getRowValue().getKey(), event.getNewValue().toString());
        } catch (CalculatorException ex) {
            CustomPopup.errorPopup(ex.getMessage());
        } catch (Exception ex) {
            CustomPopup.errorPopup("It's not possible to modify");
        } finally {
            this.variables = FXCollections.observableArrayList(ope.getOperations().entrySet());
            tableView.setItems(variables);
            tableView.refresh();
        }
    }
    

}
