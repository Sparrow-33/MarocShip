package Dao;
import entities.AdminENT;
import org.hibernate.Session;

public class LoginDAO {

    public static Boolean loginAdmin(String email, String password) {
        System.out.println("jat 3amra :"+email);
        System.out.println("jat 3amra :"+password);
        AdminENT adminENT = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            adminENT = (AdminENT) session.createQuery("SELECT U FROM AdminENT U WHERE U.email = :email and U.password=:password").setParameter("email", email).setParameter("password", password).uniqueResult();
            if (adminENT != null) {
                return true;
            }
            session.persist(adminENT);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return false;
    }
}
