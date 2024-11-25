package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import database.DBConnection;
import model.Profesor;

public class ProfesorDao {
    DBConnection collection = DBConnection.getDbConnection();

    public ProfesorDao() {
        collection.getProfesoresCollection();
    }

    public void getProfesores(){
        FindIterable<Profesor> iterable = collection.getProfesoresCollection().find(Profesor.class);
        try (MongoCursor<Profesor> cursor = iterable.cursor()) {
            while (cursor.hasNext()) {
                Profesor p = cursor.next();
                p.mostrarDatos();
            }
        }
    }
}