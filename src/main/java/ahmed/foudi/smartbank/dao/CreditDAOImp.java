package ahmed.foudi.smartbank.dao;

import ahmed.foudi.smartbank.db.HibernateDB;
import ahmed.foudi.smartbank.entities.Request;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class CreditDAOImp implements CreditDAO {
    @Override
    public Request save(Request creditRequest) {
        EntityManager em = HibernateDB.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(creditRequest);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la création de la demande de crédit", e);
        } finally {
            em.close();
        }
        return creditRequest;
    }

    @Override
    public Optional<Request> findById(Long id) {
        EntityManager em = HibernateDB.getInstance().getEntityManager();
        try {
            Request demande = em.find(Request.class, id);
            return Optional.ofNullable(demande);
        } finally {
            em.close();
        }
    }

    @Override
    public Request update(Request creditRequest) {
        EntityManager em = HibernateDB.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            Request updatedDemandeCredit = em.merge(creditRequest);
            em.getTransaction().commit();
            return updatedDemandeCredit;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la mise à jour de la demande de crédit", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        EntityManager em = HibernateDB.getInstance().getEntityManager();
        try {
            Request creditRequest = em.find(Request.class, id);
            if (creditRequest != null) {
                em.getTransaction().begin();
                em.remove(creditRequest);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la suppression de la demande de crédit", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Request> findAll() {
        EntityManager em = HibernateDB.getInstance().getEntityManager();
        try {
            return em.createQuery("FROM Request ", Request.class).getResultList();
        } finally {
            em.close();
        }
    }
}
