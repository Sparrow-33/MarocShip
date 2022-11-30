package dao;

import JPA.Util.Util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.function.Consumer;

public class Base<T> {
    public static EntityManager entityManager = Util.getEntityManager();

    public Boolean save(T t) {
        if (executeInsideTransaction(entityManager1 -> entityManager.persist(t))) {
            return true;
        }   return false;
    }
    public Boolean update(T t) {
        if (executeInsideTransaction(entityManager1 -> entityManager.merge(t))){
            return true;
        }   return false;
    }
    // visitor dsp
    public static Boolean executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
            return true;
        }
        catch (RuntimeException e) {
            tx.rollback();
//            throw e;
            return false;
        }
    }

}
