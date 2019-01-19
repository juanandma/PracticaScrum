/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.util.Date;
import java.util.List;

/**
 *
 * @author JUANM
 */
public class Asignatura {
    
    private String Nombre;
    private int ID;
    private int ngrupos;
    private int ndias;
    private List<Hora> horario;

    public Asignatura(String Nombre, int ID, int ngrupos, int ndias, List<Hora> horario) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.ngrupos = ngrupos;
        this.ndias = ndias;
        this.horario = horario;
    }

    Asignatura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    public String getNombre() {
        return Nombre;
    }

    public int getID() {
        return ID;
    }

    public int getNgrupos() {
        return ngrupos;
    }

    public int getNdias() {
        return ndias;
    }

    public List<Hora> getHorario() {
        return horario;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNgrupos(int ngrupos) {
        this.ngrupos = ngrupos;
    }

    public void setNdias(int ndias) {
        this.ndias = ndias;
    }

    public void setHorario(List<Hora> horario) {
        this.horario = horario;
    }
    
    
    
}
