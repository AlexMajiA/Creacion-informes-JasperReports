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
        List<Alumnos> datos = gestion.datosInforme();

        // Crear una lista para almacenar solo los alumnos de "DI".
        List<Alumnos> alumnosDI = new ArrayList<>();

        for (Alumnos alumno : datos) {
            if ("DI".equals(alumno.getSiglasDeModulo())) {
                alumnosDI.add(alumno);
                //Muestro primero los datos por consola.
                System.out.println("Infome de alumnos: ");
                System.out.println(
                        "DNI: " + alumno.getDni() + "\t"
                        + "Modulo: " + alumno.getSiglasDeModulo() + "\t"
                        + "Nota del modulo: " + alumno.getNotaModulo() + "\t"
                        + "Provincia: " + alumno.getProvincia());
            }
        }
              try{
             //Defino la colección de datos sobre la que se crea el informe.
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(alumnosDI);
        
        Node source = (Node) event.getSource();
        
        Stage stage = (Stage) source.getScene().getWindow();
        
       JasperViewerFX viewerfx = new JasperViewerFX(stage,"Informe de Alumnos","/Informes/Informe_2_1.jasper",new HashMap<>(),beanColDataSource);
        
        viewerfx.show();
        
        }catch (Exception ex){
            System.out.println("Error." + ex.getMessage());
        }
         
/*
        try {
            System.out.println("Verificando alumnosDI...");
            if (alumnosDI == null) {
                throw new NullPointerException("La lista 'alumnosDI' es null.");
            }

            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(alumnosDI);

            System.out.println("Verificando evento...");
            if (event == null) {
                throw new NullPointerException("El objeto 'event' es null.");
            }

            Node source = (Node) event.getSource();
            System.out.println("Verificando nodo fuente...");
            if (source == null) {
                throw new NullPointerException("El nodo 'source' es null.");
            }

            Stage stage = (Stage) source.getScene().getWindow();
            System.out.println("Verificando stage...");
            if (stage == null) {
                throw new NullPointerException("El 'stage' es null.");
            }

            
            
            System.out.println("Verificando JasperViewerFX...");
            JasperViewerFX viewerfx = new JasperViewerFX(stage, "Informe de Alumnos", "/Informes/Informe_2.jasper", new HashMap<>(), beanColDataSource);

            viewerfx.show();
            
            String reportPath = getClass().getResource("/informes/Informe_2.jasper").toString();
            System.out.println("Ruta del informe: " + reportPath);
            
        } catch (NullPointerException ex) {
            System.out.println("Error de valor null: " + ex.getMessage());
            ex.printStackTrace(); // Imprime la traza completa del error
        } catch (Exception ex) {
            System.out.println("Error general: " + ex.getMessage());
            ex.printStackTrace();
        }
     */   
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
}
