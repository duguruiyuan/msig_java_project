package tw.com.msig.web;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 共用的controller邏輯
 */
public abstract class AbstractController extends HttpServlet {

	/**
	 * 轉導到某個jsp上
	 */
	protected void toJsp(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/" + path + ".jsp");
		dispatcher.forward(req, resp);
	}

}
