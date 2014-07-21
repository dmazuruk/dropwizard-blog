package pl.dmazuruk.blog.config;

import com.mongodb.Mongo;
import io.dropwizard.lifecycle.Managed;

/**
 * Created by dmazuruk on 7/21/14.
 */
public class MongoManaged implements Managed {

    private Mongo mongo;

    public MongoManaged(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
        mongo.close();
    }
}
