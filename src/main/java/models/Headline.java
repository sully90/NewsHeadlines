package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import persistence.WritableObject;
import persistence.util.CollectionNames;
import persistence.util.ObjectFinder;
import persistence.util.ObjectWriter;

public class Headline implements WritableObject {

    private ObjectId _id;

    private String source;

    private String headline;

    private Headline() {

    }

    public Headline(String source, String headline) {
        this.source = source;
        this.headline = headline;
    }

    public ObjectId get_id() {
        return _id;
    }

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
