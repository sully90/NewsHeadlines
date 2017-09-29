import crawler.BBCSpider;
import models.Headline;
import org.jongo.MongoCollection;
import persistence.MongoHelper;
import persistence.util.CollectionNames;
import persistence.util.DatabaseConnection;
import persistence.util.DatabaseType;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create an instance of our BBC headline crawler
        BBCSpider spider = new BBCSpider();
        try {
            // Get the list of headlines
            List<String> headlines = spider.getHeadlines();

            Headline headlineObject;

            // Save to our MongoDB
            for (String headline : headlines) {
                headlineObject = new Headline(spider.getBaseUrl(), headline);
                // Save to our MongoDB
                headlineObject.writer().save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
