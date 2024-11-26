package controller;

import dao.ProfesorDao;
import model.Profesor;
import utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfesorController {
    ProfesorDao profesorDao = new ProfesorDao();
    Scanner scanner = new Scanner(System.in);
    Utils utils = new Utils();

    public void insertarProfesor() {
        Profesor p = new Profesor();
        System.out.println("Nombre: ");
        p.setName(scanner.nextLine());
        System.out.println("Edad: ");
        p.setAge((int) utils.validarNumero());
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
        p.setRating(utils.validarNumero());
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
        System.out.println("--------------------------------------------");
    }

    public void buscarRangoEdad() {
        try {
            System.out.println("Mayor que: ");
            int gt = (int) utils.validarNumero();
            System.out.println("Menor que: ");
            int lt = (int) utils.validarNumero();
            if (!profesorDao.findProfesorByAge(gt, lt).isEmpty()) {
                for (Profesor p : profesorDao.findProfesorByAge(gt, lt)) {
                    System.out.println(p);
                }
            } else {
                System.out.println("No hay profesores entre " + gt + " y " + lt + " años");
            }
        } catch (NumberFormatException e) {
            System.out.println("Introduce numeros");
        }
    }

    public void editarCalificacion() {
        System.out.println("Email a buscar: ");
        String email = scanner.nextLine();
        if (profesorDao.findProfesorByEmail(email)!=null){
            System.out.println("Nueva calificación");
            double calification = utils.validarNumero();
            profesorDao.updateProfesorByMail(email, calification);
            System.out.println(profesorDao.findProfesorByEmail(email));
        }
        else {
            System.out.println("No se ha encontrado ningun profesor con el correo " + email);
        }
    }
}

