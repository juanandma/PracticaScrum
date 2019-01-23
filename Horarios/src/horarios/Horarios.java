/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.time.LocalTime;
import java.util.List;
import horarios.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
    private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();

    //Las busquedas son todas exhaustivas (malo)
    private boolean coincidenHoras(Hora h1, Hora h2) {

        boolean coincide = false;

        LocalTime inicio1 = h1.getHInicio();
        LocalTime fin1 = h1.getHFin();

        LocalTime inicio2 = h2.getHInicio();
        LocalTime fin2 = h2.getHFin();

        if (inicio1.isBefore(fin2) && fin1.isAfter(inicio2) && !inicio1.equals(fin2)) {

            coincide = true;

        }

        return coincide;
    }

    private boolean coincidenAsignaturasTeoria(Asignatura a1, Asignatura a2) {

        boolean coincide = false;
        int i, j;
        i = j = 0;
        int n1, n2;

        if (a1.getCuatrimestre() == a2.getCuatrimestre()) {

            List<Hora> clases_1 = a1.getHorarioTeoria();
            List<Hora> clases_2 = a2.getHorarioTeoria();

            n1 = clases_1.size();
            n2 = clases_2.size();

            while (i < n1 && !coincide) {
                while (j < n2 && !coincide) {

                    int dia1 = clases_1.get(i).getDia();
                    int dia2 = clases_2.get(j).getDia();

                    if (dia1 == dia2) {

                        coincide = coincidenHoras(clases_1.get(i), clases_2.get(j));
                    }

                    j++;
                }
                i++;
            }

            if (coincide) {
                System.out.println("Coinciden: " + a1.getNombre() + " y " + a2.getNombre());
            }
        }

        return coincide;
    }

    public boolean coincideHorarioTeoria(List<Asignatura> asignaturas) {

        boolean coincide = false;

        int i, j;
        i = j = 0;

        int n = asignaturas.size();

        while (i < n && !coincide) {
            while (j < n && !coincide) {

                if (i != j) {
                    coincide = coincidenAsignaturasTeoria(asignaturas.get(i), asignaturas.get(j));
                }

                j++;
            }
            i++;
        }

        return coincide;
    }

    private boolean coincidenAsignaturasPracticas(Asignatura a1, Asignatura a2) {

        boolean coincide = true;
        int i, j;
        i = j = 0;
        int n1, n2;

        if (a1.getCuatrimestre() == a2.getCuatrimestre()) {

            List<Hora> practicas_1 = a1.getHorarioPractica();
            List<Hora> practicas_2 = a2.getHorarioPractica();

            n1 = practicas_1.size();
            n2 = practicas_2.size();

            if (n1 == 0 || n2 == 0) {
                coincide = false;
            }

            while (i < n1 && coincide) {
                while (j < n2 && coincide) {

                    int dia1 = practicas_1.get(i).getDia();
                    int dia2 = practicas_2.get(j).getDia();

                    if (dia1 == dia2) {
                        coincide = coincidenHoras(practicas_1.get(i), practicas_2.get(j));
                    } else {
                        coincide = false;
                    }

                    j++;
                }
                i++;
            }

            if (coincide) {
                System.out.println("Coinciden: " + a1.getNombre() + " y " + a2.getNombre());
            }

        } else {
            coincide = false;
        }

        return coincide;
    }

    public boolean coincideHorarioPracticas(List<Asignatura> asignaturas) {

        boolean coincide = false;

        int i, j;
        i = j = 0;

        int n = asignaturas.size();

        while (i < n && !coincide) {
            while (j < n && !coincide) {

                if (i != j) {
                    coincide = coincidenAsignaturasPracticas(asignaturas.get(i), asignaturas.get(j));
                }

                j++;
            }
            i++;
        }

        return coincide;
    }

    public void VerAsignaturas(List<Asignatura> asignaturas) {
        for (int i = 0; i < asignaturas.size(); i++) {
            System.out.println("Asignatura " + asignaturas.get(i).getNombre() + " con id " + asignaturas.get(i).getID() + " con "
                    + asignaturas.get(i).getNgrupos() + " grupos, "/*se imparte el dia " + asignaturas.get(i).getNdias() */ + " con "
                    + asignaturas.get(i).getNgrupos() + " grupos");

        }

    }

    public void InsertarAsignatura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la asignatura: ");
        String nom = sc.next();
        System.out.println("Introduzca el ID de la asignatura: ");
        int id = sc.nextInt();
        System.out.println("Introduzca el numero de grupos de la asignatura: ");
        int ng = sc.nextInt();
        System.out.println("Introduzca el numero de dias que se impaarte la asignatura: ");
        int nd = sc.nextInt();
        System.out.println("Introduzca el cuatrimestre de la asignatura: ");
        int c = sc.nextInt();
        System.out.println("Introduzca el curso de la asignatura: ");
        int cu = sc.nextInt();

        List<Hora> horarioTeoria = null; // FALTAN POR PEDIR LAS HORAS !!!!!!!!!!!!!!!!!!!!!!
        List<Hora> horarioPractica = null;

        Asignatura a = new Asignatura(nom, id, ng, c, cu, horarioTeoria, horarioPractica);
        asignaturas.add(a);

    }

    public void BorrarAsignatura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la asignatura a eliminar: ");
        String nom = sc.next();
        System.out.println("Introduzca el ID de la asignatura a eliminar: ");
        int id = sc.nextInt();

        for (int i = 0; i <= asignaturas.size(); i++) {
            if ((asignaturas.get(i).getNombre().equals(nom)) && (asignaturas.get(i).getID() == id)) {
                asignaturas.remove(i);
            }

        }

    }

    public void ModificarAsignatura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el ID de la asignatura a modificar: ");
        int id = sc.nextInt();

        List<Hora> horarioteo = new ArrayList<Hora>();

        for (int i = 0; i <= asignaturas.size(); i++) {
            if (asignaturas.get(i).getID() == id) {
                System.out.println("Introduzca el nuevo nombre de la asignatura: curso y horario ");
                String nom = sc.next();
                System.out.println("Introduzca el curso en el que se impartira la asignatura: ");
                int c = sc.nextInt();

                System.out.println("Introduzca horario en el que comienza la teoria: ");
                String h = sc.next();
                Hora ho = new Hora();
                ho.setHInicio(LocalTime.parse(h));
                System.out.println("Introduzca horario en el que finaliza la teoria: ");
                String h2 = sc.next();
                ho.setHFin(LocalTime.parse(h2));
                horarioteo.add(ho);

                asignaturas.get(i).setNombre(nom);
                asignaturas.get(i).setCurso(c);
                asignaturas.get(i).setHorarioTeoria(horarioteo);

            }

        }

    }

}
