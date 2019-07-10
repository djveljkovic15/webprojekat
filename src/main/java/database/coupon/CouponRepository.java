package database.coupon;


import database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

//    public static List<Coupon> findAllPaginated(){
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        Query query = this.getSession().createQuery("FROM Coupon");
//        query.setFirstResult(0);
//        query.setMaxResults(20);
//        List entities = query.list();
//        session.getTransaction().commit();
//        return session.create
//    }
    public static List<Coupon> findAllPaginated(int firstResult, int maxResult){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Coupon ");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        List<Coupon> couponList = query.list();
        return couponList;
    }

}
