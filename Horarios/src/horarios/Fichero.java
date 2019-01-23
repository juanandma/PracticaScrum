/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import horarios.Horarios;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAVIER TUR GARCÍA
 */
public class Fichero {

    private static int id_asig;

    public Fichero() {
        this.id_asig = 0;
    }

    /**
     *
     * @param rutaFichero ruta del fichero de asignaturas que queremos leer
     * @return lista de asignaturas
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<Asignatura> leerFichero(String rutaFichero) throws FileNotFoundException, IOException {
        String cadena, nombre;
        int curso, cuatrimestre, numHorariosTeoria, numHorariosPractica;
        int diaSemana1, diaSemana2;
        LocalTime hora_ini1, hora_fin1, hora_ini2, hora_fin2;

        List<Asignatura> asignaturas = new ArrayList<>(); //lista asignaturas
        List<Hora> lista_hora_teoria;
        List<Hora> lista_hora_practicas;
        Hora h;
        Asignatura a;
        try {
            FileReader f = new FileReader(rutaFichero);
            BufferedReader b = new BufferedReader(f);
            cadena = b.readLine(); //primera línea del fichero: curso
            String[] aux, aux2;
            aux = cadena.split(" ");
            curso = Integer.parseInt(aux[1]); //curso

            cadena = b.readLine(); //segunda línea del fichero: cuatrimestre
            aux2 = cadena.split(" ");
            cuatrimestre = Integer.parseInt(aux2[1]);

            while ((cadena = b.readLine()) != null) { //mientras existan líneas en el fichero, continúo
                a = new Asignatura();
                lista_hora_teoria = new ArrayList<>();
                lista_hora_practicas = new ArrayList<>();
                a.setCurso(curso);
                a.setCuatrimestre(cuatrimestre);
                if (cadena.startsWith("nombre")) {
                    aux = cadena.split(" ");
                    nombre = aux[1];
                    a.setNombre(nombre);
                    cadena = b.readLine(); //leemos horarios teoria
                    aux = cadena.split(" ");
                    numHorariosTeoria = Integer.parseInt(aux[1]);

                    // hacer a.setndias o a.setngrupos
                    for (int i = 0; i < numHorariosTeoria; i++) {
                        h = new Hora();
                        cadena = b.readLine();
                        aux = cadena.split(" ");
                        diaSemana1 = Integer.parseInt(aux[0]);
                        hora_ini1 = LocalTime.parse(aux[1]);
                        hora_fin1 = LocalTime.parse(aux[2]);

                        h.setDia(diaSemana1);
                        h.setHInicio(hora_ini1);
                        h.setHFin(hora_fin1);
                        
                        lista_hora_teoria.add(h);

                        if (aux.length == 6) //horario teoría partido en dos dias
                        {
                            h = new Hora();
                            diaSemana2 = Integer.parseInt(aux[3]);
                            hora_ini2 = LocalTime.parse(aux[4]);
                            hora_fin2 = LocalTime.parse(aux[5]);

                            h.setDia(diaSemana2);
                            h.setHInicio(hora_ini2);
                            h.setHFin(hora_fin2);
                            
                            lista_hora_teoria.add(h);
                        }
                        
                    }
                    a.setHorarioTeoria(lista_hora_teoria);
                    a.setNgrupos(numHorariosTeoria);

                    cadena = b.readLine(); //leemos horarios prácticas
                    aux = cadena.split(" ");
                    numHorariosPractica = Integer.parseInt(aux[1]);
                    for (int i = 0; i < numHorariosPractica; i++) {
                        h = new Hora();
                        cadena = b.readLine();
                        aux = cadena.split(" ");
                        diaSemana1 = Integer.parseInt(aux[0]);
                        hora_ini1 = LocalTime.parse(aux[1]);
                        hora_fin1 = LocalTime.parse(aux[2]);

                        h.setDia(diaSemana1);
                        h.setHInicio(hora_ini1);
                        h.setHFin(hora_fin1);
                        if (aux.length == 6) //horario teoría partido en dos dias
                        {
                            diaSemana2 = Integer.parseInt(aux[3]);
                            hora_ini2 = LocalTime.parse(aux[4]);
                            hora_fin2 = LocalTime.parse(aux[5]);

                            h.setDia2(diaSemana2);
                            h.setHInicio2(hora_ini2);
                            h.setHFin2(hora_fin2);
                        }
                        lista_hora_practicas.add(h);
                    }
                    a.setHorarioPractica(lista_hora_practicas);
                    id_asig++;
                    a.setID(id_asig);
                }
                asignaturas.add(a); //añadimos asignatura a la lista
            }
        } catch (IOException ex) {
            System.out.println("ERROR: fichero con formato desconocido.");
        }
        return asignaturas;
    }

//    public static void main(String[] args) throws IOException {
//        List<Asignatura> asigs1 = new ArrayList<>();
//        List<Asignatura> asigs2 = new ArrayList<>();
//        List<Asignatura> asigs3 = new ArrayList<>();
//        asigs1 = leerFichero("horario4.txt");
//        asigs2 = leerFichero("horario2.txt");
//        asigs3 = leerFichero("horario1.txt");
//        for (int i = 0; i < asigs2.size(); i++) {
//            asigs1.add(asigs2.get(i));
//        }
//        for (int i = 0; i < asigs3.size(); i++) {
//            asigs1.add(asigs3.get(i));
//        }
//        Horarios h1 = new Horarios();
//        h1.VerAsignaturas(asigs1);
//    }

}
