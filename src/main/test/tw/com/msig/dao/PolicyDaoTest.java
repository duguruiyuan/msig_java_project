package tw.com.msig.dao;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

import tw.com.msig.entity.Policy;
@Transactional
public class PolicyDaoTest implements WebApplicationInitializer {

  @Test
  public void testFindAll() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml",
        "spring-service.xml", "spring-dao.xml");
    PolicyDao dao = context.getBean(PolicyDao.class);
    List<Policy> findAll = dao.findAll();
    findAll.forEach(System.out::println);
  }

  @Test
  public void testSave() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml",
        "spring-service.xml", "spring-dao.xml");
    PolicyDao dao = context.getBean(PolicyDao.class);
    List<Policy> findAll = dao.findAll();
    findAll.forEach(System.out::println);
  }

  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    XmlWebApplicationContext context = new XmlWebApplicationContext();
    context.setConfigLocations("classpath:spring-config.xml", "classpath:spring-service.xml",
        "classpath:spring-dao.xml");
    context.setServletContext(servletContext);
    context.refresh();
    servletContext.addListener(new ContextLoaderListener(context));
  }

}
