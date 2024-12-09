package tarea_4_di;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private VBox root; //VBox, la raíz de la interfaz
    private Scene scene;

    @FXML
    private void estilo() {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/Estilo/estilo.css").toExternalForm());
    }

    @FXML
    private VBox paneTop;

    @FXML
    private VBox paneFoot;

    @FXML
    private void salirBt(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void matriculaBt(ActionEvent event) {
        // Implementar acción
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
