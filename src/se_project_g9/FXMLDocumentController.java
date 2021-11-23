/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se_project_g9;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author group9
 */
public class FXMLDocumentController implements Initializable {
    
    private Operation ope;

    @FXML
    private TextField tfInput;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ope = new Operation();
    }    

    @FXML
    private void handleInsertAction(ActionEvent event) {
        
        Number num = translate_input(tfInput. getText());
    }
    
    private Number translate_input(String input){
        //ATTENTION!!!! if you want to add to the regular expression something like
        // the + sign or other things, use the operator |
        // example: if you want to add to this expression +, this will become " *?+"
        String[] splittedInput = input.split("\\+");  //regex meaning: *? stays for zero or more times
        //for (String string : input.split(",")
        
        double realPart = 0, imaginaryPart = 0, number = 0;
        boolean imaginaryPartNotDone = true, realPartNotDone = true;
        
        for (String s: splittedInput) {
            if(!imaginaryPartNotDone & !realPartNotDone)
                break;
            
            if(s.length() != 0){
                if(imaginaryPartNotDone & ((s.endsWith("i") | s.endsWith("j")))){
                    try {
                        System.out.println(s.substring(0, s.length()));
                        imaginaryPart = Double.parseDouble(s.substring(0, s.length()-1)); 
                        
                        imaginaryPartNotDone = false;
                    }
                    catch(NumberFormatException | NullPointerException e){
                        System.out.println(e);
                    }
                    
                }
                if (realPartNotDone){
                    try {
                        realPart = Double.parseDouble(s);  
                        realPartNotDone = false;
                    }
                    catch(NumberFormatException | NullPointerException e){
                        System.out.println(e);
                        
                    }

                }
            }
            
            
        }

        System.out.println(realPart + " + " + imaginaryPart);
        return new Number(realPart, imaginaryPart);
    }
    
}

    

    

