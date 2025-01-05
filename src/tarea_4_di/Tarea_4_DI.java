package tarea_4_di;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Tarea_4_DI extends Application {
    
    /**
     * Método que inicia la ventana principal de la palicación
     * 
     * @param stage Es la ventana principal creado por la aplicación en si y paso como argumento 
     * el método start() de la aplicación
     * @throws Exception El método start() puede lanzar una exepción del tipo Exception si no
     * se crea la ventana correctamente.
     */

    @Override
    public void start(Stage stage) throws Exception {
        // Carga el archivo FXML que define la interfaz de usuario.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tarea_4_di/FXMLDocument.fxml"));
        VBox root = loader.load();
        
        // Crea la escena utilizando el layout cargado desde el archivo FXML.
        Scene scene = new Scene(root);
        
        // Imprime en la consola la ruta del archivo CSS que se utilizará para los estilos.
        System.out.println("ruta: " + getClass().getResource("/Estilo/estilo.css"));
        
        // Añade la hoja de estilos CSS a la escena.
        scene.getStylesheets().add(getClass().getResource("/Estilo/estilo.css").toExternalForm());
        
        // Establece la escena en el escenario principal, define un título y muestra la ventana.
        stage.setScene(scene);
        stage.setTitle("Informes 1.0");
        stage.show();
    }

    /**
     * El método main es la entrada a toda la aplicación de Java 
     * @param args Argumentos pasados por la línea de comandos.
     */
    
    public static void main(String[] args) {
        // Método principal que lanza la aplicación JavaFX.
        launch(args);
    }
}

