package database.coupon;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(){
        this.couponService = new CouponService();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Coupon save(Coupon coupon){
//        return couponService.save(coupon);
        if(coupon.getShop()==null)
            throw new NullPointerException();
        return couponService.save(coupon,coupon.getShop());
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Coupon update(Coupon coupon){
        if(coupon.getShop()==null)
            throw new NullPointerException();
        return couponService.save(coupon,coupon.getShop());
    }

//    @DELETE
//    @Path("/delete/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void deleteById(@PathParam("id") Long id) throws Exception {
//        couponService.deleteById(id);
//    }
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id) throws Exception {
        couponService.deleteById(id);
        return Response.ok().build();
    }
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Coupon findById(@PathParam("id") Long id) throws Exception {
        return couponService.findById(id);
    }
    @GET
//    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Coupon> findAll(){
        return couponService.findAll();
    }






}