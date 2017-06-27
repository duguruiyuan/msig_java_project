package tw.com.msig.util;

import tw.com.msig.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class SecurityUtils {

	public static final String SESSION_USER_DATA = "user_data";
	public static final String LOGIN_URL = "login";

	/**
	 * 檢查是否有登入, 若無登入則回到登入畫面
	 */
	public static boolean requireLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		final HttpSession session = req.getSession();
		if (Objects.isNull(session.getAttribute(SESSION_USER_DATA))) {
			resp.sendRedirect(LOGIN_URL);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 將登入資料塞入
	 */
	public static void setLoginUser(HttpServletRequest req, User user) {
		req.getSession().setAttribute(SecurityUtils.SESSION_USER_DATA, user);
	}

	/**
	 * 取得目前登入者的資料
	 */
	public static User getLoginUser(HttpServletRequest req) {
		final Object user = req.getSession().getAttribute(SESSION_USER_DATA);
		return (User) user;
	}

}
