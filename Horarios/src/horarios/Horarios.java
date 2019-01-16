/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.time.LocalTime;
import java.util.Date;

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


}
