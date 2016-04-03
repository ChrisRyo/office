package tw.com.ktv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import tw.com.ktv.model.dto.Page;

/**
 * BaseDaoImpl
 * 
 * @author chrisryo
 *
 */
public interface BaseDao {

  public EntityManager getEntityManager();

  /**
   * 
   * @param entity
   * @param pageIndex
   * @param pageSize
   * @param isLike
   * @return
   * @throws Exception
   */
  public Page queryPage(Object entity, int pageIndex, int pageSize, boolean isLike)
      throws Exception;

  /**
   * 
   * @param Query
   * @return
   * @throws Exception
   */
  public <P> List<P> queryByJpql(Query query) throws Exception;

  /**
   * 
   * @param Query
   * @param pageIndex
   * @param pageSize
   * @return
   * @throws Exception
   */
  public <P> List<P> queryByJpql(Query query, int pageIndex, int pageSize) throws Exception;

  /**
   * 
   * @param Query
   * @return count
   * @throws Exception
   */
  public long queryCountByJpql(Query query) throws Exception;

  /**
   * 
   * @param sql
   * @return
   * @throws Exception
   */
  public <P> List<P> queryBySql(String sql) throws Exception;

  /**
   * 取得所有資料
   * 
   * @param entity
   * @return
   * @throws Exception
   */
  public <P> List<P> queryAll(Class<?> entity) throws Exception;

  /**
   * 查詢 by entity
   * 
   * @param <T>
   * 
   * @param entity
   * @param isLike
   * @return
   * @throws Exception
   */
  public <P> List<P> queryByEntity(Object entity, boolean isLike) throws Exception;

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
  // public <P> List<P> queryByEntity(Object entity, MemcachedKey fiterKey, MemcachedKey dataKey,
  // boolean isLike) throws Exception;

  /**
   * 查詢總筆數 by entity
   * 
   * @param entity
   * @param isLike
   * @return count
   * @throws Exception
   */
  public int queryCountBySql(Object entity, boolean isLike) throws Exception;

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
  public <P> List<P> queryByEntity(Object entity, boolean isLike, int index, int size)
      throws Exception;

  /**
   * 新增 by entity
   * 
   * @param entity
   * @throws Exception
   */
  public void insertByEntity(Object entity) throws Exception;

  /**
   * 修改 by entity
   * 
   * @param entity
   * @throws Exception
   */
  public void updateByEntity(Object entity) throws Exception;

  /**
   * 修改 by entity
   * 
   * @param entity
   * @throws Exception
   */
  public void deleteByEntity(Object entity) throws Exception;
}
