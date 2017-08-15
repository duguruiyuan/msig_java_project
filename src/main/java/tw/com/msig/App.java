package tw.com.msig;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ConfigurableWebEnvironment;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

import tw.com.msig.dao.AttributeDao;
import tw.com.msig.entity.Attribute;
import tw.com.msig.entity.Employee;
import tw.com.msig.service.AttributeService;
import tw.com.msig.service.EmployeeService;

/** @author Matt S.Y Ho */
public class App implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    XmlWebApplicationContext context = new XmlWebApplicationContext();
    context.setConfigLocations("classpath:spring-config.xml", "classpath:spring-service.xml",
        "classpath:spring-dao.xml");
    context.setServletContext(servletContext);
    context.refresh();
    servletContext.addListener(new ContextLoaderListener(context));
  }

  // ctrl + 1 : eclispe 建議視窗
  // 打 main 按 alt + /
  // ctrl + shift + f : 排版
  // ctrl + shift + o : 整理 import
  // ctrl + sfhit + t : 找 class
  // ctrl + sfhit + r : 找 resource

  public static void main(String... args) {
    // System.setProperty("spring.profiles.active", "h2");
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml",
        "spring-service.xml", "spring-dao.xml");
    EmployeeService employeeService= context.getBean(EmployeeService.class);
    List<Employee> all = employeeService.getAll();
    all.forEach(System.out::println);
    AttributeService AttributeService = context.getBean(AttributeService.class);
    List<Attribute> all2 = AttributeService.getAll();
    all2.forEach(System.out::println);
    // 1.做完假資料
    // 2.把所有 servelt 要得 method 準備好 get post ...
    
    try {
      // PolicyService service = context.getBean(PolicyService.class);
      // PolicyDao dao = context.getBean(PolicyDao.class);

    } finally {
      context.close();
    }
  }
}
