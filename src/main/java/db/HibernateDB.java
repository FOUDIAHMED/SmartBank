package db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateDB {
    private static HibernateDB instance;
    private final EntityManagerFactory entityManagerFactory;


    private HibernateDB() {
        entityManagerFactory = Persistence.createEntityManagerFactory("smartbank");
    }

    public static HibernateDB getInstance() {
        if(instance == null) {
            synchronized (HibernateDB.class) {
                if (instance == null) {
                    instance = new HibernateDB();
                }
            }
        }
        return instance;
    }

    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
