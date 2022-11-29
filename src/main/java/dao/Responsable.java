package dao;

import Interfaces.User;
import entities.ResponsableENT;
import jakarta.persistence.TypedQuery;
import services.PasswordManager;

import java.time.LocalDate;

public class Responsable extends Base<ResponsableENT> implements User<ResponsableENT> {
    @Override
    public ResponsableENT findByEmail(String email) {
        TypedQuery<ResponsableENT> query = entityManager.createQuery("SELECT r from ResponsableENT r WHERE r.email = :email", ResponsableENT.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public ResponsableENT signIn(String email, String password) {
        ResponsableENT responsable = findByEmail(email);
        if (PasswordManager.passwordVerify(password, responsable.getPassword())) {
            return responsable;
        }
        System.out.println("Password Or Email incorrect");
        return null;
    }

    public Boolean createDelivery(ResponsableENT responsable) {
        if (new Responsable().save(responsable)) {
            return true;
        }
        return false;
//        int chauffeur, int poids, int tarif, String villeDepart, String villeArrivee, LocalDate dateLivraison
    }
}
