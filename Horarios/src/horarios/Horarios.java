/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import horarios.*;

/**
 *
 * @author JUANM
 */
public class Horarios {


    /**
     * @param args the command line arguments
     */
    
    
    public boolean coinciden(Hora h1, Hora h2) {

        boolean coincide = false;
        
        LocalTime inicio1=h1.getHInicio();
        LocalTime fin1=h1.getHFin();
        
        LocalTime inicio2=h2.getHInicio();
        LocalTime fin2=h2.getHFin();
        

        
        if(inicio1.isBefore(fin2) && !inicio1.equals(fin2)){
            
           coincide=true;
            
        }

        return coincide;
    }

    
    public void VerAsignaturas(List<Asignatura> asignaturas)
    {
        for (int i = 0; i < asignaturas.size(); i++) {
            System.out.println("Asignatura " + asignaturas.get(i).getNombre() + " con id " + asignaturas.get(i).getID() + " con " 
                    + asignaturas.get(i).getNgrupos() + " grupos, se imparte el dia " + asignaturas.get(i).getNdias() + " con " 
                    + asignaturas.get(i).getNgrupos() + " grupos");
     
        }
        
    }

}