package tarea_4_di;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Tarea_4_DI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tarea_4_di/FXMLDocument.fxml"));
        VBox root = loader.load();
        
        Scene scene = new Scene(root);
        System.out.println("ruta: " + getClass().getResource("/Estilo/estilo.css"));
        scene.getStylesheets().add(getClass().getResource("/Estilo/estilo.css").toExternalForm());
        
        stage.setScene(scene);
        stage.setTitle("Informes 1.0");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
