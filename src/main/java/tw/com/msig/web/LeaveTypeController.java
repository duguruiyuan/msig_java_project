package tw.com.msig.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.msig.entity.Attribute;
import tw.com.msig.service.AttributeService;

@WebServlet("/leave/types")
public class LeaveTypeController extends AbstractController {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    AttributeService attributeService = getBean(AttributeService.class);

    List<Attribute> types = attributeService.getByAttType("leaveType");

    req.setAttribute("leaveTypes", types);

  }

}
