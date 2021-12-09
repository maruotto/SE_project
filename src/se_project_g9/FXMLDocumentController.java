/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se_project_g9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

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
    @FXML
    private AnchorPane AnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ope = new Operation();
        btnSend.disableProperty().bind(Bindings.isEmpty(tfInput.textProperty()));
        stackview.setItems(ope.getNumberStack());
        Platform.runLater(() -> {
            tfInput.requestFocus();
        });

        AnchorPane.setOnMouseMoved((MouseEvent event) -> {
            tfInput.requestFocus();
            tfInput.selectEnd();
        });

        undoBtn.disableProperty().set(true);

    }

    @FXML
    private void handleInsertAction(ActionEvent event) {
        enterInput();

    }

    @FXML
    private void click(ActionEvent event) {
        Button b = (Button) event.getSource();
        tfInput.setText(tfInput.getText() + b.getText());
        tfInput.requestFocus();
        tfInput.selectEnd();
    }

    @FXML
    private void clickplusminus(ActionEvent event) {
        try {
            ope.invert();
        } catch (Exception ex) {
            String message = "";
            if (ex.getMessage() == null) {
                message = "An error has occurred";
            } else {
                message = ex.getMessage();
            }

            CustomPopup.errorPopup(message);
        }
    }

    @FXML
    private void clickclear(ActionEvent event) {
        try {
            ope.clear();
        } catch (Exception ex) {
            String message = "";
            if (ex.getMessage() == null) {
                message = "An error has occurred";
            } else {
                message = ex.getMessage();
            }

            CustomPopup.errorPopup(message);
        }
    }

    @FXML
    private void clickdrop(ActionEvent event) {
        try {
            ope.drop();
        } catch (Exception ex) {
            String message = "";
            if (ex.getMessage() == null) {
                message = "An error has occurred";
            } else {
                message = ex.getMessage();
            }

            CustomPopup.errorPopup(message);
        }

    }

    @FXML
    private void clickover(ActionEvent event) {
        try {
            ope.over();
        } catch (Exception ex) {
            String message = "";
            if (ex.getMessage() == null) {
                message = "An error has occurred";
            } else {
                message = ex.getMessage();
            }

            CustomPopup.errorPopup(message);
        }

    }

    @FXML
    private void clickswap(ActionEvent event) {
        try {
            ope.swap();
        } catch (Exception ex) {
            String message = "";
            if (ex.getMessage() == null) {
                message = "An error has occurred";
            } else {
                message = ex.getMessage();
            }

            CustomPopup.errorPopup(message);
        }

    }

    @FXML
    private void clickdup(ActionEvent event) {
        try {
            ope.dup();
        } catch (Exception ex) {
            String message = "";
            if (ex.getMessage() == null) {
                message = "An error has occurred";
            } else {
                message = ex.getMessage();
            }

            CustomPopup.errorPopup(message);
        }

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
    private void clickv(ActionEvent event) {
        //variablesMenù.setText("v");
        MenuItem btn = (MenuItem) event.getSource();
        variablesMenù.setText(btn.getText());
    }

    @FXML
    private void undoclick(ActionEvent event) {
        undo();
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
        } catch (EmptyStackException e) {
            CustomPopup.errorPopup("Operation not allowed!");
        } catch (Exception e) {
            CustomPopup.errorPopup("Operation not allowed");
        } finally {
            tfInput.clear();
        }

    }

    @FXML
    private void clickCustom(ActionEvent event) {
        try {
            CustomPopup.customDefinition();
            undoBtn.disableProperty().set(false);
        } catch (InputNumberException e) {
            CustomPopup.errorPopup(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickRemoveOperation(ActionEvent event) {
        CustomPopup.operationView();
        undoBtn.disableProperty().set(false);
    }

    @FXML
    private void clicksavevariables(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "save");
    }

    @FXML
    private void clickrestorevariables(ActionEvent event) {
        tfInput.setText(tfInput.getText() + "restore");
    }

    @FXML
    private void saveoperations(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        File file = chooser.showSaveDialog(null);
        if (file != null) {
            FileOperations.writeIn(file, ope.getOperations());
        }

    }

    @FXML
    private void getoperations(ActionEvent event) throws FileNotFoundException {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            FileOperations.loadFrom(file, ope); //l'oggetto ObservableListWrapper non è serializabile
        }
    }

    private void undo() {
        try {
            ope.undo();
        } catch (ImpossibleUndo ex) {
            CustomPopup.errorPopup(ex.getMessage());
        }
        if (ope.getOperationsPerfomed().empty()) {
            undoBtn.disableProperty().set(true);
        }
    }

    @FXML
    private void controlZ(KeyEvent event) {
        KeyCodeCombination comb = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);
        if (comb.match(event)) {
            undo();
        }
    }
}
