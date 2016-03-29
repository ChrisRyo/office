package tw.com.ktv.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tw.com.ktv.dao.BaseDao;
import tw.com.ktv.entityManager.EntityManagerHelper;
import tw.com.ktv.util.EntityUtils;

/**
 * BaseDaoImpl
 * 
 * @author chrisryo
 *
 */
public abstract class BaseDaoImpl implements BaseDao {

  protected final int MAX_COUNT = 10000;

  @PersistenceContext
  protected EntityManager em;

  /**
   * creat
   */
  public BaseDaoImpl() {
    em = EntityManagerHelper.getEntityManager();
  }

  public EntityManager getEntityManager() {
    return em;
  }

  /**
   * 
   * @param Query
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public <P> List<P> queryByJpql(Query query) throws Exception {
    return (List<P>) query.setMaxResults(MAX_COUNT).getResultList();
  }

  /**
   * 
   * @param Query
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public <P> List<P> queryByJpql(Query query, int pageIndex, int pageSize) throws Exception {

    int begin = ((pageIndex - 1) * pageSize);
    int length = pageSize;

    return (List<P>) query.setMaxResults(MAX_COUNT).setFirstResult(begin).setMaxResults(length)
        .getResultList();
  }

  /**
   * 
   * @param Query
   * @return count
   * @throws Exception
   */
  public long queryCountByJpql(Query query) throws Exception {
    return (Long) query.getSingleResult();
  }

  /**
   * 
   * @param sql
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public <P> List<P> queryBySql(String sql) throws Exception {
    Query query = em.createQuery(sql).setMaxResults(MAX_COUNT);
    return (List<P>) query.getResultList();
  }


  /**
   * 取得所有資料
   * 
   * @param entity
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public <P> List<P> queryAll(Class<?> entity) throws Exception {
    Query query = em.createNamedQuery(entity.getSimpleName() + ".findAll").setMaxResults(MAX_COUNT);
    return (List<P>) query.getResultList();
  }

  /**
   * 查詢 by entity
   * 
   * @param entity
   * @param isLike
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public <P> List<P> queryByEntity(Object entity, boolean isLike) throws Exception {

    String sql = EntityUtils.getQueryEntitySql(entity, isLike);

    if (sql == null) {
      return queryAll(entity.getClass());
    }

    Query query = em.createQuery(sql).setMaxResults(MAX_COUNT);

    return (List<P>) query.getResultList();
  }

  // /**
  // * 查詢 by entity & MemcachedKey
  // *
  // * @param entity
  // * @param fiterKey
  // * @param dataKey
  // * @param isLike
  // * @return
  // * @throws Exception
  // */
  // @SuppressWarnings("unchecked")
  // public <P> List<P> queryByEntity(Object entity, MemcachedKey fiterKey, MemcachedKey dataKey,
  // boolean isLike) throws Exception {
  //
  // Integer uid = UserUtils.getUid();
  //
  // List<P> list = new ArrayList<P>();
  //
  // Object chkObj = Memcached.get(fiterKey, uid);
  //
  // if (chkObj != null && entity.equals(chkObj)) {
  // list = Memcached.get(dataKey, uid);
  // } else {
  // String sql = EntityUtils.getQueryEntitySql(entity, isLike);
  // Query query = em.createQuery(sql).setMaxResults(MAX_COUNT);
  // list = query.getResultList();
  //
  // Memcached.set(fiterKey, uid, entity);
  // Memcached.set(dataKey, uid, list);
  // }
  //
  // return list;
  // }

  /**
   * 查詢總筆數 by entity
   * 
   * @param entity
   * @param isLike
   * @return count
   * @throws Exception
   */
  public int queryCountBySql(Object entity, boolean isLike) throws Exception {

    String sql = EntityUtils.getQueryCountSql(entity, isLike);

    Query query = em.createQuery(sql);

    return ((Long) query.getSingleResult()).intValue();
  }

  /**
   * 查詢 by entity where begin and end
   * 
   * @param entity
   * @param isLike
   * @param index
   * @param size
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public <P> List<P> queryByEntity(Object entity, boolean isLike, int index, int size)
      throws Exception {

    String sql = EntityUtils.getQueryEntitySql(entity, isLike);

    int begin = ((index - 1) * size);
    int length = size;

    Query query =
        em.createQuery(sql).setMaxResults(MAX_COUNT).setFirstResult(begin).setMaxResults(length);

    return (List<P>) query.getResultList();
  }

  /**
   * 新增
   * 
   * @param entity
   * @throws Exception
   */
  public void insertByEntity(Object entity) throws Exception {

    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();
      em.persist(entity);
      em.flush();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      throw new Exception(e);
    }
  }

  /**
   * 修改
   * 
   * @param entity
   * @throws Exception
   */
  public void updateByEntity(Object entity) throws Exception {

    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();
      em.merge(entity);
      transaction.commit();
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
      throw new Exception(e);
    }
  }

  /**
   * 刪除
   * 
   * @param entity
   * @throws Exception
   */
  public void deleteByEntity(Object entity) throws Exception {

    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();
      Object newEntity = em.merge(entity);
      em.remove(newEntity);
      em.flush();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      throw new Exception(e);
    }
  }
}
