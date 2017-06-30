package tw.com.msig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.dao.SecurityDao;
import tw.com.msig.entity.Security;

/**
 * @author Matt S.Y Ho
 */
public class SecurityService {

	@Autowired
	private SecurityDao dao;

	public List<Security> getAll() {
		return dao.findAll();
	}

	public void save(Security Security) {
		dao.insert(Security);
	}

}
