package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import database.DBConnection;
import model.Profesor;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class ProfesorDao {
    MongoCollection<Profesor> profesoresCollection = DBConnection.getDbConnection().getProfesoresCollection();
    Bson filtro;
    Document update;

    public void insertProfesor(Profesor profesor) {
        profesoresCollection.insertOne(profesor);
    }

    public List<Profesor> findProfesorByAge(int gt, int lt) {
        List<Profesor> listaProfesores = new ArrayList<>();
        Bson filtro = Filters.and(
                Filters.lt("age", lt),
                Filters.gt("age", gt));
        for (Profesor p: profesoresCollection.find(filtro)){
            listaProfesores.add(p);
        }
        return listaProfesores;
    }

    public List<Profesor> getProfesores() {
        List<Profesor> listaProfesores = new ArrayList<>();
        try (MongoCursor<Profesor> cursor = profesoresCollection.find(Profesor.class).cursor()) {
            while (cursor.hasNext()) {
                listaProfesores.add(cursor.next());
            }
        }
        return listaProfesores;
    }

    public void updateProfesorByMail(String mail, double rating){
        filtro = Filters.eq("email", mail);
        update = new Document("$set",new Document("rating", rating));
        profesoresCollection.updateOne(filtro,update);
    }
}
