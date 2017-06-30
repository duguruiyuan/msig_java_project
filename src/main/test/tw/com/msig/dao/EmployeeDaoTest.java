package tw.com.msig.dao;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

import tw.com.msig.entity.Policy;
import tw.com.msig.service.PolicyService;

public class EmployeeDaoTest implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    XmlWebApplicationContext context = new XmlWebApplicationContext();
    context.setConfigLocations("classpath:spring-config.xml", "classpath:spring-service.xml",
        "classpath:spring-dao.xml");
    context.setServletContext(servletContext);
    context.refresh();
    servletContext.addListener(new ContextLoaderListener(context));
  }

  @Test
  public void testFindAll() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml",
        "spring-service.xml", "spring-dao.xml");
    PolicyService service = context.getBean(PolicyService.class);
    List<Policy> all = service.getAll();
    all.forEach(System.out::println);
  }

}
