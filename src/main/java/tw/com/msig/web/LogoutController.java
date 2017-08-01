package tw.com.msig.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.msig.util.SecurityUtils;

@WebServlet("/logout")
public class LogoutController extends AbstractController {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SecurityUtils.removeUser(req);
		resp.sendRedirect(req.getContextPath());
	}
}
