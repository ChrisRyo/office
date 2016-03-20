package tw.com.ktv.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import tw.com.ktv.dao.MemberDao;
import tw.com.ktv.model.vo.Member;

/**
 * MemberDaoImpl
 * 
 * @author chrisryo
 *
 */
public class MemberDaoImpl extends BaseDaoImpl implements MemberDao {

  /**
   * 
   * @param Query
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public List<Member> queryMember(Query query) throws Exception {

    List<Member> list = new ArrayList<Member>();

    list = query.getResultList();

    return list;
  }
}
