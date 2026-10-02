package ir.maktabsharif.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Function;

public class JpaUtil {
    private static final String PERSISTENCE_UNIT = "default";
    private static EntityManagerFactory emf;
    public static synchronized EntityManagerFactory getEmf(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }
    public static EntityManager getEm(){
        return getEmf().createEntityManager();
    }
    public static <T>T inTXResult(Function<EntityManager,T> operation){
        EntityManager em = getEm();
        EntityTransaction tx = getEm().getTransaction();
        try{
            tx.begin();
            T result = operation.apply(em);
            tx.commit();
            return result;
        }
        catch (RuntimeException e){
            tx.rollback();
            throw e;
        }
        finally {
            em.close();
        }
    }
}