package tw.com.msig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.dao.LeaveDao;
import tw.com.msig.entity.Leave;

/**
 * @author Matt S.Y Ho
 */
public class LeaveService {

	@Autowired
	private LeaveDao dao;

	public List<Leave> getAll() {
		return dao.findAll();
	}

	public void save(Leave leave) {
		dao.insert(leave);
	}

	public void update(Leave leave) {
		dao.update(leave);
	}

	public void delete(Leave leave) {
		dao.delete(leave);
	}

	public Leave getOne(String id) {
		return dao.findOne(id);
	}

}
