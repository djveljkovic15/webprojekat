package database.user;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserController {
    private final UserService userService;

    public UserController(){
        this.userService = new UserService();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(User user){
        return userService.save(user);
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(User user){
        return userService.update(user);
    }

//    @DELETE
//    @Path("/delete/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void deleteById(@PathParam("id") Long id) throws Exception {
//        userService.deleteById(id);
//    }
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id) throws Exception {
        userService.deleteById(id);
        return Response.ok().build();
    }
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User findById(@PathParam("id") Long id) throws Exception {
        return userService.findById(id);
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll(){
        return userService.findAll();
    }

    @POST
    @Path("/login/{username}-{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User login(@PathParam("username")String username, @PathParam("password")String password) {
        return userService.login(username, password);
    }
}
