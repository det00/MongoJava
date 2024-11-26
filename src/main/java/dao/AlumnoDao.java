package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import database.DBConnection;
import model.Alumno;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class AlumnoDao {
    MongoCollection<Alumno> alumnosCollection = DBConnection.getDbConnection().getAlumnoCollection();
    Bson filtro;

    public void insertarAlumno(Alumno alumno){
        alumnosCollection.insertOne(alumno);
    }

    public List<Alumno> getAlumnos(){
        List<Alumno> listaAlumnos = new ArrayList<>();
        try (MongoCursor<Alumno> mongoCursor = alumnosCollection.find(Alumno.class).cursor()) {
            while (mongoCursor.hasNext()) {
                listaAlumnos.add(mongoCursor.next());
            }
        }
        return listaAlumnos;
    }

    public Alumno findAlumnoByMail(String mail){
        filtro = Filters.eq("email", mail);
        return alumnosCollection.find(filtro).first();
    }

    public List<Alumno> findAlumnoByCalification(double gt){
        List<Alumno> listaAlumnos = new ArrayList<>();
        filtro = Filters.gt("rating", gt);
        for (Alumno a:alumnosCollection.find(filtro)){
            listaAlumnos.add(a);
        }
        return listaAlumnos;
    }

    public void deleteAlumnosCalification(String criterio, double valor){
        filtro = Filters.gte(criterio, valor);
        alumnosCollection.deleteMany(filtro);
    }
}
