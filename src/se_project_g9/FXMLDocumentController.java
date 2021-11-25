/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.ListBinding;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author group9
 */
public class FXMLDocumentController implements Initializable {
    
    private Operation ope;
    private ObservableList stack;

    @FXML
    private TextField tfInput;
    @FXML
    private ListView<Number> stackview;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ope = new Operation();
        stack = FXCollections.observableList(ope.getNumberStack());
        stackview.setItems(stack);
                
    }    

    @FXML
    private void handleInsertAction(ActionEvent event) {
        
        Number num = Operation.translate_input(tfInput.getText());
        tfInput.clear();
        ope.pushStack(num);
        
    }

    @FXML
    private void click1(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "1");
    }

    @FXML
    private void click5(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "5");
    }

    @FXML
    private void click2(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "2");
    }

    @FXML
    private void click3(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "3");
    }

    @FXML
    private void click4(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "4");
    }

    @FXML
    private void click9(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "9");
    }

    @FXML
    private void click8(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "8");
    }

    @FXML
    private void click7(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "7");
    }

    @FXML
    private void click6(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "6");
    }

    @FXML
    private void click0(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "0");
    }

    @FXML
    private void plusclick(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "+");      
    }

    @FXML
    private void clicki(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "j");      
    }

    @FXML
    private void multiplyclick(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "*");
    }

    @FXML
    private void minusclick(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "-");
    }

    @FXML
    private void divideclick(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "/");
    }

    @FXML
    private void clicksqrt(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "sqrt");
    }

    @FXML
    private void clickplusminus(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "invert");
    }

    @FXML
    private void clickclear(ActionEvent event) {
        tfInput.clear();
    }

    @FXML
    private void clickdrop(ActionEvent event) {
        tfInput.clear();
    }
    
}

    

    

