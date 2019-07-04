package database.coupon;


import database.HibernateUtil;
import database.Main;
import org.hibernate.Session;

import java.util.List;

@SuppressWarnings("Duplicates")
public class CouponRepository {

    private CouponRepository(){

    }

    public static Coupon save(Coupon coupon){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(coupon);
        session.getTransaction().commit();
        return coupon;
    }
    public static Coupon update(Coupon coupon){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(coupon);
        session.getTransaction().commit();
        return coupon;
    }
    public static void deleteById(Long id) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(findById(id));
        session.getTransaction().commit();
    }
    public static Coupon findById(Long id) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Coupon coupon = session.get(Coupon.class, id);
        if (coupon != null)
            return coupon;
        else
            throw new Exception("Couldn't find coupon with given ID.");
    }
    public static List<Coupon> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("SELECT a FROM Coupon a", Coupon.class).getResultList();

    }
}
