package tw.com.msig.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.entity.Employee;
import tw.com.msig.entity.Leave;

import java.util.List;

public class EmployeeDao {

	@Autowired
	private SessionFactory factory;

	public List<Employee> findAll() {
		Session session = factory.getCurrentSession();
		return (List<Employee>) session.createQuery("from employee").list();
	}

	public void insert(Employee employee) {
		factory.getCurrentSession().save(employee);
	}

	public void update(Employee employee) {
		factory.getCurrentSession().update(employee);
	}

	public void delete(Employee employee) {
		factory.getCurrentSession().update(employee);
	}

	public Employee findOne(String id) {
		Session session = factory.getCurrentSession();
		return (Employee) session.get(Employee.class, id);
	}
}
