package tw.com.msig.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.com.msig.entity.Leave;

public class LeaveDao {

	private SessionFactory factory;

	public List<Leave> findAll() {
		Session session = factory.getCurrentSession();
		return (List<Leave>) session.createQuery("from my_Leave").list();
	}

	public void insert(Leave leave) {
		factory.getCurrentSession().save(leave);
	}

	public void update(Leave leave) {
		factory.getCurrentSession().update(leave);
	}

	public void delete(Leave leave) {
		factory.getCurrentSession().delete(leave);
	}

	public Leave findOne(String id) {
		Session session = factory.getCurrentSession();
		return (Leave) session.get(Leave.class, id);
	}
}
