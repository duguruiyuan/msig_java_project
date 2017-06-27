package tw.com.msig.web;

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
		// 取得登入者的Session並廢除
		final HttpSession session = req.getSession(false); // 若沒有session, 則回傳null
		if (session != null) {
			req.getSession().invalidate();
		}

		// 彈回登入畫面
		SecurityUtils.requireLogin(req, resp);
	}
}
