package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import persistence.WritableObject;
import persistence.util.CollectionNames;
import persistence.util.ObjectFinder;
import persistence.util.ObjectWriter;

/*
A simple data structure to hold our crawled headlines and source website.
 */
public class Headline implements WritableObject {

    // Unique ID assigned by Mongo. This also acts as a timestamp, hence we don't store the time when we crawled the site
    private ObjectId _id;

    // The source website
    private String source;

    // The crawled headline
    private String headline;

    // For Jackson
    private Headline() {

    }

    public Headline(String source, String headline) {
        this.source = source;
        this.headline = headline;
    }

    // Getters/Setters
    public String getSource() {
        return source;
    }

    public String getHeadline() {
        return headline;
    }

    @Override
    public ObjectWriter writer() {
        return new ObjectWriter(CollectionNames.HEADLINES, this);
    }

    @Override
    @JsonIgnore
    public ObjectId getObjectId() {
        return this._id;
    }

    public static ObjectFinder<Headline> finder() {
        return new ObjectFinder<Headline>(CollectionNames.HEADLINES, Headline.class);
    }
}
