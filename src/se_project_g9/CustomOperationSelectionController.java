/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author idamaruotto
 */
public class CustomOperationSelectionController implements Initializable {

    private String name = null;
    private String sequence = null;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfSequence;
    @FXML
    private Button btnOk;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfName.selectHome();
        btnOk.disableProperty().bind(Bindings.isEmpty(tfName.textProperty()).or(Bindings.isEmpty(tfSequence.textProperty())));
    }    

    @FXML
    private void releasedName(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {
            tfSequence.selectHome();
        }
    }

    @FXML
    private void releasedSequence(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {
            name = tfName.getText();
            sequence = tfSequence.getText();
            close();
        }
        
    }

    @FXML
    private void cancelClick(ActionEvent event) {
        close();
    }

    @FXML
    private void okClick(ActionEvent event) {
        name = tfName.getText();
        sequence = tfSequence.getText();
        close();
    }

    /**
     *
     * @return the name of operation inserted 
     */
    protected String getName() {
        return name;
    }

    /**
     *
     * @return the sequence of operations inserted
     */
    protected String getSequence() {
        return sequence;
    }
    
    private void close(){
        Stage stage = (Stage) tfName.getScene().getWindow();
        stage.close();
    }
    
}