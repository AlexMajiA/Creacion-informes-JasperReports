/**
 * Archivo: FXMLDocumentController.java
 * Objetivo: Controlar los eventos relacionados con la ventana principal de a la FXMLDocument.fxml
 * Equipo/persona: Alejandro Martínez Jiménez
 * 
 */
package tarea_4_di;

import javafx.scene.control.MenuItem;
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
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.fxutils.viewer.JasperViewerFX;

    /**
     * Controlador encargado de la gestión de la ventana principal
     * <p style ="font-size:18px; color: blue;"> Controlador encargado de la ventana principal </p>
     * @author Alejandro Martínez Jiménez
     * @version 1.0.0
     * @see tarea_4_di.Tarea_4_DI
     * @since 1.0.0
     */


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
    
    /**
     * VBox correspondiente a la sección superior de la interfaz.
     */
    @FXML private VBox paneTop; 
    
    /**
     * VBox correspondiente a la sección inferior de la interfaz.
     */
    @FXML private VBox paneFoot; 

    /**
     * Método para finalizar la ejecución de la aplicación.
     * 
     * <p>Este método se invoca cuando el usuario presiona el botón asociado al evento.</p>
     *
     * @param event Evento de acción asociado al botón que invoca este método.
     */
    @FXML
    private void salirBt(ActionEvent event) {
       Platform.exit();
    }

 /**
 * Maneja el evento para obtener y mostrar los alumnos matriculados en un módulo específico.
 * 
 * <p>Este método se activa mediante un evento asociado a un botón. Recupera la lista
 * completa de alumnos desde la base de datos, filtra los alumnos inscritos en el módulo
 * con las siglas "DI" y muestra la información filtrada en la consola.</p>
 * 
 * <p>Además, se genera un informe utilizando JasperReports con los datos filtrados.</p>
 * 
 * @param event Evento de acción que activa la obtención y filtrado de los datos de los alumnos.
 */

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
            JasperViewerFX viewerfx = new JasperViewerFX(stage, "Informe de Alumnos", "/Informes/Informe_2.jasper", new HashMap<>(), beanColDataSource);
            viewerfx.show();

        } catch (Exception ex) {
            // Captura y muestra cualquier error ocurrido durante la generación del informe.
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    /**
     * 
     */
    @FXML
    private MenuItem ayuda;
    
    /**
     * 
     * @param Event 
     */
    @FXML
    private void ayudaMb(ActionEvent Event){
        
    }

    /**
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ayuda.setAccelerator(KeyCombination.keyCombination("F1"));
        ayuda.setOnAction(this::ayudaMb); // Vincula el método ayudaMb al MenuItem.
    }
}

