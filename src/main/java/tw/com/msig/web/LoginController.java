package tw.com.msig.web;

import tw.com.msig.entity.Attribute;
import tw.com.msig.entity.Employee;
import tw.com.msig.entity.User;
import tw.com.msig.service.AttributeService;
import tw.com.msig.service.EmployeeService;
import tw.com.msig.util.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/login")
public class LoginController extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req, resp, "login");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得登入相關資料
		final String employeeId = req.getParameter("employeeId");
		final String password = req.getParameter("password");

		// 登入實作
		
		EmployeeService employeeService = getBean(EmployeeService.class);

		Employee user = employeeService.getUser(employeeId, password);

		if (user ==null) {
		  req.setAttribute("error", "查無帳號!!");
		  forward(req, resp, "login");
		}else {
		//SecurityUtils.setLoginUser(req, user);
		  resp.sendRedirect("");
		}
	
	}
}
