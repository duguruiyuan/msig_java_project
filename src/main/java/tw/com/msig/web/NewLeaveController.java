package tw.com.msig.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tw.com.msig.entity.Attribute;
import tw.com.msig.entity.Employee;
import tw.com.msig.entity.Leave;
import tw.com.msig.service.AttributeService;
import tw.com.msig.service.EmployeeService;
import tw.com.msig.service.LeaveService;
import tw.com.msig.util.SecurityUtils;

@WebServlet("/new_leave")
public class NewLeaveController extends AbstractController {

	/**
	* 
	*/
	private static final long serialVersionUID = -4926618046236536116L;

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		// 新增假別
		final AttributeService attributeService = getBean(AttributeService.class);
		final List<Attribute> types = attributeService.getByAttType("leave_type");

		Employee emp = SecurityUtils.getLoginUser(req).orElseThrow(() -> new IllegalArgumentException("user not fond"));

		req.setAttribute("emp", emp);
		req.setAttribute("leaveTypes", types);

		// 轉頁
		forward(req, resp, "new_leave");
	}

	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String employeeId = req.getParameter("employeeId");
		String leave_type = req.getParameter("leave_type");
		String start_time = req.getParameter("start_time");
		String end_time = req.getParameter("end_time");
		String agent = req.getParameter("agent");
		Employee loginUser = SecurityUtils.getLoginUser(req).get();

		EmployeeService employeeService = getBean(EmployeeService.class);
		Employee emp = employeeService.getOne(loginUser.getId());
		if (emp.getLeaves() == null) {
			emp.setLeaves(new HashSet<>());
		} 
		
		Leave leave = new Leave();
		leave.setLeave_type(leave_type);
		leave.setStart_time(LocalDateTime.parse(start_time));
		leave.setEnd_time(LocalDateTime.parse(end_time));
		leave.setAgent(agent);
		leave.setKey_time(LocalDateTime.now());
		emp.getLeaves().add(leave);
		employeeService.update(emp);
		
		// 轉頁
		forward(req, resp, "new_leave");
	}
}
