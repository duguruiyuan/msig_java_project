package tw.com.msig.web;

import tw.com.msig.service.AttributeService;
import tw.com.msig.util.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends AbstractController {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  SecurityUtils.removeUser(req);
	  forward(req, resp, "login");
	}
}
