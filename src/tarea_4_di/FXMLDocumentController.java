package tarea_4_di;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.fxutils.viewer.JasperViewerFX;

public class FXMLDocumentController implements Initializable {

    @FXML
    private VBox root; // VBox que actúa como el contenedor raíz de la interfaz.
    private Scene scene; // Escena asociada a la interfaz.

    @FXML
    private void estilo() {
        // Limpia las hojas de estilo actuales y aplica la nueva hoja de estilo CSS.
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/Estilo/estilo.css").toExternalForm());
    }

    @FXML
    private VBox paneTop; // VBox correspondiente a la sección superior de la interfaz.

    @FXML
    private VBox paneFoot; // VBox correspondiente a la sección inferior de la interfaz.

    @FXML
    private void salirBt(ActionEvent event) {
        // Finaliza la aplicación cuando se presiona el botón asociado.
        Platform.exit();
    }

    @FXML
    private void matriculaBt(ActionEvent event) {
        // Obtiene los datos de todos los alumnos desde la base de datos.
        GestionAlumnos gestion = new GestionAlumnos();
        List<Alumnos> datos = gestion.datosInforme();

        // Filtra los alumnos que están inscritos en el módulo "DI".
        List<Alumnos> alumnosDI = new ArrayList<>();
        for (Alumnos alumno : datos) {
            if ("DI".equals(alumno.getSiglasDeModulo())) {
                alumnosDI.add(alumno);

                // Muestra los datos de los alumnos seleccionados en la consola.
                System.out.println("Informe de alumnos: ");
                System.out.println(
                        "DNI: " + alumno.getDni() + "\t"
                        + "Modulo: " + alumno.getSiglasDeModulo() + "\t"
                        + "Nota del modulo: " + alumno.getNotaModulo() + "\t"
                        + "Provincia: " + alumno.getProvincia());
            }
        }

        try {
            // Define la fuente de datos para el informe utilizando la lista de alumnos filtrada.
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(alumnosDI);

            // Obtiene el escenario actual a partir del evento.
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            // Crea y muestra el visor del informe Jasper.
            JasperViewerFX viewerfx = new JasperViewerFX(stage, "Informe de Alumnos", "/Informes/Informe_2_1.jasper", new HashMap<>(), beanColDataSource);
            viewerfx.show();

        } catch (Exception ex) {
            // Captura y muestra cualquier error ocurrido durante la generación del informe.
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}

