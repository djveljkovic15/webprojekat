package database.shop;


import database.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

@SuppressWarnings("Duplicates")
public class ShopRepository {

    private ShopRepository(){

    }

    public static Shop save(Shop shop){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(shop);
        session.getTransaction().commit();
        return shop;
    }
    public static Shop update(Shop shop){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(shop);
        session.getTransaction().commit();
        return shop;
    }
    public static void deleteById(Long id) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(findById(id));
        session.getTransaction().commit();
    }
    public static Shop findById(Long id) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Shop shop = session.get(Shop.class, id);
        if (shop != null)
            return shop;
        else
            throw new Exception("Couldn't find coupon with given ID.");
    }
    public static List<Shop> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("SELECT a FROM Shop a", Shop.class).getResultList();

    }
}
