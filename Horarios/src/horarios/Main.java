/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 * GITHUB CARGAR PROYECTO: TEAM -> REMOTE -> CLONE HACER COMMIT: BOTÓN DERECHO
 * EN EL PROYECTO -> GIT -> COMMIT... (MUY IMPORTANTE DECIR EN COMENTARIOS LO
 * QUE HE HECHO) HACER PULL PARA ACTUALIZAR REPOSITORIO: BOTÓN DERECHO EN EL
 * PROYECTO -> GIT -> REMOTE -> PULL or PUSH VER CAMBIOS RESPECTO A LA ÚLTIMA
 * VERSIÓN DEL REPOSITORIO: BOTÓN DERECHO EN EL PROYECTO -> GIT -> DIFF -> Diff
 * to head
 */
/**
 *
 * @author JUANM
 */
public class Main {

    /*public static void main(String[] args) {
        // TODO code application logic here
        
        Hora h1= new Hora();
        Hora h2= new Hora();
        h1.setDia(1);
        h2.setDia(1);
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
        
        // Prueba VerAsignaturas
        List<Asignatura> asignaturas = new ArrayList<Asignatura>();
        List<Hora> ho1= new ArrayList<Hora>();
        ho1.add(h1);
        ho1.add(h2);
        Asignatura a1 = new Asignatura("Matematicas", 1, 3, 1);
        Asignatura a2 = new Asignatura("Economia", 2, 4, 1);
        asignaturas.add(a1);
        asignaturas.add(a2);
        Horarios horario = new Horarios();
        horario.VerAsignaturas(asignaturas);
        ///////////////////////////////////////////////////////////////////
        
        
        
        
        if(hor.coincidenHoras(h1,h2)){
            System.out.println("coinciden");
        }else System.out.println("no");
    }*/
    public static void main(String[] args) {

        Fichero fich = new Fichero();
        List<Asignatura> asignaturas = new ArrayList<>();
        Horarios horario = new Horarios();
        Scanner input = new Scanner(System.in);

        List<Asignatura> mis_clases = new ArrayList<>();

        int id;

        try {

            asignaturas = fich.leerFichero("horario4.txt");
            asignaturas.addAll(fich.leerFichero("horario2.txt"));
            asignaturas.addAll(fich.leerFichero("horario1.txt"));

            horario.VerAsignaturas(asignaturas);

            do {
                System.out.println("        *** " + '"' + "0" + '"' + " para terminar");
                System.out.println("Introduce el ID de la asignatura que quiere en su Horario: ");
                id = input.nextInt();

                if (id != 0) {
                    mis_clases.add(asignaturas.get(id - 1));
                }

            } while (id != 0);

            horario.VerAsignaturas(mis_clases);
            if (horario.coincideHorarioTeoria(mis_clases)) {
                System.out.println("Coincide su horario de teoría");

            } else {

                if (horario.coincideHorarioPracticas(mis_clases)) {
                    System.out.println("Coincide su horario de práticas");

                } else {
                    System.out.println("No coincide ninguna asignatura");

                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
