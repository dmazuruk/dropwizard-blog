package pl.dmazuruk.blog.resource;

import com.codahale.metrics.annotation.Timed;
import net.vz.mongodb.jackson.JacksonDBCollection;
import pl.dmazuruk.blog.model.Blog;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dmazuruk on 7/24/14.
 */
@Path("/blogs")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class BlogResource {

    private JacksonDBCollection<Blog, String> collection;

    public BlogResource(JacksonDBCollection<Blog, String> blogs) {
        this.collection = blogs;
    }

    @POST
    @Timed
    public Response publishNewBlog(@Valid Blog blog) {
        collection.insert(blog);
        return Response.noContent().build();
    }
}
