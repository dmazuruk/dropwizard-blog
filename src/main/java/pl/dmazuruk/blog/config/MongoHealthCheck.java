package pl.dmazuruk.blog.config;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.Mongo;

/**
 * Created by dmazuruk on 7/21/14.
 */
public class MongoHealthCheck extends HealthCheck {

    private Mongo mongo;

    public MongoHealthCheck(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    protected Result check() throws Exception {
        mongo.getDatabaseNames();
        return Result.healthy();
    }
}
