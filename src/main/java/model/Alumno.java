package model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Alumno implements Serializable {
    private double rating;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private double calification;
    private String higherGrade;
}