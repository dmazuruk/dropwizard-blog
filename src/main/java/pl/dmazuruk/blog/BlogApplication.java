package pl.dmazuruk.blog;

import com.mongodb.DB;
import com.mongodb.Mongo;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.vz.mongodb.jackson.JacksonDBCollection;
import pl.dmazuruk.blog.config.BlogConfiguration;
import pl.dmazuruk.blog.config.MongoHealthCheck;
import pl.dmazuruk.blog.config.MongoManaged;
import pl.dmazuruk.blog.model.Blog;
import pl.dmazuruk.blog.resource.BlogResource;
import pl.dmazuruk.blog.resource.IndexResource;

/**
 * Created by dmazuruk on 7/20/14.
 */
public class BlogApplication extends Application<BlogConfiguration> {

    public static void main(String[] args) throws Exception {
        new BlogApplication().run(new String[] { "server" });
    }

    @Override
    public String getName() {
        return "blog";
    }

    @Override
    public void initialize(Bootstrap<BlogConfiguration> blogConfigurationBootstrap) {

    }

    @Override
    public void run(BlogConfiguration blogConfiguration, Environment environment) throws Exception {
        Mongo mongo = new Mongo(blogConfiguration.mongohost, blogConfiguration.mongoport);
        MongoManaged mongoManaged = new MongoManaged(mongo);
        environment.lifecycle().manage(mongoManaged);

        environment.healthChecks().register("MongoHealthCheck", new MongoHealthCheck(mongo));

        DB db = mongo.getDB(blogConfiguration.mongodb);
        JacksonDBCollection<Blog, String> blogs =
                JacksonDBCollection.wrap(db.getCollection("blogs"), Blog.class, String.class);

        final IndexResource indexResource = new IndexResource(blogs);
        environment.jersey().register(indexResource);

        final BlogResource blogResource = new BlogResource(blogs);
        environment.jersey().register(blogResource);
    }
}
