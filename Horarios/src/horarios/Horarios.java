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
     * @param h1
     * @param h2
     * @param args the command line arguments
     * @return 
     */
    
    
    public boolean coincidenHoras(Hora h1, Hora h2) {

        boolean coincide = false;
        
        LocalTime inicio1=h1.getHInicio();
        LocalTime fin2=h2.getHFin();

        
        if(inicio1.isBefore(fin2) && !inicio1.equals(fin2)){
            
           coincide=true;
            
        }

        return coincide;
    }
    
    public boolean coincidenAsignaturasTeoria(Asignatura a1, Asignatura a2){
        
        boolean coincide=false;
        int i,j;
        i=j=0;
        int n1, n2;
        
        if(a1.getCuatrimestre()==a2.getCuatrimestre()){
            
            
            List<Hora> clases_1=a1.getHorarioTeoria();
            List<Hora> clases_2=a2.getHorarioTeoria();
            
            n1=clases_1.size();
            n2=clases_2.size();
            
            while(i<n1 && !coincide){
                while(j<n2 && !coincide){
                    
                    int dia1=clases_1.get(i).getDia();
                    int dia2=clases_2.get(j).getDia();
                    
                    if(dia1==dia2){
                        
                        coincide=coincidenHoras(clases_1.get(i), clases_1.get(j));
                    }
                    
                    j++;
                }
                i++;
            }
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