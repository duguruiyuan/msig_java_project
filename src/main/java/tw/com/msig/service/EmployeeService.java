package tw.com.msig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.dao.EmployeeDao;
import tw.com.msig.entity.Employee;

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

}
