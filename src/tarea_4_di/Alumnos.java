
package tarea_4_di;

/**
 *
 * @author amjpa
 */
public class Alumnos {
    
    //Declaro las variables.
    private String dni;
    private String siglasDeModulo;
    private double notaModulo;
    private String provincia;
    
    //Constructores
    public Alumnos() {
    }

    public Alumnos(String dni, String siglasDeModulo, double notaModulo, String provincia) {
        this.dni = dni;
        this.siglasDeModulo = siglasDeModulo;
        this.notaModulo = notaModulo;
        this.provincia = provincia;
    }

    
    //Setter y Getter.
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSiglasDeModulo() {
        return siglasDeModulo;
    }

    public void setSiglasDeModulo(String siglasDeModulo) {
        this.siglasDeModulo = siglasDeModulo;
    }

    public double getNotaModulo() {
        return notaModulo;
    }

    public void setNotaModulo(double notaModulo) {
        this.notaModulo = notaModulo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
}
