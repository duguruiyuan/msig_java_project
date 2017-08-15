package tw.com.msig.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tw.com.msig.entity.Attribute;
import tw.com.msig.service.AttributeService;

@WebServlet("/new_leave")
public class NewLeaveController extends AbstractController{

	/**
   * 
   */
  private static final long serialVersionUID = -4926618046236536116L;

    @Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
	  
	  // 新增假別
	  final AttributeService attributeService = getBean(AttributeService.class);
	  final List<Attribute> types = attributeService.getByAttType("leaveType");
	  
	  // 新增特休
	  final Attribute type1 = new Attribute();
	  type1.setattType("假別");
	  type1.setattValue("1");
	  type1.setattComm("特休");
	  types.add(type1);
	  
	  // 新增病假
	  final Attribute type2 = new Attribute();
	  type2.setattType("假別");
	  type2.setattValue("2");
	  type2.setattComm("病假");
	  types.add(type2);
	  
	  req.setAttribute("leaveTypes", new Gson().toJson(types));
	  
	  //轉頁
	  forward(req, resp, "new_leave");
	}
	
}
