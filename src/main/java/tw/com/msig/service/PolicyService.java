package tw.com.msig.service;

import tw.com.msig.dao.PolicyDao;
import tw.com.msig.entity.Policy;

import java.util.List;

/** @author Matt S.Y Ho */
public class PolicyService {

  private final PolicyDao dao;

  public PolicyService() {
    dao = new PolicyDao();
  }

  public List<Policy> getAll() {
    return dao.findAll();
  }

  public void insert(Policy policy) {
    dao.insert(policy);
  }

  public void update(Policy policy) {
    dao.update(policy);
  }

  public void delete(Policy policy) {
    dao.delete(policy);
  }

  public List<Policy> getByCondition(String policyNo, String applicantName) {
    return dao.findByCondition(policyNo, applicantName);
  }
}
