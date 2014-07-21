package pl.dmazuruk.blog.config;

import io.dropwizard.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by dmazuruk on 7/20/14.
 */
public class BlogConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    public String mongohost = "127.0.0.1";

    @JsonProperty
    @Min(1)
    @Max(65535)
    public int mongoport = 27017;

    @JsonProperty
    @NotEmpty
    public String mongodb = "mydb";
}
