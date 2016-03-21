package tw.com.ktv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
   * @param Query
   * @return
   * @throws Exception
   */
  public List<?> queryByJpql(Query query) throws Exception;

  /**
   * 
   * @param sql
   * @return
   * @throws Exception
   */
  public List<?> queryBySql(String sql) throws Exception;

  /**
   * 取得所有資料
   * 
   * @param entity
   * @return
   * @throws Exception
   */
  public List<?> queryAll(Class<?> entity) throws Exception;

  /**
   * 查詢 by entity
   * 
   * @param entity
   * @param isLike
   * @return
   * @throws Exception
   */
  public List<?> queryByEntity(Object entity, boolean isLike) throws Exception;

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
  public List<?> queryByEntity(Object entity, boolean isLike, int index, int size) throws Exception;

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
