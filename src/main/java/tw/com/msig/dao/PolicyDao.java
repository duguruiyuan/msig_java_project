package tw.com.msig.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.entity.Policy;
import tw.com.msig.entity.Security;

/**
 * @author Matt S.Y Ho
 */
public class PolicyDao {

  @Autowired
  private SessionFactory factory;

  public List<Policy> findAll() {
    Session session = factory.getCurrentSession();
    return (List<Policy>) session.createQuery("from Policy").list();
  }

  public void insert(Policy policy) {
    factory.getCurrentSession().save(policy);
  }

  public void update(Policy policy) {
    factory.getCurrentSession().update(policy);
  }

  public List<Policy> findByCondition(String policyNo, String applicantName) {
    Session session = factory.getCurrentSession();
    Criteria crti = (Criteria) session.createCriteria(Policy.class);
    if (policyNo != null && !policyNo.isEmpty()) {
      crti = crti.add(Restrictions.eq("policyNo", policyNo));
    }
    if (applicantName != null && !applicantName.isEmpty()) {
      crti = crti.add(Restrictions.like("applicantName", applicantName + "%"));
    }
    return crti.list();
  }

  public Policy findOne(String id) {
    Session session = factory.getCurrentSession();
    return (Policy) session.get(Policy.class, id);
  }

}
