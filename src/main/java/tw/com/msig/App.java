package tw.com.msig;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

import tw.com.msig.entity.Employee;
import tw.com.msig.entity.Leave;
import tw.com.msig.service.EmployeeService;

/** @author Matt S.Y Ho */
public class App implements WebApplicationInitializer {

  @Override
  public void onStartup(final ServletContext servletContext) throws ServletException {
    final XmlWebApplicationContext context = new XmlWebApplicationContext();
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

  public static void main(final String... args) {
    // System.setProperty("spring.profiles.active", "h2");
    final ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext("spring-config.xml", "spring-service.xml", "spring-dao.xml");
    
    try {

      final EmployeeService employeeService = context.getBean(EmployeeService.class);

      final Leave leave = new Leave();
      leave.setAgent("1");
      final Set<Leave> arrayList = new HashSet<Leave>();
      arrayList.add(leave);
      // 第一名員工
      final Employee employee = new Employee();
      employee.setEmail("test");
      employee.setId(1L);
      employee.setName("test");
      employee.setLeaves(arrayList);

      // 儲存 並印出
      employeeService.save(employee);
      employeeService.getAll().forEach(System.out::println);
      System.out.println("假單: " + employeeService.getOne(employee.getId()).getLeaves());
      
    } finally {
      context.close();
    }
  }
}
