package tw.com.msig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.dao.PolicyDao;
import tw.com.msig.entity.Leave;
import tw.com.msig.entity.Policy;

/**
 * @author Matt S.Y Ho
 */
public class PolicyService {

	@Autowired
	private PolicyDao dao;

	public List<Policy> getAll() {
		return dao.findAll();
	}

	public void save(Policy policy) {
		dao.insert(policy);
	}

	public void update(Policy policy) {
		dao.update(policy);
	}

	public void delete(Policy policy) {
		dao.delete(policy);
	}

	public Policy getOne(String id) {
		return dao.findOne(id);
	}
}
