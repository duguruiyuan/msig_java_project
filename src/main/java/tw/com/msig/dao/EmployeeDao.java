package tw.com.msig.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.entity.Attribute;
import tw.com.msig.entity.Employee;
import tw.com.msig.entity.Leave;

import java.util.List;

public class EmployeeDao {

	@Autowired
	private SessionFactory factory;

	public List<Employee> findAll() {
		Session session = factory.getCurrentSession();
		return (List<Employee>) session.createQuery("from Employee").list();
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

	public Employee findOne(long id) {
		Session session = factory.getCurrentSession();
		return (Employee) session.get(Employee.class, id);
	}
	
	public Employee findUser(String employeeId, String password) {
      
      Session session = factory.getCurrentSession();
      Criteria crti = (Criteria) session.createCriteria(Employee.class);
  
      crti = crti.add(Restrictions.eq("employeeId", employeeId));
      crti = crti.add(Restrictions.eq("password", password));
 
      
      return (Employee) crti.uniqueResult();
  }
}
