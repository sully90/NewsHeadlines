import crawler.BBCSpider;
import org.jongo.MongoCollection;
import persistence.MongoHelper;
import persistence.util.CollectionNames;
import persistence.util.DatabaseConnection;
import persistence.util.DatabaseType;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        BBCSpider spider = new BBCSpider();
//        try {
//            List<String> headlines = spider.getHeadlines();
//
//            for (String headline : headlines) {
//                System.out.println(headline);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        DatabaseConnection connection = MongoHelper.getDatabase(DatabaseType.LOCAL);

        MongoCollection collection = connection.getCollection(CollectionNames.TEST);

        System.out.println(collection.count());

    }
}
