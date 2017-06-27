package tw.com.msig.web;

import tw.com.msig.util.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class IndexController extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 檢查是否有登入
		if (SecurityUtils.requireLogin(req, resp)) {

			// 將參數吐回畫面上顯示(這邊的參數只能在下一個畫面用)
			req.setAttribute("ip", req.getRemoteAddr());

			// 存在session內的參數會一直活著, jsp也拿得到所以不用特別塞

			// 轉導到jsp上
			toJsp(req, resp, "index");
		}

	}

}
