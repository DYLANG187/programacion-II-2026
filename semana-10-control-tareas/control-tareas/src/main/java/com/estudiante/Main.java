package com.estudiante;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Tarea> tareas = new ArrayList<>();

        Tarea tarea1 = new Tarea(
                1L,
                "Comprar alimentos",
                "Comprar productos para la semana",
                "ALTA",
                false
        );

        Tarea tarea2 = new Tarea(
                2L,
                "Realizar ejercicios",
                "Completar los ejercicios de programación",
                "MEDIA",
                true
        );

        Tarea tarea3 = new Tarea(
                3L,
                "Estudiar Programación II",
                "Repasar los temas para el examen",
                "ALTA",
                false
        );

        tareas.add(tarea1);
        tareas.add(tarea2);
        tareas.add(tarea3);

        int pendientes = 0;
        int completadas = 0;

        System.out.println("===== LISTADO DE TAREAS =====");
        System.out.println();

        for (Tarea tarea : tareas) {
            tarea.mostrarInformacion();

            if (tarea.isCompletada()) {
                completadas++;
            } else {
                pendientes++;
            }
        }

        System.out.println();
        System.out.println("Tareas pendientes: " + pendientes);
        System.out.println("Tareas completadas: " + completadas);
    }
}