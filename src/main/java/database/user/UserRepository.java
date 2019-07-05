package database.user;


import database.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

@SuppressWarnings("Duplicates")
public class UserRepository {

    private UserRepository(){

    }

    public static User save(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }
    public static User update(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        return user;
    }
    public static void deleteById(Long id) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(findById(id));
        session.getTransaction().commit();
    }
    public static User findById(Long id) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        if (user != null)
            return user;
        else
            throw new Exception("Couldn't find user with given ID.");
    }
    public static List<User> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("SELECT a FROM User a", User.class).getResultList();

    }
}
