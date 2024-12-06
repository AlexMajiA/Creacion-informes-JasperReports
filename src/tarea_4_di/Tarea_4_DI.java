/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_4_di;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author amjpa
 */
public class Tarea_4_DI extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tarea_4_di/FXMLDocument.fxml"));
        AnchorPane root = loader.load();
        
        Scene scene = new Scene(root);
        System.out.println("ruta: " + getClass().getResource("/Estilo/estilo.css"));
        scene.getStylesheets().add(getClass().getResource("/Estilo/estilo.css").toExternalForm());
                                                      

        
        stage.setScene(scene);
        stage.setTitle("Informes 1.0");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
