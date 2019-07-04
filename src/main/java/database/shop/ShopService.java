package database.shop;


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
        ShopRepository.deleteById(id);
    }
    public Shop findById(Long id) throws Exception {
        return ShopRepository.findById(id);
    }
    public List<Shop> findAll(){
        return ShopRepository.findAll();
    }
}

