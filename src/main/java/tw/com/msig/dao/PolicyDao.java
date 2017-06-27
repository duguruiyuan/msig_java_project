package tw.com.msig.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tw.com.msig.entity.Policy;

import java.util.List;

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

    public void update(Policy policy){
        factory.getCurrentSession().update(policy);
    }
}
