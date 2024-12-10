package tarea_4_di;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
        //Obtengo todos los alumnos de la base de datos.
        GestionAlumnos gestion = new GestionAlumnos();
        List <Alumnos> datos = gestion.datosInforme();
        
        //Muestro primero los datos por consola.
        System.out.println("Infome de alumnos: ");
        
        for(Alumnos alumno : datos  ){
            System.out.println(
                "DNI: " + alumno.getDni() + "\t"+
                "Modulo: " + alumno.getSiglasDeModulo() +"\t"+
                "Nota del modulo: " + alumno.getNotaModulo() +"\t"+
                "Provincia: " + alumno.getProvincia());
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //ObservableList
    }    
}
