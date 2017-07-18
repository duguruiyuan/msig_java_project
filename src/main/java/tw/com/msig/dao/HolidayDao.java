package tw.com.msig.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.entity.Holiday;

public class HolidayDao {

  @Autowired
  private SessionFactory factory;

  public List<Holiday> findAll() {
    Session session = factory.getCurrentSession();
    return (List<Holiday>) session.createQuery("from Holiday").list();
  }

  public void insert(Holiday holiday) {
    factory.getCurrentSession().save(holiday);
  }

  public void update(Holiday holiday) {
    factory.getCurrentSession().update(holiday);
  }

  public void delete(Holiday holiday) {
    factory.getCurrentSession().update(holiday);
  }
    
  public Holiday findOne(String id) {
    Session session = factory.getCurrentSession();
    return (Holiday) session.get(Holiday.class, id);
  }

  
  
}
