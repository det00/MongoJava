package model;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Profesor {
    private double rating;
    private int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private ArrayList<String> subjects;
    private String title;
}




