package tw.com.msig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.dao.HolidayDao;
import tw.com.msig.entity.Holiday;

/**
 * @author Ichien Lin
 */
public class HolidayService {

	@Autowired
	private HolidayDao dao;

	public List<Holiday> getAll() {
		return dao.findAll();
	}

	public void save(Holiday holiday) {
		dao.insert(holiday);
	}

	public void update(Holiday holiday) {
		dao.update(holiday);
	}

	public void delete(Holiday holiday) {
		dao.delete(holiday);
	}

}
