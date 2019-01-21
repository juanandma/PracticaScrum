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
    private List<Hora> horarioTeoria;
    private List<Hora> horarioPractica;
    private int cuatrimestre;

    public Asignatura(String Nombre, int ID, int ngrupos, int ndias, int cuatrimestre, List<Hora> horarioTeoria, List<Hora> horarioPractica ) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.ngrupos = ngrupos;
        this.ndias = ndias;
        this.cuatrimestre = cuatrimestre;
        this.horarioTeoria = horarioTeoria;
        this.horarioPractica = horarioPractica;
    }
 public Asignatura(String Nombre, int ID, int ngrupos, int ndias, int cuatrimestre) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.ngrupos = ngrupos;
        this.ndias = ndias;
        this.cuatrimestre = cuatrimestre;
    }
    
    
    Asignatura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNgrupos() {
        return ngrupos;
    }

    public void setNgrupos(int ngrupos) {
        this.ngrupos = ngrupos;
    }

    public int getNdias() {
        return ndias;
    }

    public void setNdias(int ndias) {
        this.ndias = ndias;
    }

    public List<Hora> getHorarioTeoria() {
        return horarioTeoria;
    }

    public void setHorarioTeoria(List<Hora> horarioTeoria) {
        this.horarioTeoria = horarioTeoria;
    }

    public List<Hora> getHorarioPractica() {
        return horarioPractica;
    }

    public void setHorarioPractica(List<Hora> horarioPractica) {
        this.horarioPractica = horarioPractica;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    

}
