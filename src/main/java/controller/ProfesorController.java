package controller;

import dao.ProfesorDao;
import model.Profesor;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfesorController {
    ProfesorDao profesorDao = new ProfesorDao();
    Scanner scanner = new Scanner(System.in);

    public void insertarProfesor() {
        Profesor p = new Profesor();
        System.out.println("Nombre: ");
        p.setName(scanner.nextLine());
        System.out.println("Edad: ");
        p.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Género: ");
        p.setGender(scanner.nextLine());
        System.out.println("Email: ");
        p.setEmail(scanner.nextLine());
        System.out.println("Telefono: ");
        p.setPhone(scanner.nextLine());
        System.out.println("Titulo: ");
        p.setTitle(scanner.nextLine());
        System.out.println("Asignaturas: ");
        ArrayList<String> listaAsignaturas = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String asignatura = scanner.nextLine();
            if (asignatura.isEmpty()) {
                break;
            }
            listaAsignaturas.add(asignatura);
        }
        p.setSubjects(listaAsignaturas);
        System.out.println("Puntuacion: ");
        p.setRating(Double.parseDouble(scanner.nextLine()));
        profesorDao.insertProfesor(p);
    }

    public void listarProfesores() {
        System.out.println("-----------------PROFESORES-----------------");
        if (!profesorDao.getProfesores().isEmpty()) {
            for (Profesor p : profesorDao.getProfesores()) {
                System.out.println(p);
            }
        } else {
            System.out.println("No hay profesores");
        }
    }

    public void buscarRangoEdad() {
        System.out.println("Mayor que: ");
        int gt = Integer.parseInt(scanner.nextLine());
        System.out.println("Menor que: ");
        int lt = Integer.parseInt(scanner.nextLine());
        for (Profesor p : profesorDao.findProfesorByAge(gt, lt)) {
            System.out.println(p);
        }
    }

    public void editarCalificacion() {
        System.out.println("Email a buscar: ");
        String email = scanner.nextLine();
        System.out.println("Nueva calificación");
        double calification = Double.parseDouble(scanner.nextLine());
        profesorDao.updateProfesorByMail(email, calification);
    }
}

