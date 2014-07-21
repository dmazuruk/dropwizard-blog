package pl.dmazuruk.blog;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import pl.dmazuruk.blog.config.BlogConfiguration;
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
        final IndexResource indexResource = new IndexResource();
        environment.jersey().register(indexResource);
    }
}
