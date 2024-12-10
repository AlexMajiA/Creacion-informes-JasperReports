package tarea_4_di;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
        List <Alumnos> datos = gestion.datosInforme();
        
        for(Alumnos alumno : datos  ){
            
             // Crear una lista para almacenar solo los alumnos de "DI".
             List<Alumnos> alumnosDI = new ArrayList<>();
            
            if("DI".equals(alumno.getSiglasDeModulo())){
                alumnosDI.add(alumno);
                 //Muestro primero los datos por consola.
                System.out.println("Infome de alumnos: ");
                System.out.println(
                "DNI: " + alumno.getDni() + "\t"+
                "Modulo: " + alumno.getSiglasDeModulo() +"\t"+
                "Nota del modulo: " + alumno.getNotaModulo() +"\t"+
                "Provincia: " + alumno.getProvincia());
            }
        }
        try{
             //Defino la colección de datos sobre la que se crea el informe.
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(datos);
        
        Node source = (Node) event.getSource();
        
        Stage stage = (Stage) source.getScene().getWindow();
        
         JasperViewerFX viewerfx = new JasperViewerFX(
            stage,
            "Informe de Alumnos",
            "/informes/tablaAlumnos.jasper",
            new HashMap<>(),
            beanColDataSource
        );
        
        viewerfx = new JasperViewerFX (stage, "Informe","/informes/tablaAlumnos.jasper", new HashMap(), beanColDataSource);
        
        viewerfx.show();
        
        }catch (Exception ex){
            System.out.println("Error." + ex.getMessage());
        }
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //ObservableList
    }    
}
