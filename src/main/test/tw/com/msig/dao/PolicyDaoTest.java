package tw.com.msig.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@ContextConfiguration({"/spring-config.xml", "/spring-service.xml", "/spring-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PolicyDaoTest {

  @Autowired
  private PolicyDao dao;

  @Test
  public void testSave() {
  }

}
