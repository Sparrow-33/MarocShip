package dao;

import Interfaces.User;
import entities.ManagerENT;
import entities.ResponsableENT;
import jakarta.persistence.TypedQuery;
import services.PasswordManager;

public class Manager extends Base<ManagerENT> implements User {

    @Override
    public ManagerENT findByEmail(String email) {
        TypedQuery<ManagerENT> query = entityManager.createQuery("SELECT e FROM ManagerENT e WHERE e.email = :email", ManagerENT.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public Object signIn(String email, String password) {
        ManagerENT manager = findByEmail(email);

        if (PasswordManager.passwordVerify(password, manager.getPassword())) {
            return manager;
        }
        System.out.println("Password Or Email incorrect");
        return null;
    }

    public Boolean addDeliveryManager(String email, String password) {
        ResponsableENT responsable = new ResponsableENT();
        responsable.setEmail(email);
        responsable.setPassword( PasswordManager.passwordEncrypt(password) );

        if (new Responsable().save(responsable)) {
            return true;
        }
        return false;
    }



}
