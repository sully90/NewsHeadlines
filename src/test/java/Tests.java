import crawler.BBCSpider;
import models.Headline;
import org.bson.types.ObjectId;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {

    public Headline CreateHeadline() {
        Headline headline = new Headline("https://bbc.co.uk", "This is a test headline.");
        return headline;
    }

    public void tearDown(ObjectId id) {
        Headline.finder().findOne(id).writer().delete();
    }

    @Test
    public void testWriteHeadline() {
        long count = Headline.finder().count();

        System.out.println(count);

        Headline headline = CreateHeadline();
        headline.writer().save();

        long newCount = Headline.finder().count();
        System.out.println(newCount);
        assertTrue (newCount == count + 1);

        tearDown(headline.getObjectId());
        newCount = Headline.finder().count();
        assertEquals(newCount, count);
        System.out.println(count);
    }

    @Test
    public void testFindHeadline() {
        Headline headline = CreateHeadline();

        headline.writer().save();
        ObjectId id = headline.getObjectId();

        // Now search for it
        headline = Headline.finder().findOne(id);
        assertTrue(headline.getObjectId().equals(id));

        tearDown(id);
    }

}
