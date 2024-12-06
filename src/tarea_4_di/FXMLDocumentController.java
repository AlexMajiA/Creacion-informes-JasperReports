/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_4_di;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author amjpa
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private AnchorPane root; // La raíz de la interfaz
    private Scene scene;

    
    @FXML
    private void estilo () {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/Estilo/estilo.css").toExternalForm());
    }
    
    @FXML
    private Pane paneTop;

    @FXML
    private Pane paneFoot;


    @FXML
    private void salirBt (ActionEvent event){
        Platform.exit();
    }
    
      @FXML
    private void matriculaBt (ActionEvent event){
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
