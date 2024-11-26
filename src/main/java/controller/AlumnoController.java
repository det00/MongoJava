package controller;

import dao.AlumnoDao;
import model.Alumno;
import utils.Utils;

import java.util.Scanner;

public class AlumnoController {
    AlumnoDao alumnoDao = new AlumnoDao();
    Scanner scanner = new Scanner(System.in);
    Utils utils = new Utils();

    public void insertarAlumno() {
        Alumno a = new Alumno();
        System.out.println("Nombre: ");
        a.setName(scanner.nextLine());
        System.out.println("Edad: ");
        a.setAge((int) utils.validarNumero());
        System.out.println("Género: ");
        a.setGender(scanner.nextLine());
        System.out.println("Email: ");
        a.setEmail(scanner.nextLine());
        System.out.println("Telefono: ");
        a.setPhone(scanner.nextLine());
        System.out.println("Curso: ");
        a.setHigherGrade(scanner.nextLine());
        System.out.println("Puntuacion: ");
        a.setCalification(utils.validarNumero());
        System.out.println("Rating: ");
        a.setRating(utils.validarNumero());
        alumnoDao.insertarAlumno(a);
    }

    public void listarAlumnos() {
        System.out.println("-----------------ALUMNOS-----------------");
        if (!alumnoDao.getAlumnos().isEmpty()) {
            for (Alumno a : alumnoDao.getAlumnos()) {
                System.out.println(a);
            }
        } else {
            System.out.println("No hay alumnos");
        }
        System.out.println("-----------------------------------------");
    }

    public void buscarPorEmail() {
        System.out.println("Email a buscar: ");
        String email = scanner.nextLine();
        if (alumnoDao.findAlumnoByMail(email)==null){
            System.out.println("No hay alumno con el correo " + email);
        } else {
            System.out.println(alumnoDao.findAlumnoByMail(email));
        }
    }

    public void bajaPorNota() {
        System.out.println("Mayor nota de: ");
        double nota = utils.validarNumero();
        if (!alumnoDao.findAlumnoByCalification(nota).isEmpty()){
            alumnoDao.deleteAlumnosCalification("rating", nota);
        } else {
            System.out.println("No hay alumnos con la nota superior a " + nota);
        }
    }
}
