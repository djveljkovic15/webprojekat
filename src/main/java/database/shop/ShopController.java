package database.shop;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/shops")
public class ShopController {
    private final ShopService shopService;

    public ShopController(){
        this.shopService = new ShopService();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Shop save(Shop shop){
        return shopService.save(shop);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Shop update(Shop shop){
        return shopService.save(shop);
    }

//    @DELETE
//    @Path("/delete/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void deleteById(@PathParam("id") Long id) throws Exception {
//        shopService.deleteById(id);
//    }
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id) throws Exception {
        shopService.deleteById(id);
        return Response.ok().build();
    }
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Shop findById(@PathParam("id") Long id) throws Exception {
        return shopService.findById(id);
    }
    @GET
//    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shop> findAll(){
        return shopService.findAll();
    }


}
