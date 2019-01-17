/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.util.Date;
import java.time.LocalTime;

/**
 *
 * @author JUANM
 */
public class Hora {
    
    private int Dia; //DIAS DE LA SEMANA (1=LUNES,...,5=VIERNES)
    private LocalTime HInicio;
    private LocalTime HFin;

    public Hora(int Dia) {
        this.Dia = Dia;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
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

    

    
    
}
