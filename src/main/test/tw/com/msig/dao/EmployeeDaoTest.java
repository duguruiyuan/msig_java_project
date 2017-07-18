package tw.com.msig.dao;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tw.com.msig.service.EmployeeService;


@Transactional
@ContextConfiguration({"/spring-config.xml", "/spring-service.xml", "/spring-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoTest {

  @Autowired
  private EmployeeService service;

  @Test
  public void testFindAll() {
    service.getAll().forEach(System.out::println);
  }

}
