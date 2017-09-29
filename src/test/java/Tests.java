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
        /*
        Test object creation and deletion
         */

        // First, count how many entries exist in the database
        long count = Headline.finder().count();

        // Print to console
        System.out.println(count);

        // Create a dummy entry and save it
        Headline headline = CreateHeadline();
        headline.writer().save();

        // Once again, count total number of entries
        long newCount = Headline.finder().count();
        System.out.println(newCount);

        // Assert that the count has increased by 1
        assertTrue (newCount == count + 1);

        // Tear down the test (delete the dummy entry)
        tearDown(headline.getObjectId());
        newCount = Headline.finder().count();

        // Assert we're back to the original number of entries
        assertEquals(newCount, count);
        System.out.println(count);
    }

    @Test
    public void testFindHeadline() {
        /*
        Test ObjectFinder
         */

        // Create a dummy record
        Headline headline = CreateHeadline();

        // Save it
        headline.writer().save();
        // Grab the unique ObjectId so we can query for it
        ObjectId id = headline.getObjectId();

        // Now search for it
        headline = Headline.finder().findOne(id);

        // Assert that we got back the same object. TODO: Implement equals function
        assertTrue(headline.getObjectId().equals(id));

        // Tear down the unit test
        tearDown(id);
    }

}
