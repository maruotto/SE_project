/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se_project_g9;

import java.io.IOException;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;
import se_project_g9.exceptions.ImpossibleUndo;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author group9
 */
public class FXMLDocumentController implements Initializable {

    public static Operation ope;

    @FXML
    private TextField tfInput;
    @FXML
    private ListView<ComplexNumber> stackview;
    @FXML
    private Button btnSend;
    @FXML
    private SplitMenuButton variablesMenù;
    @FXML
    private Button undoBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ope = new Operation();
        btnSend.disableProperty().bind(Bindings.isEmpty(tfInput.textProperty()));
        stackview.setItems(ope.getNumberStack());
        tfInput.selectAll();
        
        undoBtn.disableProperty().set(true);

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
        try {
            ope.clear();
        } catch (Exception ex) {
            String message = "";
            if(ex.getMessage() == null)
                message = "An error has occurred";
            else message = ex.getMessage();
                
            CustomPopup.errorPopup(message);
        }
    }

    @FXML
    private void clickdrop(ActionEvent event) {
        try {
            ope.drop();
        } catch (Exception ex) {
            String message = "";
            if(ex.getMessage() == null)
                message = "An error has occurred";
            else message = ex.getMessage();
                
            CustomPopup.errorPopup(message);
        }

    }

    @FXML
    private void clickover(ActionEvent event) {
        try {
            ope.over();
        } catch (Exception ex) {
            String message = "";
            if(ex.getMessage() == null)
                message = "An error has occurred";
            else message = ex.getMessage();
                
            CustomPopup.errorPopup(message);
        }

    }

    @FXML
    private void clickswap(ActionEvent event) {
        try {
            ope.swap();
        } catch (Exception ex) {
            String message = "";
            if(ex.getMessage() == null)
                message = "An error has occurred";
            else message = ex.getMessage();
                
            CustomPopup.errorPopup(message);
        }

    }

    @FXML
    private void clickdup(ActionEvent event) {
        try {
            ope.dup();
        } catch (Exception ex) {
            String message = "";
            if(ex.getMessage() == null)
                message = "An error has occurred";
            else message = ex.getMessage();
                
            CustomPopup.errorPopup(message);
        }

    }

    @FXML
    private void clickpoint(ActionEvent event) {
        tfInput.setText(tfInput.getText() + ".");
    }

    @FXML
    private void keyReleased(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {
            enterInput();
        }
    }

    

    @FXML
    private void savevariableclick(ActionEvent event) throws Exception {
        ope.addToVariable(Character.valueOf(variablesMenù.getText().charAt(0)));
        undoBtn.disableProperty().set(false);      
    }
    
    @FXML
    private void addvariableclick(ActionEvent event) throws Exception {
        ope.addToValue(Character.valueOf(variablesMenù.getText().charAt(0)));
        undoBtn.disableProperty().set(false);      
    }

    @FXML
    private void subvariableclick(ActionEvent event) throws Exception {
        ope.subToValue(Character.valueOf(variablesMenù.getText().charAt(0)));  
        undoBtn.disableProperty().set(false);      
    }
    
    @FXML
    private void pushvariableclick(ActionEvent event) throws Exception {
        ope.pushValueOf(Character.valueOf(variablesMenù.getText().charAt(0)));
        undoBtn.disableProperty().set(false);
    }

    @FXML
    private void clickb(ActionEvent event) {
        variablesMenù.setText("b");
    }

    @FXML
    private void clickc(ActionEvent event) {
        variablesMenù.setText("c");
    }

    @FXML
    private void clickd(ActionEvent event) {
        variablesMenù.setText("d");
    }

    @FXML
    private void clicke(ActionEvent event) {
        variablesMenù.setText("e");
    }

    @FXML
    private void clickf(ActionEvent event) {
        variablesMenù.setText("f");
    }

    @FXML
    private void clickg(ActionEvent event) {
        variablesMenù.setText("g");
    }

    @FXML
    private void clickh(ActionEvent event) {
        variablesMenù.setText("h");
    }

    @FXML
    private void clickj(ActionEvent event) {
        variablesMenù.setText("j");
    }

    @FXML
    private void clickk(ActionEvent event) {
        variablesMenù.setText("k");
    }

    @FXML
    private void clickl(ActionEvent event) {
        variablesMenù.setText("l");
    }

    @FXML
    private void clickm(ActionEvent event) {
        variablesMenù.setText("m");
    }

    @FXML
    private void clickn(ActionEvent event) {
        variablesMenù.setText("n");
    }

    @FXML
    private void clicko(ActionEvent event) {
        variablesMenù.setText("o");
    }

    @FXML
    private void clickp(ActionEvent event) {
        variablesMenù.setText("p");
    }

    @FXML
    private void clickq(ActionEvent event) {
        variablesMenù.setText("q");
    }

    @FXML
    private void clickr(ActionEvent event) {
        variablesMenù.setText("r");
    }

    @FXML
    private void clicks(ActionEvent event) {
        variablesMenù.setText("s");
    }

    @FXML
    private void clickt(ActionEvent event) {
        variablesMenù.setText("t");
    }

    @FXML
    private void clicku(ActionEvent event) {
        variablesMenù.setText("u");
    }

    @FXML
    private void clickv(ActionEvent event) {
        variablesMenù.setText("v");
    }

    @FXML
    private void clickw(ActionEvent event) {
        variablesMenù.setText("w");
    }

    @FXML
    private void clickx(ActionEvent event) {
        variablesMenù.setText("x");
    }

    @FXML
    private void clicky(ActionEvent event) {
        variablesMenù.setText("y");
    }

    @FXML
    private void clickz(ActionEvent event) {
        variablesMenù.setText("z");
    }

    @FXML
    private void clicka(ActionEvent event) {
        variablesMenù.setText("a");
    }

    @FXML
    private void clickiv(ActionEvent event) {
        variablesMenù.setText("i");
    }

    @FXML
    private void undoclick(ActionEvent event) {
        try {
            ope.undo();
        } catch (ImpossibleUndo ex) {
            CustomPopup.errorPopup(ex.getMessage());
        }      
        if(ope.getOperationsPerfomed().empty()){
            undoBtn.disableProperty().set(true);
        }
    }
    
    private void enterInput() {
        try {
            ope.performOperation(tfInput.getText());
            if (ope.getNumberStack().size() > 11) {
                stackview.scrollTo(ope.getNumberStack().size() - 1);
            }
            undoBtn.disableProperty().set(false);
        } catch (InputNumberException | NumberFormatException ex) {
            CustomPopup.errorPopup(ex.getMessage());
        } catch (EmptyStackException e){
            CustomPopup.errorPopup("Operation not allowed!");
        } catch (Exception e){
            CustomPopup.errorPopup("Operation not allowed");
        }finally {
            tfInput.clear();
        }

    }

    @FXML
    private void clickCustom(ActionEvent event) {
        try {
            CustomPopup.customDefinition();
        }  catch (InputNumberException e){
            CustomPopup.errorPopup(e.getMessage());
        }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
    }

    @FXML
    private void clickRemoveOperation(ActionEvent event) {
        CustomPopup.operationView();
        undoBtn.disableProperty().set(false);      
    }

}

