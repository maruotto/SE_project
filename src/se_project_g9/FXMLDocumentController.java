/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author group9
 */
public class FXMLDocumentController implements Initializable {
    
    private Operation ope;

    @FXML
    private TextField tfInput;
    @FXML
    private ListView<Number> stackview;
    @FXML
    private Button btnSend;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ope = new Operation();              
        btnSend.disableProperty().bind(Bindings.isEmpty(tfInput.textProperty()));
        stackview.setItems(ope.getNumberStack());
        
                
    }    

    @FXML
    private void handleInsertAction(ActionEvent event) {      
             enterInput();
        
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
        tfInput.setText(tfInput.getText() + "i");  
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
        tfInput.setText(tfInput.getText() + "clear");
    }

    @FXML
    private void clickdrop(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "drop");
        
    }
    
    @FXML
    private void clickover(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "over");
        
    }
    
    @FXML
    private void clickswap(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "swap");
        
    }
    
    @FXML
    private void clickdup(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "dup");
        
    }

    @FXML
    private void clickpoint(ActionEvent event) {
        tfInput.setText(tfInput.getText() + ".");
    }

    @FXML
    private void keyReleased(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode())
            enterInput();
    }
    
    private void enterInput(){
        try{
            ope.translateInput(tfInput.getText());
        }
        catch(Exception e){
            System.out.println("message from exception in send button action catch:" + e); //may be shown also in a window
        }
            
        tfInput.clear();     
        if (ope.getNumberStack().size() > 11)
            stackview.scrollTo(ope.getNumberStack().size()-1); 
    }

    @FXML
    private void savevariableclick(ActionEvent event) {
    }
    
}

    

    

