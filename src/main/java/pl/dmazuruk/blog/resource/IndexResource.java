package pl.dmazuruk.blog.resource;

import com.codahale.metrics.annotation.Timed;
import pl.dmazuruk.blog.model.Blog;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmazuruk on 7/20/14.
 */
@Path("/")
public class IndexResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    public List<Blog> index() {
        return Arrays.asList(new Blog("Fake dmazuruk's blog",
                "https://dmazuruk.com/fake-blog"));
    }
}
