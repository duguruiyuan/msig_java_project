package tw.com.msig;

import tw.com.msig.util.HibernateUtil;

/** @author Matt S.Y Ho */
public class App {

  public static void main(String... args) {
    try {
      //
      HibernateUtil.getSessionFactory().openSession();
    } finally {
      HibernateUtil.close();
    }
  }
}
