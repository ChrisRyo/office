package tw.com.ktv.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {

  private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();
  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo");

  public static EntityManager getEntityManager() {
    EntityManager em = threadLocal.get();
    if (em == null || !em.isOpen()) {
      em = emf.createEntityManager();
      threadLocal.set(em);
    }
    return em;
  }

  /**
   * close connection
   */
  public static void closeConnection() {
    EntityManager em = threadLocal.get();
    if (em != null && em.isOpen()) {
      em.close();
    }
  }
}
