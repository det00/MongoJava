package controller;

import dao.AlumnoDao;
import model.Alumno;

import java.util.Scanner;

public class AlumnoController {
    AlumnoDao alumnoDao = new AlumnoDao();
    Scanner scanner = new Scanner(System.in);

    public void insertarAlumno() {
        Alumno a = new Alumno();
        System.out.println("Nombre: ");
        a.setName(scanner.nextLine());
        System.out.println("Edad: ");
        a.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Género: ");
        a.setGender(scanner.nextLine());
        System.out.println("Email: ");
        a.setEmail(scanner.nextLine());
        System.out.println("Telefono: ");
        a.setPhone(scanner.nextLine());
        System.out.println("Curso: ");
        a.setHigherGrade(scanner.nextLine());
        System.out.println("Puntuacion: ");
        a.setCalification(Double.parseDouble(scanner.nextLine()));
        System.out.println("Rating: ");
        a.setRating(Double.parseDouble(scanner.nextLine()));
        alumnoDao.insertarAlumno(a);
    }

    public void listarAlumnos() {
        System.out.println("-----------------ALUMNOS-----------------");
        if (!alumnoDao.getAlumnos().isEmpty()) {
            for (Alumno a : alumnoDao.getAlumnos()) {
                System.out.println(a);
            }
        }else {
            System.out.println("No hay alumnos");
        }
    }

    public void buscarPorEmail() {
        System.out.println("Email a buscar: ");
        System.out.println(alumnoDao.findAlumnoByMail(scanner.nextLine()));
    }

    public void bajaPorNota() {
        System.out.println("Dar de baja alumnos");
        alumnoDao.deleteAlumnosByRating(Double.parseDouble(scanner.nextLine()));
    }
}
