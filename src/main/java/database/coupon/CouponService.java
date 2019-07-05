package database.coupon;

import database.shop.Shop;
import database.shop.ShopRepository;

import java.util.List;

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
}

