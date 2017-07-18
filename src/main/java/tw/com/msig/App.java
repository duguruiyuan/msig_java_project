package tw.com.msig;

import java.time.LocalDateTime;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ConfigurableWebEnvironment;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

import tw.com.msig.entity.Employee;
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
		
		try {
			// PolicyService service = context.getBean(PolicyService.class);
			// PolicyDao dao = context.getBean(PolicyDao.class);
			//
			//
			// //增新的資料
			// Policy policy = new Policy();
			// policy.setApplicantName("tim");
			// policy.setId(1);
			// policy.setPolicyNo("1");
			// service.save(policy);

			// PolicyDao dao = context.getBean(PolicyDao.class);
			// //查出剛剛存的資料
			// List<Policy> all = service.getAll();
			// all.forEach(System.out::println);

			// EmployeeService sevice = context.getBean(EmployeeService.class);
			// Employee employee = new Employee();
			// employee.setName("tim");
			// sevice.save(employee);
			//
			 EmployeeService service = context.getBean(EmployeeService.class);
			 // Security security = new Security();
			 // security.setGroup("top");
			 // sevice.save(security);
			 Employee emp = new Employee();
			 emp.setHireDate(LocalDateTime.now());
			
			
			 // List<Security> all = sevice.getAll();
			 // all.forEach(System.out::println);
			 service.save(emp);
			
			 service.getAll().forEach(System.out::println);
		} finally {
			context.close();
		}
	}
}
