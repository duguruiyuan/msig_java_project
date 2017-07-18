package tw.com.msig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tw.com.msig.dao.AttributeDao;
import tw.com.msig.entity.Attribute;

/**
 * @author Matt S.Y Ho
 */
public class AttributeService {

	@Autowired
	private AttributeDao dao;

	public List<Attribute> getAll() {
		return dao.findAll();
	}

	public void save(Attribute attribute) {
		dao.insert(attribute);
	}

	public void update(Attribute attribute) {
		dao.update(attribute);
	}

	public void delete(Attribute attribute) {
		dao.delete(attribute);
	}

	public Attribute getOne(String id) {
		return dao.findOne(id);
	}

	public List<Attribute> getByAttType(String attType) {
		return dao.findByAttType(attType);
	}
}
