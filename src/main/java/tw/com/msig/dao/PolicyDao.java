package tw.com.msig.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import tw.com.msig.entity.Policy;
import tw.com.msig.util.HibernateUtil;

/** @author Matt S.Y Ho */
public class PolicyDao {

  @SuppressWarnings("unchecked")
  public List<Policy> findAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      return (List<Policy>) session.createQuery("from Policy").list();
    } finally {
      session.close();
    }
  }

  public void insert(Policy policy) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      session.save(policy);
      session.getTransaction().commit();
    } catch (RuntimeException e) {
      session.getTransaction().rollback();
      throw e;
    } finally {
      session.close();
    }
  }

  public void delete(Policy policy) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      session.delete(policy);
      session.getTransaction().commit();
    } catch (RuntimeException e) {
      session.getTransaction().rollback();
      throw e;
    } finally {
      session.close();
    }
  }

  public void update(Policy policy) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      session.update(policy);
      session.getTransaction().commit();
    } catch (RuntimeException e) {
      session.getTransaction().rollback();
      throw e;
    } finally {
      session.close();
    }
  }

  @SuppressWarnings("unchecked")
  public List<Policy> findByCondition(String policyNo, String applicantName) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      Criteria crti = (Criteria) session.createCriteria(Policy.class);
      if (policyNo != null && !policyNo.isEmpty()) {
        crti = crti.add(Restrictions.eq("policyNo", policyNo));
      }
      if (applicantName != null && !applicantName.isEmpty()) {
        crti = crti.add(Restrictions.like("applicantName", applicantName + "%"));
      }
      return crti.list();
    } finally {
      session.close();
    }
  }
}
