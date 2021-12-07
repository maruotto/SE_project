/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static se_project_g9.FXMLDocumentController.ope;
import se_project_g9.commands.Command;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author idamaruotto
 */
public class CustomPopup {
    
    protected static boolean errorPopup(String message) {
        FXMLLoader loader = new FXMLLoader(FXMLDocumentController.class.getResource("Popup.fxml"));
        Parent parent;
        try {
            parent = loader.load();
            PopupController pc = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setAlwaysOnTop(true);
            pc.setLabels(message); 
            stage.showAndWait();                  
        } catch (IOException ex) {
            return false;
            
        }
        return true;
    }
    
    @FXML
    static void customDefinition() throws InputNumberException, IOException {
        
        FXMLLoader loader = new FXMLLoader(FXMLDocumentController.class.getResource("customOperationSelection.fxml"));
        Parent parent;
        parent = loader.load();
        CustomOperationSelectionController pc = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setAlwaysOnTop(true);
        stage.showAndWait();

        String name = pc.getName();
        String sequence = pc.getSequence();

        if(name != null && sequence != null){
            ope.addUDOperation(name, sequence);
        }
        
        
        
    }

    @FXML
    static void operationView() {
        FXMLLoader loader = new FXMLLoader(FXMLDocumentController.class.getResource("OperationSelection.fxml"));
        Parent parent;
        try {
            parent = loader.load();
            OperationSelectionController pc = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setAlwaysOnTop(true);
            pc.setVariables(ope);
            stage.showAndWait();
            //stage.show();
            
        }  catch (InputNumberException e){
            CustomPopup.errorPopup(e.getMessage());
        }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
