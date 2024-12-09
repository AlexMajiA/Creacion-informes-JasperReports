/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_4_di;

import java.util.ArrayList;

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
    
    
    
    public void guardar(){
        
        ArrayList <Alumnos> BD = new ArrayList<>();    
        BD.add(this);
        
    }
    
    
    
}
