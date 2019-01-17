/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 * GITHUB
 * CARGAR PROYECTO: TEAM -> REMOTE -> CLONE 
 * HACER COMMIT: BOTÓN DERECHO EN EL PROYECTO -> GIT -> COMMIT... (MUY IMPORTANTE DECIR EN COMENTARIOS LO QUE HE HECHO)
 * HACER PULL PARA ACTUALIZAR REPOSITORIO: BOTÓN DERECHO EN EL PROYECTO -> GIT -> REMOTE -> PULL
 * VER CAMBIOS RESPECTO A LA ÚLTIMA VERSIÓN DEL REPOSITORIO: BOTÓN DERECHO EN EL PROYECTO -> GIT -> DIFF -> Diff to head
 */

/**
 *
 * @author JUANM
 */
public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Hora h1= new Hora(1);
        Hora h2= new Hora(1);
        Horarios hor= new Horarios();
        //prueba
        
        LocalTime inicio1 = LocalTime.of(10, 0);
        
        LocalTime fin1 = LocalTime.of(11, 0);

        
        LocalTime inicio2 = LocalTime.of(9, 0);

        
        LocalTime fin2 = LocalTime.of(9, 30);

        
        
        h1.setHInicio(inicio1);
        h1.setHFin(fin1);
        
        h2.setHInicio(inicio2);
        h2.setHFin(fin2);
        
        
        if(hor.coinciden(h1,h2)){
            System.out.println("coinciden");
        }else System.out.println("no");
    }
}
