/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.time.LocalTime;

/**
 *
 * @author JUANM
 */
public class Hora {
    
    private int Dia; //DIAS DE LA SEMANA (1=LUNES,...,5=VIERNES)
    private LocalTime HInicio;
    private LocalTime HFin;
    
    //Para aquellas asignaturas que tengan horario partido en dos días:
    private int Dia2=-1; 
    private LocalTime HInicio2=null;
    private LocalTime HFin2=null;

    /*
    public Hora(int Dia) {
        this.Dia = Dia;
    }
    */
    

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getDia2() {
        return Dia2;
    }

    public void setDia2(int Dia2) {
        this.Dia2 = Dia2;
    }

    public LocalTime getHInicio() {
        return HInicio;
    }

    public void setHInicio(LocalTime HInicio) {
        this.HInicio = HInicio;
    }

    public LocalTime getHFin() {
        return HFin;
    }

    public void setHFin(LocalTime HFin) {
        this.HFin = HFin;
    }

    public LocalTime getHInicio2() {
        return HInicio2;
    }

    public LocalTime getHFin2() {
        return HFin2;
    }

    public void setHInicio2(LocalTime HInicio2) {
        this.HInicio2 = HInicio2;
    }

    public void setHFin2(LocalTime HFin2) {
        this.HFin2 = HFin2;
    }
    
}
