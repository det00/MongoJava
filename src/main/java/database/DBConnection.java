package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Alumno;
import model.Profesor;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class DBConnection {
    private static DBConnection connection;
    private final MongoDatabase database;

    private DBConnection() {
        CodecProvider codecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClients.create().getCodecRegistry(),
                CodecRegistries.fromProviders(codecProvider)
        );
        String connectionString = "mongodb+srv://%s:%s@cluster0.opb0l.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        MongoClient mongoClient = MongoClients.create(String.format(connectionString, DBScheme.DB_USERNAME, DBScheme.DB_PASS));
        database = mongoClient.getDatabase("centro_estudios").withCodecRegistry(codecRegistry);
    }

    public static DBConnection getDbConnection(){
        if (connection == null){
            connection = new DBConnection();
        }
        return connection;
    }

    public MongoCollection<Alumno> getAlumnoCollection() {
        return database.getCollection("alumnos", Alumno.class);
    }

    public MongoCollection<Profesor> getProfesoresCollection() {
        return database.getCollection("profesores", Profesor.class);
    }
}
