package database;

import database.filters.CorsFilter;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/dzo")
public class RestApplication extends ResourceConfig {

    public RestApplication(){
        packages("database");
        register(CorsFilter.class);
    }
}
