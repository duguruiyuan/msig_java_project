package tw.com.msig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.dao.EmployeeDao;
import tw.com.msig.entity.Employee;
import tw.com.msig.entity.Leave;

/**
 * @author Matt S.Y Ho
 */
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public List<Employee> getAll() {
		return dao.findAll();
	}

	public void save(Employee employee) {
		dao.insert(employee);
	}

	public void update(Employee employee) {
		dao.update(employee);
	}

	public void delete(Employee employee) {
		dao.delete(employee);
	}

	public Employee getOne(long id) {
		return dao.findOne(id);
	}
	
	public Employee getUser(String employeeId, String password) {
	    return dao.findUser(employeeId, password);
	}
	
	public Employee update(long id, String name, String email, String phone, String password) {
	  Employee dbEntity = getOne(id);
	  dbEntity.setName(name);
	  dbEntity.setEmail(email);
	  dbEntity.setPhoneNumber(phone);
	  dbEntity.setPassword(password);
	  dao.update(dbEntity);
	  return dbEntity;
  }
}
