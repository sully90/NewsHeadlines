import crawler.BBCSpider;
import models.Headline;
import org.bson.types.ObjectId;
import org.junit.Test;

public class Tests {

    @Test
    public void testWriteHeadline() {
        Headline headline = new Headline("https://bbc.co.uk", "This is a test headline.");
        headline.writer().save();
    }

    @Test
    public void testFindHeadline() {
        ObjectId id = new ObjectId("59cec915fc8360196766ebfb");
        Headline headline = Headline.finder().find(id);
        System.out.println(headline.getHeadline());
    }

}
