package controller;

import java.util.Scanner;

public class MenuController {
    AlumnoController alumnoController = new AlumnoController();
    ProfesorController profesorController = new ProfesorController();

    public void mostrarMenu() {
        System.out.println("""
                
                1-Insertar profesor
                2-Insertar alumno
                3-Mostrar todos los datos
                4-Mostrar todos los profesores
                5-Mostrar todos los alumnos
                6-Buscar alumno por email
                7-Buscar profesor por rango de edad
                8-Actualizar calificacion de profesor por email
                9-Borrar alumnos con calificacion superior a 5
                10-Salir
                """);
    }

    public boolean ejecutarOpciones(boolean salir, Scanner scanner) {
        int opcion = Integer.parseInt(scanner.nextLine());
        switch (opcion) {
            case 1 -> profesorController.insertarProfesor();

            case 2 -> alumnoController.insertarAlumno();

            case 3 -> {
                profesorController.listarProfesores();
                alumnoController.listarAlumnos();
            }
            case 4 -> profesorController.listarProfesores();

            case 5 -> alumnoController.listarAlumnos();

            case 6 -> alumnoController.buscarPorEmail();

            case 7 -> profesorController.buscarRangoEdad();

            case 8 -> profesorController.editarCalificacion();

            case 9 -> alumnoController.bajaPorNota();

            case 10 -> salir = true;

        }
        return salir;
    }
}
