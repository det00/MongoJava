package model;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Alumno implements Serializable {
    private double rating;
    private int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    @BsonProperty("calificaation")
    private double calification;
    private String higherGrade;
    private boolean FCTs;
}
