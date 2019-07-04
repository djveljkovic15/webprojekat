package database.user;


import database.coupon.Coupon;
import database.coupon.CouponService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserController {
    private final UserService UserService;

    public UserController(){
        this.UserService = new UserService();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(User user){
        return UserService.save(user);
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(User user){
        return UserService.save(user);
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
        UserService.deleteById(id);
        return Response.ok().build();
    }
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User findById(@PathParam("id") Long id) throws Exception {
        return UserService.findById(id);
    }
    @GET
//    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll(){
        return UserService.findAll();
    }

}
