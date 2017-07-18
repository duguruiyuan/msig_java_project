package tw.com.msig.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.entity.Security;

public class SecurityDao {

  @Autowired
  private SessionFactory factory;

  public List<Security> findAll() {
    Session session = factory.getCurrentSession();
    return (List<Security>) session.createQuery("from Security").list();
  }

  public void insert(Security security) {
    factory.getCurrentSession().save(security);
  }

  public void update(Security Security) {
    factory.getCurrentSession().update(Security);
  }

  public void delete(Security Security) {
    factory.getCurrentSession().update(Security);
  }

}
