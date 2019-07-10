package database.coupon;

import database.pagination.PaginationResponse;
import database.shop.Shop;
import database.shop.ShopRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class CouponService {

    public Coupon save(Coupon coupon){//, Shop shop){
//        try {
//            if(shop==null|| ShopRepository.findById(shop.getId())==null){
//                coupon.setShop(ShopRepository.save(shop));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return CouponRepository.save(coupon);
    }
    public Coupon update(Coupon coupon){//, Shop shop){
//        try {
//            if(shop==null|| ShopRepository.findById(shop.getId())==null){
//                coupon.setShop(ShopRepository.save(shop));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return CouponRepository.update(coupon);
    }
    public void deleteById(Long id) throws Exception {
        CouponRepository.deleteById(id);
    }
    public Coupon findById(Long id) throws Exception {
        return CouponRepository.findById(id);
    }
    public List<Coupon> findAll(){
        return CouponRepository.findAll();
    }
    public List<Coupon> findAllActive(){
        Date date = new Date();
            return CouponRepository.findAll().stream()
                    .filter(coupon ->
                            date.after(getAsDate(coupon.getValidFrom())) &&
                                    date.before(getAsDate(coupon.getValidTo())))
                    .collect(Collectors.toList());
    }
    public List<Coupon> findByShopId(Long id){
        return CouponRepository.findAll().stream()
                .filter(coupon ->
                        coupon.getShop().getId().equals(id))
                .collect(Collectors.toList());

    }
    private Date getAsDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-dd-MM").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

//    public PaginationResponse<List<Coupon>> findAll(Integer pageNumber){
//        return
//    }
//    public PaginationResponse<Coupon> couponPaginationResponse() {
//
//    }


}

