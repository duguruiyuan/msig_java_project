package tw.com.msig.web;

import tw.com.msig.entity.User;
import tw.com.msig.util.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/login")
public class LoginController extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req, resp, "login");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得登入相關資料
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");

		// 登入實作
		final User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setLoginTime(LocalDateTime.now());

		// 將登入資料塞進session給其他功能用
		SecurityUtils.setLoginUser(req, user);

		// 轉導到index
		resp.sendRedirect("");
	}
}
