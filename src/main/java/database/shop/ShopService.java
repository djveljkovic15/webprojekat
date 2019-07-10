package database.shop;


import database.coupon.CouponRepository;

import java.util.List;

@SuppressWarnings("Duplicates")
public class ShopService {

    public Shop save(Shop shop){
        return ShopRepository.save(shop);
    }
    public Shop update(Shop shop){
        return ShopRepository.update(shop);
    }
    public void deleteById(Long id) throws Exception {
        CouponRepository.findAll().stream()
                .filter(coupon ->
                        coupon.getShop().getId().equals(id))
                .forEach(coupon -> {
                    try {
                        CouponRepository.deleteById(coupon.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        ShopRepository.deleteById(id);
    }
    public Shop findById(Long id) throws Exception {
        return ShopRepository.findById(id);
    }
    public List<Shop> findAll(){
        return ShopRepository.findAll();
    }
}

