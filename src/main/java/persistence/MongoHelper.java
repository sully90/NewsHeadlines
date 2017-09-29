package persistence;

import com.mongodb.DB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.jongo.Jongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persistence.util.DatabaseConnection;
import persistence.util.DatabaseType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MongoHelper {

    private static final Logger logger = LoggerFactory.getLogger(MongoHelper.class);

    private static Map<DatabaseType, DatabaseConnection> connectionMap;

    static {
        connectionMap = new ConcurrentHashMap<DatabaseType, DatabaseConnection>();

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        for (DatabaseType databaseType : DatabaseType.values()) {
            DB db = mongoClient.getDB(databaseType.getLabel());

            Jongo jongo = new Jongo(db);

            DatabaseConnection databaseConnection = new DatabaseConnection(jongo);

            connectionMap.put(DatabaseType.LOCAL, databaseConnection);
        }
    }

    public static DatabaseConnection getDatabase(DatabaseType databaseType) {
        return connectionMap.get(databaseType);
    }

}