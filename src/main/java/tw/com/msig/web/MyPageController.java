package tw.com.msig.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.msig.entity.Employee;
import tw.com.msig.service.EmployeeService;
import tw.com.msig.util.SecurityUtils;

/**
 * 
 */
@WebServlet("/my_page")
public class MyPageController extends AbstractController{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  EmployeeService employeeService = getBean(EmployeeService.class);
	  Employee loginUser = SecurityUtils.getLoginUser(req).get();  
	  Employee emp = employeeService.getOne(loginUser.getId());
	  req.setAttribute("emp", emp);
      forward(req, resp, "my_page");
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");     
    String email = req.getParameter("email");
    String phone = req.getParameter("phone");
    String password = req.getParameter("password");
    Employee loginUser = SecurityUtils.getLoginUser(req).get();  
    
    EmployeeService employeeService = getBean(EmployeeService.class);
    Employee update = employeeService.update(loginUser.getId(), name, email, phone, password);
    SecurityUtils.setLoginUser(req, update);
    
    forward(req, resp, "my_page");
    
  }
  
}
