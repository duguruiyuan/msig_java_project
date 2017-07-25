package tw.com.msig.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.entity.Attribute;
import tw.com.msig.entity.Leave;
import tw.com.msig.entity.Policy;

import java.util.List;

public class AttributeDao {

	@Autowired
	private SessionFactory factory;

	public List<Attribute> findAll() {
		Session session = factory.getCurrentSession();
		return (List<Attribute>) session.createQuery("from Attribute").list();
	}

	public void insert(Attribute attribute) {
		factory.getCurrentSession().save(attribute);
	}

	public void update(Attribute attribute) {
		factory.getCurrentSession().update(attribute);
	}

	public void delete(Attribute attribute) {
		factory.getCurrentSession().update(attribute);
	}

	public Attribute findOne(long id) {
		Session session = factory.getCurrentSession();
		return (Attribute) session.get(Attribute.class, id);
	}

	public List<Attribute> findByAttType(String attType) {
		
		Session session = factory.getCurrentSession();
		Criteria crti = (Criteria) session.createCriteria(Attribute.class);
		
		if (attType != null && !attType.isEmpty()) {
			crti = crti.add(Restrictions.eq("attType", attType));
		}
		
		return crti.list();
	}
}
