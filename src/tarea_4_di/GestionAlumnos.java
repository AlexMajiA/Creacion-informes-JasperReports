package tarea_4_di;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amjpa
 */
public class GestionAlumnos {

    Alumnos alumno = new Alumnos();
    
    //Array que simula basde de datos no relacional.
    public static ArrayList<Alumnos> crearAlumno() {
        ArrayList<Alumnos> BD = new ArrayList<>();

        BD.add(new Alumnos("75139418M", "DI", 8.5, "GRANADA"));
        BD.add(new Alumnos("15221662S", "DI", 6.2, "MALAGA"));
        BD.add(new Alumnos("68713555F", "DI", 5.8, "JAÉN"));
        BD.add(new Alumnos("41668219W", "DI", 6.9, "CÓRODOBA"));
        BD.add(new Alumnos("72345565S", "DI", 8.3, "CÁDIZ"));
        BD.add(new Alumnos("35799524Y", "DI", 9.1, "ALMERIA"));
        BD.add(new Alumnos("87765691J", "DI", 7.4, "CÁDIZ"));
        BD.add(new Alumnos("16584863P", "DI", 8.5, "JAÉN"));
        BD.add(new Alumnos("78998215E", "DI", 9.5, "CÓRODOBA"));
        BD.add(new Alumnos("13511211G", "DI", 3.4, "MALAGA"));

        BD.add(new Alumnos("49635410Y", "PMDM", 5.1, "ALMERIA"));
        BD.add(new Alumnos("16864421K", "PMDM", 9.0, "HUELVA"));
        BD.add(new Alumnos("16565145W", "PMDM", 6.3, "GRANADA"));
        BD.add(new Alumnos("13354843L", "PMDM", 6.5, "MALAGA"));
        BD.add(new Alumnos("13540213A", "PMDM", 7.5, "JAÉN"));
        BD.add(new Alumnos("11654521L", "PMDM", 5.5, "CÓRODOBA"));

        BD.add(new Alumnos("77899451K", "AD", 7.4, "CÁDIZ"));
        BD.add(new Alumnos("35444321B", "AD", 8.5, "CÓRODOBA"));
        BD.add(new Alumnos("91352153A", "AD", 6.9, "MALAGA"));
        BD.add(new Alumnos("75321621M", "AD", 8.4, "JAÉN"));
        BD.add(new Alumnos("35448776P", "AD", 9.6, "GRANADA"));

        BD.add(new Alumnos("13225215F", "PSP", 7.4, "JAÉN"));
        BD.add(new Alumnos("48981535D", "PSP", 6.1, "MALAGA"));
        BD.add(new Alumnos("35627815H", "PSP", 6.6, "GRANADA"));

        return BD;
    }
    
    public List <Alumnos> datosInforme(){
        return crearAlumno();
    }
    
}
