package tw.com.msig.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** @author Matt S.Y Ho */
public class HibernateUtil {

  private static SessionFactory sessionFactory;

  private HibernateUtil() {}

  @SuppressWarnings("deprecation")
  public static SessionFactory getSessionFactory() {
    synchronized (HibernateUtil.class) {
      if (sessionFactory == null) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
      }
    }
    return sessionFactory;
  }

  public static void close() {
    synchronized (HibernateUtil.class) {
      if (sessionFactory != null) {
        sessionFactory.close();
      }
    }
  }
}
